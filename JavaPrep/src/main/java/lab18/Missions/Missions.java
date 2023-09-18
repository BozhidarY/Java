package lab18.Missions;

public class Missions {
    public enum missionType{
        UPGRADE,
        MONEY
    }

    public Missions(int requiredLvl) {
        this.requiredLvl = requiredLvl;
    }

    private int requiredLvl;

    public int getRequiredLvl() {
        return requiredLvl;
    }

    public void setRequiredLvl(int requiredLvl) {
        this.requiredLvl = requiredLvl;
    }

    @Override
    public String toString() {
        return "Missions{" +
                "requiredLvl=" + requiredLvl +
                '}';
    }
}
