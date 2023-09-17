package lab19.CommunicationEngine;

import lab19.Songs.LoadSongs;
import lab19.Songs.SongData;
import lab19.Songs.Songs;
import lab19.Users.*;
import lab19.UsersEngine.LoadSaveUsersToJson;
import lab5.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCommunication {
    Scanner scanner = new Scanner(System.in);
    LoadSongs loadSongs = new LoadSongs();
    SongData songData = new SongData();
    ClientCommunicationMethods clientCommunicationMethods = new ClientCommunicationMethods();
    LoadSaveUsersToJson loadSaveUsersToJson = new LoadSaveUsersToJson();

    ArtistCommunicationMethods artistCommunicationMethods = new ArtistCommunicationMethods();
    AdminCommunicationMethods adminCommunicationMethods = new AdminCommunicationMethods();


    public void openClientCommunication(Client client, UserDB userDB) {
        songData = loadSongs.loadFromFile(Songs.SONG_JSON_PATH);

        clientCommunicationMethods.openMessage(client);

        String choice = scanner.nextLine();
        while (!choice.equals("Exit")) {
            switch (choice.toUpperCase()) {
                case "LISTEN" -> {
                    System.out.println("Search for a song/ Listen to a random one/Listen to a song from a playlist of yours");
                    System.out.println("List of commands: Search/Random/Playlist");
                    String listenChoice = scanner.nextLine();
                    switch (listenChoice.toUpperCase()) {
                        case "SEARCH" -> clientCommunicationMethods.searchBar(client,songData);
                        case "RANDOM" -> clientCommunicationMethods.randomSong(client,songData);
                        case "PLAYLIST" -> clientCommunicationMethods.playlistListen(client);
                        default -> {
                            System.out.println("Invalid Input");
                        }
                    }
                }
                case "EDIT" -> {
                    System.out.println("In case 'Edit' you can do 4 things. Add/Delete a playlist to/from your library or " +
                            "Add/Delete a song to/from a playlist");
                    System.out.println("List of commands: AddPlaylist/DeletePlaylist/AddSong/DeleteSong");
                    String choiceEdit = scanner.nextLine();
                    switch (choiceEdit.toUpperCase()) {
                        case "ADDPLAYLIST" -> clientCommunicationMethods.addPlaylist(client);
                        case "DELETEPLAYLIST" -> clientCommunicationMethods.deletePlaylist(client);
                        case "ADDSONG" -> clientCommunicationMethods.addSong(client, songData);
                        case "DELETESONG" -> clientCommunicationMethods.deleteSong(client);
                        default -> {
                            System.out.println("Invalid Input");
                        }
                    }
                }
                case "IMPORT" -> clientCommunicationMethods.importLibrary(client, userDB);
                default -> {
                    System.out.println("Invalid Input");
                }
            }
            System.out.println("Choose a new mode or exit the programm(Listen, Edit, Import, Exit)");
            choice = scanner.nextLine();
        }
    }
    public void openAdminCommunication(Admin admin, UserDB userDB){
        System.out.println("Do you want to delete or recover account");
        String choice = scanner.nextLine();
        switch(choice){
            case "Recover" -> adminCommunicationMethods.recoverAccount(admin, userDB);
            case "Delete" -> adminCommunicationMethods.deleteAccount(admin, userDB);
        }
    }
    public void openArtistCommunication(Artists artist){
        artistCommunicationMethods.printArtistSongs(songData,artist);
        artistCommunicationMethods.addSongToJson(songData, artist);
    }
}
