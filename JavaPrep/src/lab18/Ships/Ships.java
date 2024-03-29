package lab18.Ships;

public abstract class Ships {
    private String name;
    private String hp;
    private int defence;
    private int attack;
    private int lvl;
    private int price;

    public Ships(String name, String hp, int defence, int attack, int lvl, int price) {
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.lvl = lvl;
        this.price = price;
    }

    public abstract ShipType getShipType();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", hp=" + hp +
                ", defence=" + defence +
                ", attack=" + attack +
                ", lvl=" + lvl;
    }
}
