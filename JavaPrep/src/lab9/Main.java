package lab9;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongEmailException {
        String filePath = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab9\\nameAndPass.txt";
        User user = new User("A", "admin");
        user.addUser(user.getNickname(), user.getPassword());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        try {
            if (User.checkNameAndPass(new File(filePath), name, password)) {
                System.out.println("Correct");
            } else {
                System.out.println("False");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
