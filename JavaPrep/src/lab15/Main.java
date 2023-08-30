package lab15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab15\\file.txt";
        String filePath2 = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab15\\file2.txt";
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath2));

//            ---------------------------------------Swap lines----------------------------------

//            String line;

//            while ((line = bufferedReader.readLine()) != null) {
//                lines.add(line);
//
//            }
//            bufferedReader.close();
//            String temp = lines.get(1);
//            lines.set(1, lines.get(2));
//            lines.set(2, temp);
//            for(String string:lines){
//                bufferedWriter.write(string);
//                bufferedWriter.newLine();
//            }
//
//            bufferedWriter.close();

//            -------------------------------Swap words--------------------------------------

            String line;
            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
            String[] part = lines.get(1).split(" ");
            String temp = part[1];
            part[2] = part[1];
            part[2] = temp;
            for(String string:part){
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
