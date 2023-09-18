package lab8;



import lab8.Constructors.Concert;
import lab8.Constructors.VolleyBallMatch;

import java.io.IOException;

public class ProccesSales {
    static String fileName = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab8\\Files\\dailyTickets.txt";

    public static  Concert[] concerts;
    public static  VolleyBallMatch[] volleyBallMatches;

    public static void processTickets() throws IOException {

        TicketLoader productLoader = new TicketLoader(fileName);
        int concertIndex = 0;
        int volleyBallMatchIndex = 0;
        int concertID = 0;
        int volleyBallMatchID = 0;
        try{
            Object[] products = productLoader.importDateFromFile();
            for(Object product: products){
                if(product instanceof Concert){
                    concertIndex++;
                }
                if(product instanceof VolleyBallMatch){
                    volleyBallMatchIndex++;
                }
            }
            concerts = new Concert[concertIndex];
            volleyBallMatches = new VolleyBallMatch[volleyBallMatchIndex];

            for (Object product : products) {
                if (product instanceof Concert) {
                    concerts[concertID] = (Concert) product;
                    concertID++;
                }
                if (product instanceof VolleyBallMatch) {
                    volleyBallMatches[volleyBallMatchID] = (VolleyBallMatch) product;
                    volleyBallMatchID++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
