package inventory;

import armours.Armour;
import inventory.items.Item;
import weapons.Weapon;

import java.util.ArrayList;

/**
 *   inventory consists of Weapons, Armours, Items
 */
public class Inventory {
    private Weapon CurrentWeapon;
    private Armour CurrentArmour;
    private Item CurrentItem;
    private ArrayList<Weapon> Weapons;
    private ArrayList<Armour> Armours;
    private ArrayList<Item> Items;

    /**
     * constructor of Inventory
     */
    public Inventory(){
        Weapons = new ArrayList<>();
        Armours = new ArrayList<>();
        Items = new ArrayList<>();
    }

    /**
     * constructor of inventory
     * @param Weapons
     * @param Armours
     */
    public Inventory(ArrayList<Weapon> Weapons,ArrayList<Armour> Armours){
       this.Weapons=Weapons;
       this.Armours=Armours;
       Items = new ArrayList<>();
    }
    public Inventory(ArrayList<Weapon> Weapons){
        this.Weapons=Weapons;
        Armours = new ArrayList<>();
    }
    public ArrayList<Weapon> getWeapons(){
        return Weapons;
    }
    public ArrayList<Armour> getArmours(){
        return Armours;
    }
    public ArrayList<Item> getItems(){return Items;}
    public Weapon getCurrentWeapon(){
        return CurrentWeapon;
    }
    public Armour getCurrentArmour(){
        return CurrentArmour;
    }

    public Item getCurrentItem() {
        return CurrentItem;
    }
    public void setCurrentItem(Item currentItem) {
        CurrentItem = currentItem;
    }
    public void setCurrentWeapon(Weapon currentWeapon){
        this.CurrentWeapon = currentWeapon;
    }
    public void setCurrentArmour(Armour currentArmour){
        this.CurrentArmour = currentArmour;
    }
    public void addWeapon(Weapon weapon){
        Weapons.add(weapon);
    }
    public void addItem(Item item){this.Items.add(item);}
    public void addArmour(Armour armour){
        Armours.add(armour);
    }
}
