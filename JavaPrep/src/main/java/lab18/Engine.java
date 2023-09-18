package lab18;

import lab18.Exception.ByingException;
import lab18.Missions.MissionLoader;
import lab18.Missions.MoneyM;
import lab18.Missions.UpgradeM;
import lab18.Ships.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    String fileName = "D:\\Java Prep\\Java\\JavaPrep\\src\\lab18\\Missions\\missions.txt";
    public void startGame(Player player, Scanner scanner){
        player.getPlayerShips().add(Scouts.scoutsDefault);
        player.getPlayerShips().add(Tanks.tankDefault);
        player.getPlayerShips().add(EscapeShip.escapeShipDefault);

        System.out.println(player.getName() + " has " + player.getPlayerMoney() + " gold ");
    }

    public void standbyPhase(Player player, Scanner scanner) throws ByingException {
        System.out.println(player.getName() + ", do you wish to go to a mission or buy a new ship(Mission)");
            String playerChoise = scanner.nextLine();
            switch (playerChoise) {
                case "Shop" -> {
                    ShipShop.printScoutShips();
                    System.out.println(player.getName() + ", do you wish to buy/sell ships(Buy)");
                    String choice = scanner.nextLine();
                    if (choice.equals("Buy")) {
                        System.out.println("Enter the ship name you want to buy(scout1)");
                        String nameShip = scanner.nextLine();
                        player.getPlayerShips().add(ShipShop.buyShips(nameShip, player));
                        System.out.println(player.getName() + " has " + player.getPlayerMoney() + " remaining money." );
                    }
                    else if(choice.equals("Sell")){
                        System.out.println("Enter the ship name you want to sell(scoutDefault)");
                        String nameShip = scanner.nextLine();
                        ShipShop.sellShips(nameShip, player);
                    }
                }
                case "Mission" -> {
                    MissionLoader.importMissions(fileName);
                    System.out.println("Use your special scout ability to reveal missions and be able to choose what mission you want to do or get a random mission(Use)");
                    String choice = scanner.nextLine();
                    if (choice.equals("Use")) {
                        System.out.println("Enter the name of the ship you wanna use the ability(scoutDefault)");
                        String scoutName = scanner.nextLine();
                        for (Ships scouts : player.getPlayerShips()) {
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
                                    if (player.getPlayerLvl() > upgradeM.getRequiredLvl()) {
                                        System.out.println("Mission passed. Upgrading ships");
                                        for (Ships scouts : player.getPlayerShips()) {
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
                                    if (player.getPlayerLvl() > moneyM.getRequiredLvl()) {
                                        System.out.println("Mission passed. Adding money");
                                        player.setPlayerMoney(player.getPlayerMoney() + moneyM.getAddGold());
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    public boolean fightPhaseRow(Random random){
        int randomNumber = random.nextInt(2) + 1;
        return randomNumber == 1;
    }
    public void fightPhase(Player player1, Player player2, Scanner scanner){
        System.out.println("Attack phase. " + player1.getName() + " attacks. Choose with which ship to attack(scoutDefault)");
        String name = scanner.nextLine();
        for (Ships ships : player1.getPlayerShips()) {
            ships.setAttack(ships.getAttack() + 10);
        }

        for (Ships ships : player1.getPlayerShips()) {
            if (ships.getName().equals(name)) {
                System.out.println(name + " ready to attack. Choose which enemy ship to attack.(scoutDefault)");
                String choice = scanner.nextLine();
                for (Ships ships1 : player2.getPlayerShips()) {
                    if (choice.equals(ships1.getName())) {
                        if (ships.getAttack() == ships1.getAttack()) {
                            player1.setPlayerHp(player1.getPlayerHp() - 40);
                            System.out.println("Attack succesfull");
                            System.out.println(player1.getName() + " remaining hp: " + player1.getPlayerHp());
                        }
                    }
                }

            }
        }

    }

}
