package lab19;

import lab19.Playlists.Library;
import lab19.Playlists.Playlists;
import lab19.Users.Client;
import lab19.Users.Users;

public class UserCommunication {
    public void openClientCommunication(Users user){
        Client client = null;
        if(user instanceof Client){
            client = (Client) user;
        }
        System.out.println("You re logined as an " + user.getUserType());
        System.out.println("As an Client you can create a playlists and add songs to it/" +
                "You can play songs without adding them to a playlist/" +
                "and if you liked the song you can favourite it");
    }

    public void openAdminCommunication(Users user){
        System.out.println("You re logined as an " + user.getUserType());
    }
}
