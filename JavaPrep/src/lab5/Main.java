package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option;
        do{
            System.out.println("Enter Login/Register/Exit");
            option = scanner.nextLine();
            switch(option){
                case "Login" -> {
                    System.out.println("Login menu");
                    System.out.println("Enter username");
                    String username = scanner.nextLine();
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    String optionalLOgin = login(username,password);
                    System.out.println(optionalLOgin);
                }
                case "Register" -> {
                    System.out.println("Register menu");
                    System.out.println("Enter new username");
                    String username = scanner.nextLine();
                    System.out.println("Enter new password");
                    String password = scanner.nextLine();
                    System.out.println("Confirm password");
                    String confirmPassword = scanner.nextLine();
                    String optionRegister = register(username,password,confirmPassword);
                    System.out.println(optionRegister);
                }
                case "Print" -> {
                    System.out.println("Registered users in the system:");
                    for(User user:users){
                        System.out.println("Username: " + user.getName() + " |" + "Password: " + user.getPassword());
                    }
                }
                case "Exit" -> {
                    System.out.println("Exiting");
                    break;
                }
            }
        }while(!option.equals("Exit"));


    }
    private static String login(String userName, String password){
        for(User user: users ){
            if(user.getName().equals(userName) && user.getPassword().equals(password)) {
                return "Succesfull Login";
            }
        }
        return "Try again";
    }
    private static String register(String username, String password, String confirmPassword){
        for(User user: users) {
            if (user.getName().equals(username)) {
                return "Username is in use";
            }
            else if (user.getPassword().equals(password)) {
                return "Password is in use";
            }
        }
        if (!password.equals(confirmPassword)) {
            return "Passwords not matching";
        }
        try{
            users.add(new User(username,password));
        }catch(nameException | passwordException e){
            System.out.println("Error: " + e.getMessage() );
        }
        return "User added";
    }

}
