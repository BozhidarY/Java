package lab8;


import lab8.Constructors.Concert;
import lab8.Constructors.VolleyBallMatch;
import lab8.Exceptions.NoMoreTicketException;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try{

            ProccesSales.processTickets();
            Concert concert = ProccesSales.concerts[0];
            concert.sellTicket(200);
            System.out.println(Arrays.toString(ProccesSales.concerts));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoMoreTicketException e) {
            throw new RuntimeException(e);
        }
    }
}
