package lab19.UsersEngine;

import lab19.CommunicationEngine.UserCommunication;
import lab19.Users.*;

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
                if(user.getUserType() == UserType.ARTIST){
                    hasLoginOccured = true;
                    userCommunication.openArtistCommunication((Artists) user);
                }
                else if(user.getUserType() == UserType.CLIENT) {
                    hasLoginOccured = true;
                    userCommunication.openClientCommunication((Client) user, userDB);
                }
            }
        }
        if(username.equals(Admin.getAdmin().getUsername()) && password.equals(Admin.getAdmin().getPassword())){
            hasLoginOccured = true;
            userCommunication.openAdminCommunication(Admin.getAdmin(),userDB);
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
            System.out.println("Do you want to create Client or Artist account.\n (Client/Artist)");
            String choice = scanner.nextLine();
            switch(choice){
                case "Artist" -> {
                    Artists artists = new Artists(username, password);
                    userDB.getUsersList().add(artists);
                    System.out.println("You have registered successfully");
                    userCommunication.openArtistCommunication(artists);
                }
                case "Client" -> {
                    Client client = new Client(username,password);
                    userDB.getUsersList().add(client);
                    System.out.println("You have registered successfully");
                    userCommunication.openClientCommunication(client, userDB);
                }
            }
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
