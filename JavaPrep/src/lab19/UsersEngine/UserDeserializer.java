package lab19.UsersEngine;

import com.google.gson.*;
import lab19.Librarys.Library;
import lab19.Librarys.Playlists;
import lab19.Songs.Songs;
import lab19.Users.Artists;
import lab19.Users.Client;
import lab19.Users.UserType;
import lab19.Users.Users;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDeserializer implements JsonDeserializer<Users> {
    @Override
    public Users deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
        UserType userType = UserType.valueOf(jsonObject.get("userType").getAsString());


        Users users = null;

        if (userType == UserType.CLIENT) {
            Client client = new Client(username, password);

            JsonObject libraryJson = jsonObject.getAsJsonObject("library");
            Library library = new Library(client.getUsername() + " library");

            JsonArray playlistsArray = libraryJson.getAsJsonArray("libraryPlaylists");
            List<Playlists> playlistsList = new ArrayList<>();

            if (playlistsArray != null) {
                for (JsonElement playlistElement : playlistsArray) {
                    JsonObject playlistJson = playlistElement.getAsJsonObject();

                    String playlistName = playlistJson.get("playlistName").getAsString();

                    JsonArray songPlaylistArray = playlistJson.getAsJsonArray("songPlaylist");
                    List<Songs> songPlaylist = new ArrayList<>();

                    if (songPlaylistArray != null) {
                        for (JsonElement songElement : songPlaylistArray) {
                            Songs song = new Gson().fromJson(songElement, Songs.class);
                            songPlaylist.add(song);
                        }
                    }
                    Playlists playlists = new Playlists(playlistName);

                    playlists.setSongPlaylist(songPlaylist);
                    playlistsList.add(playlists);
                }
            }
            library.setLibraryList(playlistsList);
            client.setLibrary(library);
            client.setUserType(userType);

            users = client;
        }
        else if(userType == UserType.ARTIST){
            Artists artists = new Artists(username, password);

            JsonElement monthlyListenersElement = jsonObject.get("Listeners");
            if (monthlyListenersElement != null) {
                long monthlyListeners = monthlyListenersElement.getAsLong();
                artists.setMonthlyListeners(monthlyListeners);
            }

//            JsonArray songsArray = jsonObject.getAsJsonArray("songsList");
//            List<Songs> songsList = new ArrayList<>();
//
//            if (songsArray != null) {
//                for (JsonElement songElement : songsArray) {
//                    Songs song = new Gson().fromJson(songElement, Songs.class);
//                    songsList.add(song);
//                }
//            }
//            artists.setSongsList(songsList);
            users = artists;
        }
        return users;
    }
}
