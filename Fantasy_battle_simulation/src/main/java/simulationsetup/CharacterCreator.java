/*package simulationsetup;

import characters.Character;
import inteligence.InteligenceType;
import inventory.Inventory;
import weapons.Weapon;

import java.util.ArrayList;

public class CharacterCreator {
    //method for creating characters in simulation
    //working with GUI
    public Character createCharater(){
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = setInteligenceType();
        //here will be gui menu, where you can choose weapon and intelligence type and character class
    }
    private InteligenceType setInteligenceType(){
        //here method used in createCharacter returns pointer to created intelligenceType
        //Intelligence chose by used via Gui
        //return intelligence;
    }

}*/
package simulationsetup;

import characters.Character;
import characters.warriors.Knight;
import characters.warriors.Paladin;
import characters.shooter.Ranger;
import characters.shooter.Marksman;
import characters.mage.Wizard;
import characters.mage.Druid;
import characters.rogue.Thief;
import characters.rogue.Assassin;
import inteligence.Agressive;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;
import weapons.Weapon;

import java.util.ArrayList;

public class CharacterCreator {


    public void CharacterCreation() {
        int CounterId = 99;

    }


    public void createKnight(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newKnight = new Knight(id, Name, intelligence, position, inventory);
    }

    public void createPaladin(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newPaladin = new Paladin(id, Name, intelligence, position, inventory);
    }

    public void createRanger(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newRanger = new Ranger(id, Name, intelligence, position, inventory);
    }

    public void createMarksman(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newMarksman = new Marksman(id, Name, intelligence, position, inventory);
    }

    public void createDruid(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newDruid = new Druid(id, Name, intelligence, position, inventory);
    }

    public void createWizard(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newWizard = new Wizard(id, Name, intelligence, position, inventory);
    }

    public void createAssasin(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newAssasin = new Assassin(id, Name, intelligence, position, inventory);
    }

    public void createThief(int id, Tile position, String Name) {
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newThief = new Thief(id, Name, intelligence, position, inventory);
    }
}