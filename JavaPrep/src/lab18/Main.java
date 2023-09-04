package lab18;

import lab18.Missions.MissionLoader;
import lab18.Missions.Missions;
import lab18.Missions.MoneyM;
import lab18.Missions.UpgradeM;
import lab18.Ships.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int defaultMoney = 100;
        String fileName = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab18\\Missions\\missions.txt";
        List<Ships> shipsPlayer1 = new ArrayList<>();
        shipsPlayer1.add(Scouts.scoutsDefault);
        shipsPlayer1.add(Tanks.tankDefault);
        shipsPlayer1.add(EscapeShip.escapeShipDefault);

        List<Ships> shipsPlayer2 = new ArrayList<>();
        shipsPlayer2.add(Scouts.scoutsDefault);
        shipsPlayer2.add(Tanks.tankDefault);
        shipsPlayer2.add(EscapeShip.escapeShipDefault);


        System.out.println("First player: Enter your name");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        player1.setPlayerLvl(5);
        System.out.println("Second player: Enter your name");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);
        player1.setPlayerMoney(defaultMoney);
        player2.setPlayerMoney(defaultMoney);
        System.out.println(player1.getName() + " has " + player1.getPlayerMoney() + " gold ");
        System.out.println(player2.getName() + " has " + player2.getPlayerMoney() + " gold ");
        PlayerShips playerShips1 = new PlayerShips(player1, shipsPlayer1);
        PlayerShips playerShips2 = new PlayerShips(player2, shipsPlayer2);
        player1.setPlayerHp(100);
        System.out.println("Game continues until one player reaches 0 hp");


//        ShipShop.printScoutShips();
//        shipsPlayer1.add(ShipShop.buyShips("scout1"));
//        System.out.println(shipsPlayer1.toString());
//        System.out.println(shipsPlayer2.toString());


        while(player1.getPlayerHp() > 0 || player2.getPlayerHp() > 0){
            System.out.println("Do you wish to go to a mission or buy a new ship(Mission)");
            String playerChoise = scanner.nextLine();
            switch (playerChoise) {
                case "Shop" -> {
                    ShipShop.printScoutShips();
                    System.out.println("Do you wish to buy/sell ships(Use)");
                    String choice = scanner.nextLine();
                    if (choice.equals("Buy")) {
                        System.out.println("Enter the ship name you want to buy(scout1)");
                        String nameShip = scanner.nextLine();
                        //                    Scouts purshasedScout = ShipShop.buyShips(nameShip);
                        //                    playerShips1.setScouts2(purshasedScout);
                    }
                }
                case "Mission" -> {
                    MissionLoader.importMissions(fileName);
                    System.out.println("Use your special scout ability to reveal missions and be able to choose what mission you want to do or get a random mission(Use)");
                    String choice = scanner.nextLine();
                    if (choice.equals("Use")) {
                        System.out.println("Enter the name of the ship you wanna use the ability(scoutDefault)");
                        String scoutName = scanner.nextLine();
                        for (Ships scouts : shipsPlayer1) {
                            if (scouts instanceof Scouts) {
                                if (((Scouts) scouts).specialUse(scoutName)) {
                                    for (MoneyM missions : MissionLoader.moneyMissions) {
                                        System.out.println(missions.toString());
                                    }
                                    for (UpgradeM missions : MissionLoader.upgradeMissions) {
                                        System.out.println(missions.toString());
                                    }
                                } else {
                                    System.out.println("Wrong name or no specials left");
                                }
                            }
                        }
                        System.out.println("Enter the lvl and type of mission you want to do(Upgrade 1/ Money 1)");
                        String choise = scanner.nextLine();
                        String[] parts = choise.split(" ");
                        if (parts[0].equals("Upgrade")) {
                            for (UpgradeM upgradeM : MissionLoader.upgradeMissions) {
                                if (Integer.parseInt(parts[1]) == upgradeM.getRequiredLvl()) {
                                    if (player1.getPlayerLvl() > upgradeM.getRequiredLvl()) {
                                        System.out.println("Mission passed. Upgrading ships");
                                        for (Ships scouts : shipsPlayer1) {
                                            scouts.setAttack(scouts.getAttack() + upgradeM.getAddStats());
                                            scouts.setDefence(scouts.getDefence() + upgradeM.getAddStats());
                                            scouts.setLvl(scouts.getLvl() + 1);

                                        }
                                    }
                                }
                            }
                        }
                        if (parts[0].equals("Money")) {
                            for (MoneyM moneyM : MissionLoader.moneyMissions) {
                                if (Integer.parseInt(parts[1]) == moneyM.getRequiredLvl()) {
                                    if (player1.getPlayerLvl() > moneyM.getRequiredLvl()) {
                                        System.out.println("Mission passed. Adding money");
                                        player1.setPlayerMoney(player1.getPlayerMoney() + moneyM.getAddGold());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(playerShips1);
            System.out.println(playerShips2);
            System.out.println("Attack phase. Player 1 attacks. Choose with which ship to attack(scoutDefault)");
            String name = scanner.nextLine();
            for (Ships ships : shipsPlayer1) {
                ships.setAttack(ships.getAttack() + 10);
            }


            for (Ships ships : shipsPlayer1) {
                if (ships.getName().equals(name)) {
                    System.out.println(name + " ready to attack. Choose which enemy ship to attack.(scoutDefault)");
                    String choice = scanner.nextLine();
                    for (Ships ships1 : shipsPlayer2) {
                        if (choice.equals(ships1.getName())) {
                            if (ships.getAttack() == ships1.getAttack()) {
                                player1.setPlayerHp(player1.getPlayerHp() - 40);
                                System.out.println("Attack succesfull");
                                System.out.println("Player 1 remaining hp: " + player1.getPlayerHp());
                            }
                        }
                    }

                }
            }

        }

    }
}
