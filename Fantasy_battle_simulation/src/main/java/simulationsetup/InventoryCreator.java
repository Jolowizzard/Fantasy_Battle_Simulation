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
    private static boolean fists = false;
    private static boolean sword = false;
    private static boolean swordshield = false;
    private static boolean bow = false;
    private static boolean staff = false;
    private static boolean daggers = false;

    public boolean getfists() {
        return fists;
    }

    public boolean getsword() {
        return sword;
    }

    public boolean getbow() {
        return bow;
    }

    public boolean getswordshield() {
        return swordshield;
    }

    public boolean getstaff() {
        return staff;
    }

    public boolean getdaggers() {
        return daggers;
    }

    public void setfists(boolean bool) {
        fists = bool;
    }

    public void setsword(boolean bool) {
        sword = bool;
    }

    public void setbow(boolean bool) {
        bow = bool;
    }

    public void setswordshield(boolean bool) {
        swordshield = bool;
    }

    public void setstaff(boolean bool) {
        staff = bool;
    }

    public void setdaggers(boolean bool) {
        daggers = bool;
    }

    //Armor
    private static boolean light = false;
    private static boolean medium = false;
    private static boolean heavy = false;

    public boolean getlight() {
        return light;
    }

    public boolean getmedium() {
        return medium;
    }

    public boolean getheavy() {
        return heavy;
    }

    public void setlight(boolean bool) {
        light = bool;
    }

    public void setmedium(boolean bool) {
        medium = bool;
    }

    public void setheavy(boolean bool) {
        heavy = bool;
    }

    private static boolean potion1 = false;

    public boolean getpotion1() {
        return potion1;
    }

    public void setpotion1(boolean bool) {
        potion1 = bool;
    }

    private static boolean potion2 = false;

    public boolean getpotion2() {
        return potion2;
    }

    public void setpotion2(boolean bool) {
        potion2 = bool;
    }

    private static boolean potion3 = false;

    public boolean getpotion3() {
        return potion3;
    }

    public void setpotion3(boolean bool) {
        potion3 = bool;
    }

    public void SetpotionsToFalse() {
        setpotion1(false);
        setpotion2(false);
        setpotion3(false);
    }

    public void setArmorToFalse() {
        setmedium(false);
        setlight(false);
        setheavy(false);
    }

    public void setWeaponsToFalse() {
        setfists(false);
        setsword(false);
        setbow(false);
        setswordshield(false);
        setstaff(false);
        setdaggers(false);
    }

    public void CreateInventory(Inventory inventory) {

    }


    /**
     * adds choosen armor via gui to inventory
     * @param inventory
     */
    public void AddArmorToInventory(Inventory inventory) {
        if (light == true) {
            Armour lightArmour = new LightArmour();
            inventory.addArmour(lightArmour);
            System.out.println("dodano armor");
        }
        if (medium == true) {
            Armour mediumArmour = new MediumArmour();
            inventory.addArmour(mediumArmour);
        }
        if (heavy == true) {
            Armour heavyArmour = new HeavyArmour();
            inventory.addArmour(heavyArmour);
        }
    }


    /**
     * adds choosen weapons via gui to inventory
     * @param inventory
     */
    public void AddWeaponsToInventory(Inventory inventory) {

        if (fists == true) {
            Weapon fists = new Fists();
            inventory.addWeapon(fists);
            System.out.println("dodano piachy");
        }
        if (sword == true) {
            Weapon ssword = new Sword();
            inventory.addWeapon(ssword);
        }
        if (bow == true) {
            Weapon bow = new Bow();
            inventory.addWeapon(bow);
        }
        if (swordshield == true) {
            Weapon ssword = new Sword();
            inventory.addWeapon(ssword);
        }
        if (staff == true) {
            Weapon staff = new Staff();
            inventory.addWeapon(staff);
        }
        if (daggers == true) {
            Weapon daggers = new Dagger();
            inventory.addWeapon(daggers);
        }
    }


    /**
     * adds choosen items via gui to inventory
     * @param inventory
     */
    public void AddItems(Inventory inventory) {
        if (swordshield == true) {
            Shield shield = new Shield();
            inventory.addItem(shield);
            System.out.println("dodano pote");
        }
        HealPotion potion = new HealPotion();
        if (potion1 == true) {
            inventory.addItem(potion);
        }
        if (potion2 == true) {
            inventory.addItem(potion);
            inventory.addItem(potion);
        }
        if (potion3 == true) {
            inventory.addItem(potion);
            inventory.addItem(potion);
            inventory.addItem(potion);
        }

    }
}