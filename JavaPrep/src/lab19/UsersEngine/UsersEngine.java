package lab19.UsersEngine;

import lab19.Users.UserDB;

import java.util.Scanner;

public class UsersEngine {
    Scanner scanner = new Scanner(System.in);
    LoginRegisterMenu loginRegisterMenu = new LoginRegisterMenu();
    LoadSaveUsers loadSaveUsers = new LoadSaveUsers();
    public void UsersEngine(){
        UserDB userDB = loadSaveUsers.loadUsers("D:\\Java Prep\\Java\\JavaPrep\\src\\lab19\\Users\\users.json");
        if(userDB.getUsersList().isEmpty()){
            userDB.addAdmins();
        }
        System.out.println("Login/Register");
        String choice = scanner.nextLine();
        switch (choice){
            case "Login" -> {
                loginRegisterMenu.login(userDB);
            }

            case "Register" -> loginRegisterMenu.register(userDB);
        }

        loadSaveUsers.saveUsers("D:\\Java Prep\\Java\\JavaPrep\\src\\lab19\\Users\\users.json", userDB);
    }
}
