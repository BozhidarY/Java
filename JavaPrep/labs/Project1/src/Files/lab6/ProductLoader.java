package Files.lab6;

//import constants.Constants;
import Files.lab6.entities.Book;
import Files.lab6.entities.Electronics;
import Files.lab6.entities.Provider;
import Files.lab6.validation.WrongPhoneNumberException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportData {
    private final String filePath = "Exception\\src\\Files\\lab6\\files\\salesproducts.txt";
//            Constants.SRC_DIR + "\\lab_exercises\\lab_6\\files\\salesproducts.txt";

    @Override
    public Object[] importDataFromFile() throws IOException {
        Object[] result = new Object[getNumberOfRows()];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java-TU\\Exception\\src\\Files\\lab6\\files\\salesproducts.txt"));  //new FileReader(filePath)
        int index = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split("#");
            switch (data[0]) {
                case "1":
                    Electronics electronics = null;
                    try {
                        electronics = new Electronics(data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    } catch (WrongPhoneNumberException e) {
                        System.err.println(e.getMessage());
                    }
                    result[index] = electronics;
                    index++;
                    break;
                case "2":
                    Book book = null;
                    try {
                        book = new Book(data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    } catch (WrongPhoneNumberException e) {
                        System.err.println(e.getMessage());
                    }
                    result[index] = book;
                    index++;
                    break;
            }
        }
        bufferedReader.close();
        return result;
    }

    private int getNumberOfRows() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while (bufferedReader.readLine() != null) {
            lines++;
        }
        bufferedReader.close();
        return lines;
    }
}
