package lab18.Missions;

import lab18.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MissionLoader {
    private String fileName;
    public static List<MoneyM> moneyMissions = new ArrayList<>();
    public static List<UpgradeM> upgradeMissions = new ArrayList<>();

    public static void importMissions(String fileName){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null){
                String[] part = currentLine.split(" ");
                if(currentLine.startsWith("UPGRADE")){
                    UpgradeM upgradeM = new UpgradeM(Missions.missionType.valueOf(part[0]), Integer.parseInt(part[1]), Integer.parseInt(part[2]));
                    upgradeMissions.add(upgradeM);
                }
                if(currentLine.startsWith("MONEY")){
                    MoneyM moneyM = new MoneyM(Missions.missionType.valueOf(part[0]), Integer.parseInt(part[1]), Integer.parseInt(part[2]));
                    moneyMissions.add(moneyM);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void completedMission(Missions.missionType missionType, Player player){
//        switch (missionType){
//            case MONEY -> {
//                for()
//            }
//        }
//    }
}
