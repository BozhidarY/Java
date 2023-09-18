package lab17.zad3;

public class Player {
    private String name;
    private int lapTime;

    public Player(String name, int lapTime) {
        this.name = name;
        this.lapTime = lapTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLapTime() {
        return lapTime;
    }

    public void setLapTime(int lapTime) {
        this.lapTime = lapTime;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lapTime=" + lapTime +
                '}';
    }
}
