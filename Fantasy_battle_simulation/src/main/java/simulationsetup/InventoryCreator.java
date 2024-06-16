package simulationsetup;

import armours.Armour;
import armours.HeavyArmour;
import armours.LightArmour;
import armours.MediumArmour;
import inventory.Inventory;
import inventory.items.HealPotion;
import inventory.items.Item;
import inventory.items.Shield;
import weapons.*;

import java.util.ArrayList;

public class InventoryCreator {
    //Weapons
    private boolean fists = false;
    private boolean sword = false;
    private boolean swordshield = false;
    private boolean bow = false;
    private boolean staff = false;
    private boolean daggers = false;

    public boolean getfists(){return fists;}
    public boolean getsword(){return sword;}
    public boolean getbow(){return bow;}
    public boolean getswordshield(){return swordshield;}
    public boolean getstaff(){return staff;}
    public boolean getdaggers(){return daggers;}

    public void setfists(boolean bool)
    {
        fists = bool;
    }

    public void setsword(boolean bool)
    {
        sword = bool;
    }
    public void setbow(boolean bool){bow = bool;}

    public void setswordshield(boolean bool)
    {
        swordshield = bool;
    }

    public void setstaff(boolean bool)
    {
        staff = bool;
    }

    public void setdaggers(boolean bool)
    {
        daggers = bool;
    }
    //Armor
    private boolean light =false;
    private boolean medium =false;
    private boolean heavy =false;

    public boolean getlight(){return light;}
    public boolean getmedium(){return medium;}
    public boolean getheavy(){return heavy;}

    public void setlight(boolean bool){light = bool;}
    public void setmedium(boolean bool){medium = bool;}
    public void setheavy(boolean bool){heavy = bool;}

    private boolean potion1=false;
    public boolean getpotion1(){return potion1;}
    public void setpotion1(boolean bool){potion1 =bool;}
    private boolean potion2=false;
    public boolean getpotion2(){return potion2;}
    public void setpotion2(boolean bool){potion2 =bool;}
    private boolean potion3=false;
    public boolean getpotion3(){return potion3;}
    public void setpotion3(boolean bool){potion3 =bool;}
    public void SetpotionsToFalse()
    {
        setpotion1(false);
        setpotion2(false);
        setpotion3(false);
    }

    public void setArmorToFalse()
    {
        setmedium(false);
        setlight(false);
        setheavy(false);
    }

    public void setWeaponsToFalse()
    {
        setfists(false);
        setsword(false);
        setbow(false);
        setswordshield(false);
        setstaff(false);
        setdaggers(false);
    }

    public Inventory CreateInventory()
    {
        Inventory inventory = new Inventory(AddWeaponsToInventory(), AddArmorToInvenotry());
        for(int i=0;i< AddItems().size();i++) {
            inventory.addItem(AddItems().get(i));
        }
        return inventory;
    }

    public ArrayList<Armour> AddArmorToInvenotry()
    {
        ArrayList<Armour> armours = new ArrayList<>();
        if(light == true)
        {
            Armour lightArmour = new LightArmour();
            armours.add(lightArmour);
        }
        if(medium == true)
        {
            Armour mediumArmour = new MediumArmour();
            armours.add(mediumArmour);
        }
        if(heavy == true)
        {
            Armour heavyArmour = new HeavyArmour();
            armours.add(heavyArmour);
        }
        return armours;
    }

    public ArrayList<Weapon> AddWeaponsToInventory() {
        ArrayList<Weapon> weapons = new ArrayList<>();
        if (fists == true) {
            Weapon fists = new Fists();
            weapons.add(fists);
        }
        if (sword == true) {
            Weapon ssword = new Sword();
            weapons.add(ssword);
        }
        if (bow == true) {
            Weapon bow = new Bow();
            weapons.add(bow);
        }
        if (swordshield == true) {
            Weapon ssword = new Sword();
            weapons.add(ssword);
        }
        if (staff == true) {
            Weapon staff = new Staff();
            weapons.add(staff);
        }
        if (daggers == true) {
            Weapon daggers = new Dagger();
            weapons.add(daggers);
        }
        return weapons;
    }

    public ArrayList<Item> AddItems()
    {
        ArrayList<Item> items = new ArrayList<>();
        if(swordshield==true)
        {
            Shield shield = new Shield();
            items.add(shield);
        }
        HealPotion potion = new HealPotion();
        if(potion1==true)
        {
            addPotion(items, potion);
        }
        if(potion2==true)
        {
            addPotion(items, potion);
            addPotion(items, potion);
        }
        if(potion3==true)
        {
            addPotion(items, potion);
            addPotion(items, potion);
            addPotion(items, potion);
        }
        return items;
    }

    public void addPotion(ArrayList items,HealPotion potion )
    {
        items.add(potion);
    }


}
