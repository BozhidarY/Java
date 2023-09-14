package lab19.Songs;

public class Songs {
    private String name;
    private String artist;
    private String duration;
    private boolean liked;

    public Songs(String name, String artist, String duration, boolean liked) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.liked = liked;
    }

    public int durationStringToSeconds(String duration) {
        String[] parts = duration.split(":");

        if (parts.length == 2) {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return (minutes * 60) + seconds;
        } else {
            // Handle invalid input
            throw new IllegalArgumentException("Invalid duration format: " + duration);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
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
