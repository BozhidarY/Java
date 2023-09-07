package lab18.Ships;

import lab18.Exception.ByingException;
import lab18.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShipShop {
    public static List<Ships> shipShop = Collections.synchronizedList(new ArrayList<>());

    static Scouts scouts1 = new Scouts("scout1", "60", 20, 10, 5, 50, 25, true);
    static Scouts scouts2 = new Scouts("scout2", "80", 20, 10, 5, 80, 25, true);

    static Tanks tanks1 = new Tanks("tank1", "200", 80, 50, 7, 15, 15);
    static Tanks tanks2 = new Tanks("tank2", "150", 60, 100, 8, 25, 20);

    static EscapeShip escapeShip1 = new EscapeShip("escapeShip1", "30", 20, 50, 3, 60, 200);
    static EscapeShip escapeShip2 = new EscapeShip("escapeShip1", "30", 20, 50, 5, 60, 170);

    public  static void printScoutShips(){
        shipShop.add(scouts1);
        shipShop.add(scouts2);
        shipShop.add(tanks1);
        shipShop.add(tanks2);
        shipShop.add(escapeShip1);
        shipShop.add(escapeShip2);

        for (Ships ships: shipShop){
            System.out.println(ships.toString());
        }

    }
    public static Ships buyShips(String name, Player player) throws ByingException {
        Ships boughtShip = null;
        for(Ships ships: shipShop){
            if(ships.getName().equals(name) && player.getPlayerMoney() >= ships.getPrice()){
                boughtShip = ships;
                shipShop.remove(ships);
                player.setPlayerMoney(player.getPlayerMoney() - ships.getPrice());
                break;
            }
            else{
                throw new ByingException();
            }
        }
        return boughtShip;
    }
    public static void sellShips(String name, Player player){
        Iterator<Ships> iterator = player.getPlayerShips().iterator();
        while(iterator.hasNext()){
            Ships ships = iterator.next();
            List<Scouts> scouts = new ArrayList<>();
            if(ships instanceof Scouts){
                scouts.add((Scouts) ships);
            }
            if(!scouts.isEmpty() && name.equals(ships.getName())){
//                player.getPlayerShips().remove(ships);
                iterator.remove();
                player.setPlayerMoney(player.getPlayerMoney() + ships.getPrice());
                shipShop.add(ships);
            }
            else{
                System.out.println("You cant sell ships if you have only 1 from that type");
            }
        }

    }

//    public static void sellShips(String name){
//        if()
//    }

}
