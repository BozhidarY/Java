package lab19.UsersEngine;

import lab19.Users.UserDB;
import lab19.Users.Users;
import lab5.User;

import java.util.Scanner;

public class UsersEngine {
    Scanner scanner = new Scanner(System.in);
    LoginRegisterMenu loginRegisterMenu = new LoginRegisterMenu();
    LoadSaveUsersToJson loadSaveUsersToJson = new LoadSaveUsersToJson();
    public void UsersEngine(){

       UserDB userDB;
       userDB = loadSaveUsersToJson.loadUsers(Users.USERS_JSON_PATH);

        System.out.println("Login/Register");
        String choice = scanner.nextLine();
        switch (choice){
            case "Login" -> loginRegisterMenu.login(userDB);

            case "Register" -> loginRegisterMenu.register(userDB);
        }

        loadSaveUsersToJson.saveUsers(Users.USERS_JSON_PATH, userDB);


    }
}
