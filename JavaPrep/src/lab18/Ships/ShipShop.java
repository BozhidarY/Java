package lab18.Ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShipShop {
    public static List<Scouts> scoutShop = Collections.synchronizedList(new ArrayList<>());
    public static List<Tanks> tankShop = Collections.synchronizedList(new ArrayList<>());
    public static List<EscapeShip> escapeShipShop = Collections.synchronizedList(new ArrayList<>());

    static Scouts scouts1 = new Scouts("scout1", "60", 20, 10, 5, 50, true);
    static Scouts scouts2 = new Scouts("scout2", "80", 20, 10, 5, 80, true);

    static Tanks tanks1 = new Tanks("tank1", "200", 80, 50, 7, 15);
    static Tanks tanks2 = new Tanks("tank2", "150", 60, 100, 8, 25);

    static EscapeShip escapeShip1 = new EscapeShip("escapeShip1", "30", 20, 50, 3, 180);
    static EscapeShip escapeShip2 = new EscapeShip("escapeShip1", "30", 20, 50, 5, 200);

    public  static void printScoutShips(){
        scoutShop.add(scouts1);
        scoutShop.add(scouts2);
        tankShop.add(tanks1);
        tankShop.add(tanks2);
        escapeShipShop.add(escapeShip1);
        escapeShipShop.add(escapeShip2);

        for(Scouts scout: scoutShop){
            System.out.println(scout.toString());
        }
        for(Tanks tank: tankShop){
            System.out.println(tank.toString());
        }
        for(EscapeShip escapeShip: escapeShipShop){
            System.out.println(escapeShip.toString());
        }

    }
    public static Scouts buyShips(String name){
        Scouts scouts = null;
        for(Scouts scout: scoutShop){
            if(scout.getName().equals(name)){
                scouts = scout;
                scoutShop.remove(scout);
                break;
            }
        }
        return scouts;
    }

//    public static void sellShips(String name){
//        if()
//    }

}
