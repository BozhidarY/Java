package MusicConsoleApp.CommunicationEngine;

import MusicConsoleApp.Users.Admin;
import MusicConsoleApp.Users.UserDB;
import MusicConsoleApp.Users.Users;
import MusicConsoleApp.UsersEngine.LoadSaveUsersToJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminCommunicationMethods {
    Scanner scanner = new Scanner(System.in);
    LoadSaveUsersToJson loadSaveUsersToJson = new LoadSaveUsersToJson();

    public void deleteAccount(Admin admin, UserDB userDB) {
        UserDB userDB1 = new UserDB();
        List<Users> removedAccounts = new ArrayList<>();
        System.out.println("You re logged in as an " + admin.getUserType());
        System.out.println("As an admin you can delete and recover profiles");
        System.out.println("Enter account username you want to remove");
        String userName = scanner.nextLine();
        userDB.getUsersList().forEach(user -> {
            if (userName.equals(user.getUsername())) {
                removedAccounts.add(user);
                userDB1.getUsersList().add(user);

            }
        });
        userDB.getUsersList().removeAll(removedAccounts);
        loadSaveUsersToJson.saveUsers(Users.DELETEDUSERS_JSON_PATH, userDB1);
    }

    public void recoverAccount(Admin admin, UserDB userDB) {
        UserDB userDB1;
        userDB1 = loadSaveUsersToJson.loadUsers(Users.DELETEDUSERS_JSON_PATH);
        System.out.println("Enter the name of the account you want to recover");
        String nameAcc = scanner.nextLine();
        for (Users user : userDB1.getUsersList()) {
            if (nameAcc.equals(user.getUsername())) {
                userDB.getUsersList().add(user);
            }
        }
    }
}
