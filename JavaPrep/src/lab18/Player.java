package lab18;

import lab18.Missions.Missions;
import lab18.Missions.MoneyM;

public class Player {
    public enum status{
        FIGHT, MISSION
    }
    private String name;
    private int playerLvl;
    private int playerMoney;
    private int playerHp;



    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerLvl() {
        return playerLvl;
    }

    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public void setPlayerHp(int playerHp) {
        this.playerHp = playerHp;
    }

    @Override
    public String toString() {
        return "Player: " +
                "name= " + name +
                ", playerLvl= " + playerLvl +
                ", playerMoney= " + playerMoney +
                ", playerHp= " + playerHp + '\n'
                ;
    }
}
