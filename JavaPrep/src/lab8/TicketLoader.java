package lab8;

import lab8.Constructors.Concert;
import lab8.Constructors.Event;
import lab8.Constructors.VolleyBallMatch;
import lab8.Exceptions.UnrecognisedRowException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TicketLoader implements Importable {
   private String fileName;

    public TicketLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object[] importDateFromFile() throws IOException {
        Object[] objects = new Object[countRows()];
        int index = 0;
        String currentLine;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while((currentLine = bufferedReader.readLine()) != null){
                String[] part = currentLine.split("#");
                if(currentLine.startsWith("1")){
                    Concert concert = new Concert(part[1], part[2], part[3], part[4], Integer.parseInt(part[5]), Double.parseDouble(part[6]));
                    objects[index++] = concert;
                }
                else if(currentLine.startsWith("2")) {
                    VolleyBallMatch volleyBallMatch = new VolleyBallMatch(part[1], part[2], part[3], part[4], part[5],  Integer.parseInt(part[6]), Double.parseDouble(part[7]));
                    objects[index++] = volleyBallMatch;
                }
                else{
                    throw new UnrecognisedRowException();
                }
            }
        }
        catch(UnrecognisedRowException e){
            System.out.println(e.getMessage());
        }
        return objects;
    }

    public int countRows() throws IOException{
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while(bufferedReader.readLine() != null){
            count++;
        }
        bufferedReader.close();
        return count;
    }
}
