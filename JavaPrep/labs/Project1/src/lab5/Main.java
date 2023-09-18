package lab5;

//import lab_exercises.lab_5.exceptions.WrongPasswordException;
//import lab_exercises.lab_5.exceptions.WrongPhoneNumberException;
//import lab_exercises.lab_5.exceptions.WrongUserException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        String cmd;
        Scanner scanner = new Scanner(System.in);
        do {
            cmd = scanner.next();
            switch (cmd) {
                case "login" -> {
                    String username = scanner.next();
                    String password = scanner.next();
                    String loginMessage = login(username, password);
                    System.out.println(loginMessage);
                }
                case "register" -> {
                    String newUser = scanner.next();
                    String newPass = scanner.next();
                    String confirmPass = scanner.next();
                    String phone = scanner.next();
                    String registerMessage = register(newUser, phone, newPass, confirmPass);
                    System.out.println(registerMessage);
                }
                default -> {
                    if (cmd.equals("exit")){
                        break;
                    }
                    System.out.println("Incorrect command");
                }
            }
        }while (!cmd.equals("exit"));
    }

    private static String register(String newUser, String phone, String newPass, String confirmPass) {
        for (User user : users) {
            if (user.getName().equals(newUser)){
                return "User already exists";
            }
        }
        if (!newPass.equals(confirmPass)){
            return "Passwords are not the same";
        }
        try {
            users.add(new User(newUser, newPass, phone));
        } catch (WrongPhoneNumberException | WrongPasswordException | WrongUserException e) {
            System.err.println(e.getMessage());
            return "User is not registered";
        }
        return "Welcome!";
    }

    private static String login(String username, String password) {
        for (User user : users) {
            if (user.getName().equals(username) && user.getPassword().equals(password)){
                return "You are in";
            }
        }
        return "User not found, please register first";
    }
}
