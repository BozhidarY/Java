package lab18.Ships;

public class Tanks extends Ships {

    public static final Tanks tankDefault = new Tanks("tankDefault", "100", 50, 50, 1, 25);

    private int bonusArmor;

    public Tanks(String name, String hp, int defence, int attack, int lvl, int bonusArmor) {
        super(name, hp, defence, attack, lvl);
        this.bonusArmor = bonusArmor;
    }

    public int getBonusArmor() {
        return bonusArmor;
    }

    public void setBonusArmor(int bonusArmor) {
        this.bonusArmor = bonusArmor;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.TANK;
    }

    @Override
    public String toString() {
        return "Tanks: " +
                super.toString() +
                ", bonusArmor= " + bonusArmor + ".";
    }
}
