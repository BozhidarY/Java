package lab18.Ships;

public class Scouts extends Ships {

    public static final Scouts scoutsDefault = new Scouts("scoutDefault", "100", 50, 50, 1, 25, 25, true);

    private int bonusSpeed;
    private boolean special;
    public Scouts(String name, String hp, int defence, int attack, int lvl, int price, int bonusSpeed, boolean special) {
        super(name, hp, defence, attack, lvl, price);
        this.bonusSpeed = bonusSpeed;
        this.special = special;
    }

    public int getBonusSpeed() {
        return bonusSpeed;
    }

    public void setBonusSpeed(int bonusSpeed) {
        this.bonusSpeed = bonusSpeed;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.SCOUT;
    }

    public boolean specialUse(String name){
        if(isSpecial() && name.equals(getName())){
            setSpecial(false);
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public String toString() {
        return "Scouts: " +
                "bonusSpeed=" + bonusSpeed +
                ", special= " + special + ".";
    }
}
