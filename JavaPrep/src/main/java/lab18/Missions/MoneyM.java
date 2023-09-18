package lab18.Missions;

public class MoneyM extends Missions{
    private missionType missionType;
    private int addGold;
    public MoneyM(missionType missionType, int requiredLvl, int addGold) {
        super(requiredLvl);
        this.missionType = missionType;
        this.addGold = addGold;
    }

    public Missions.missionType getMissionType() {
        return missionType;
    }

    public void setMissionType(Missions.missionType missionType) {
        this.missionType = missionType;
    }

    public int getAddGold() {
        return addGold;
    }

    public void setAddGold(int addGold) {
        this.addGold = addGold;
    }

    @Override
    public String toString() {
        return "MoneyM{" +
                super.toString() +
                "missionType=" + missionType +
                ", addGold=" + addGold +
                '}';
    }
}
