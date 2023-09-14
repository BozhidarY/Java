package lab19.UsersEngine;

import lab19.UserCommunication;
import lab19.Users.Client;
import lab19.Users.UserDB;
import lab19.Users.UserType;
import lab19.Users.Users;

import java.util.Scanner;

public class LoginRegisterMenu {
    Scanner scanner = new Scanner(System.in);
    UserCommunication userCommunication = new UserCommunication();
    String username;
    String password;

    public void UserInput(){
        System.out.println("Enter username");
        username = scanner.nextLine();
        System.out.println("Enter password");
        password = scanner.nextLine();
    }
    public void loginCheck(UserDB userDB){
        boolean hasLoginOccured = false;
        for(Users user: userDB.getUsersList()) {
            if (user.getUsername().equals(username) && password.equals(user.getPassword())) {
                if(user.getUserType() == UserType.ADMIN){
                    hasLoginOccured = true;
                    userCommunication.openAdminCommunication(user);
                }
                else {
                    hasLoginOccured = true;
                    userCommunication.openClientCommunication(user);
                }
            }
        }
        if(!hasLoginOccured){
            System.out.println("No such credentials. You need to register");
            register(userDB);
        }
    }
    public boolean dublicationCheck(UserDB userDB) {
        for (Users user : userDB.getUsersList()) {
            if (user.getUsername().equals(username)) {
                System.out.println("The username is taken");
                return true;
            }
        }
        return false;
    }

    public void register(UserDB userDB) {
        System.out.println("Register Form: ");
        UserInput();
        if(!dublicationCheck(userDB)){
            Client client = new Client(username, password);
            userDB.getUsersList().add(client);
            System.out.println("You have registered successfully");
            userCommunication.openClientCommunication(client);
        }
        else {
            System.out.println("Try register again or go to login form(Register/Login)");
            String choice = scanner.nextLine();
            if(choice.equals("Register")){
                register(userDB);
            }
            else if (choice.equals("Login")){
                login(userDB);
            }

        }
    }
    public void login(UserDB userDB){
        System.out.println("Login Form: ");
        UserInput();
        loginCheck(userDB);
    }
}
