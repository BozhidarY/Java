package lab19;

import lab19.Songs.LoadSongs;
import lab19.Users.UserDB;
import lab19.UsersEngine.UsersEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoadSongs loadSongs = new LoadSongs();
        UsersEngine usersEngine = new UsersEngine();
//        UserDB userDB = new UserDB();

        usersEngine.UsersEngine();






        //        loadSongs.loadFromFile("D:\\Java Prep\\Java\\JavaPrep\\src\\lab19\\Songs\\songsFile.json");
    }
}
