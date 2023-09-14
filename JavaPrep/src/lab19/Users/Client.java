package lab19.Users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lab19.Playlists.Library;
import lab19.Playlists.Playlists;

public class Client extends Users {

    private Library library;
    private Playlists playlists;

    public Client(String username, String password) {
        super(username, password);
        this.library = new Library(getUsername() + "'library");
        this.playlists = new Playlists("defaultPlaylist");
        this.setUserType(UserType.CLIENT);
        library.getLibraryList().add(playlists);
    }

    public Library getLibrary() {
        return library;
    }
    public void setLibrary(Library library) {
        this.library = library;
    }

    public Playlists getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }
}
