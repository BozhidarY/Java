package lab6;

import lab6.Constructor.Electronics;
import lab6.Constructor.Provider;
import lab6.Exceptions.NoMoreProductsException;
import lab6.Exceptions.WrongPhoneNumberException;
import lab6.Interfaces.ImportData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader implements ImportData {
    private String fileName;

    public ProductLoader(String fileName) {
        this.fileName = fileName;
    }
    int index = 0;

    @Override
    public Object[] importDataFromFile() throws IOException {
        Object[] objects = new Object[getNumberOfRows()];
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] part = currentLine.split("#");
                if (part[0].equals("1")) {
                    Provider provider = new Provider(part[1], part[2]);
                    Electronics electronics = new Electronics(Integer.parseInt(part[3]), Double.parseDouble(part[4]), Integer.parseInt(part[5]), part[6], part[7],part[8]);
                    objects[index++] = electronics;
                }
            }
        } catch (WrongPhoneNumberException e) {
            throw new RuntimeException(e);
        } catch (NoMoreProductsException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public int getNumberOfRows() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int count = 0;
        while(bufferedReader.readLine() != null){
            count++;
        }
        bufferedReader.close();
        return count;
    }
}
