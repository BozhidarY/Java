package lab19;

import lab19.Users.UserDB;
import lab19.Users.Users;
import lab19.UsersEngine.LoadSaveUsersToJson;
import lab19.UsersEngine.LoginRegisterMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LoadSaveUsersToJson loadSaveUsersToJson = new LoadSaveUsersToJson();
        LoginRegisterMenu loginRegisterMenu = new LoginRegisterMenu();
        Scanner scanner = new Scanner(System.in);

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
