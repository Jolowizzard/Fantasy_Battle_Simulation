package inventory.items;

import characters.Character;

public abstract class Item {
    private String name;
    private int msReduction;
    public Item(String name) {
        this.name = name;
    }
    public Item(){
        name = null;
    }

    public Item(String name, int movementReduction) {
    }
    public void setMsReduction(int msReduction){
        this.msReduction = msReduction;
    }
    public int getMsReduction(){return msReduction;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public abstract boolean use(Character character);
}
