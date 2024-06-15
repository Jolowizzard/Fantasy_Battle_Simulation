package inventory.items;

import characters.Character;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }
    public Item(){
        name = null;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public abstract boolean use(Character character);
}
