package lab19.Users;

import lab19.Songs.Songs;

import java.util.ArrayList;
import java.util.List;

public class Artists  extends Users{

    private long monthlyListeners = 0;
//    private List<Songs> songsList;
    public Artists(String username, String password) {
        super(username, password);
//        this.songsList = new ArrayList<>();
        setUserType(UserType.ARTIST);
    }

    public void listenToSong() {
        this.monthlyListeners++;
    }

//    public List<Songs> getSongsList() {
//        return songsList;
//    }
//
//    public void setSongsList(List<Songs> songsList) {
//        this.songsList = songsList;
//    }

    public long getMonthlyListeners() {
        return monthlyListeners;
    }

    public void setMonthlyListeners(long monthlyListeners) {
        this.monthlyListeners = monthlyListeners;
    }
}
