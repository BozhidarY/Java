package lab18;

import lab18.Missions.Missions;
import lab18.Ships.EscapeShip;
import lab18.Ships.Scouts;
import lab18.Ships.Ships;
import lab18.Ships.Tanks;

import java.util.List;

public class PlayerShips {
    private Player player;
    private List<Ships> shipsList;
    public PlayerShips(Player player, List<Ships> shipsList){
        this.player = player;
        this.shipsList = shipsList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Ships> getShipsList() {
        return shipsList;
    }

    public void setShipsList(List<Ships> shipsList) {
        this.shipsList = shipsList;
    }

    @Override
    public String toString() {
        return "PlayerShips: " + "\n" +
                player +
                shipsList;
    }
}
