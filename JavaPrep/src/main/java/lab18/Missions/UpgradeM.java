package lab18.Missions;

public class UpgradeM extends Missions{

    private missionType missionType;
    private int addStats;
    public UpgradeM(missionType missionType,int requiredLvl, int addStats) {
        super(requiredLvl);
        this.missionType = missionType;
        this.addStats = addStats;
    }

    public Missions.missionType getMissionType() {
        return missionType;
    }

    public void setMissionType(Missions.missionType missionType) {
        this.missionType = missionType;
    }

    public int getAddStats() {
        return addStats;
    }

    public void setAddStats(int addStats) {
        this.addStats = addStats;
    }

    @Override
    public String toString() {
        return "UpgradeM{" +
                super.toString() +
                "missionType=" + missionType +
                ", addStats=" + addStats +
                '}';
    }
}
