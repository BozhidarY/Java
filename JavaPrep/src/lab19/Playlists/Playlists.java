package lab19.Playlists;

import lab19.Songs.Songs;

import java.util.ArrayList;
import java.util.List;

public class Playlists {
    private List<Songs> songPlaylist;
    private String playlistName;

    public Playlists(String playlistName){
        this.playlistName = playlistName;
        this.songPlaylist = new ArrayList<>();
    }

    public List<Songs> getSongPlaylist() {
        return songPlaylist;
    }

    public void setSongPlaylist(List<Songs> songPlaylist) {
        this.songPlaylist = songPlaylist;
    }
}
