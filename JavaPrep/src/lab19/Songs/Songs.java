package lab19.Songs;

import lab19.Users.Artists;

public class Songs {
    private String name;
//    private Artists artist;
    private Artists artist;
    private String duration;
    private boolean liked;

    public static final String SONG_JSON_PATH = System.getProperty("user.dir") + "\\src\\lab19\\Songs\\songsFile.json";

    public Songs(String name,Artists artist) {
        this.name = name;
        this.artist = artist;
        setDuration("0:05");
        setLiked(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", liked=" + liked;
    }
}
