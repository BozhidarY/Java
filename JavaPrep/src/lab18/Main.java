package lab18;

import lab18.Exception.ByingException;
import lab18.Missions.MissionLoader;
import lab18.Missions.Missions;
import lab18.Missions.MoneyM;
import lab18.Missions.UpgradeM;
import lab18.Ships.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Engine engine = new Engine();
        Random random = new Random();
        boolean fightTurn = engine.fightPhaseRow(random);

        System.out.println("First player: Enter your name");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        System.out.println("Second player: Enter your name");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);
        engine.startGame(player1, scanner);
        engine.startGame(player2, scanner);
        System.out.println("Game continues until one player reaches 0 hp");
//        ShipShop.printScoutShips();

        try{
            while(player1.getPlayerHp() > 0 || player2.getPlayerHp() > 0){
                engine.standbyPhase(player1, scanner);
                engine.standbyPhase(player2, scanner);
                if(fightTurn){
                    engine.fightPhase(player1, player2, scanner);
                    fightTurn = false;
                }
                else {
                    engine.fightPhase(player2, player1, scanner);
                    fightTurn = true;
                }
            }
        } catch (ByingException e) {
            System.out.println(e.getMessage());
        }


    }
}
