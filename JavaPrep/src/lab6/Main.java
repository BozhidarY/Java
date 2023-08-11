package lab6;

import lab6.Constructor.Book;
import lab6.Constructor.Electronics;
import lab6.Constructor.Product;
import lab6.Constructor.Provider;
import lab6.Exceptions.NoMoreProductsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        try{
//            Book book = new Book(1, 10.5, 12, "Tesla", "Bojdiar", "Title");
//            book.sellProductPrice(15);
//            System.out.println(book.getQuantity());
//        } catch (NoMoreProductsException e) {
//            System.out.println(e.getMessage());
//        }

        String fileName = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab6\\Files\\salesproducts.txt";
        ProductLoader productLoader = new ProductLoader(fileName);

        try {
            Object[] products = productLoader.importDataFromFile();
            for (Object product : products) {
                if (product instanceof Electronics) {
                    System.out.println(product.toString());
                } else if (product instanceof Book) {
                    System.out.println("Book: " + product.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
