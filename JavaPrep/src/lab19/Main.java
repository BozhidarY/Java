package lab19;

import lab19.Songs.LoadSongs;
import lab19.Songs.SongData;
import lab19.Users.Artists;
import lab19.Users.UserDB;
import lab19.UsersEngine.LoadSaveUsersToJson;
import lab19.UsersEngine.UsersEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UsersEngine usersEngine = new UsersEngine();

        usersEngine.UsersEngine();
    }
}
