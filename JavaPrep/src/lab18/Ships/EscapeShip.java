package lab18.Ships;

public class EscapeShip extends Ships{

    public static final EscapeShip escapeShipDefault = new EscapeShip("escapeShipDefault", "100", 50, 50, 1, 25);
    private int fuel;

    public EscapeShip(String name, String hp, int defence, int attack, int lvl, int fuel) {
        super(name, hp, defence, attack, lvl);
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.ESCAPE;
    }

    @Override
    public String toString() {
        return "EscapeShip: " +
                super.toString() +
                ", fuel= " + fuel + ".";
    }
}
