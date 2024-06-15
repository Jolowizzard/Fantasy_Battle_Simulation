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
import inventory.items.Item;
import map.Tile;
import weapons.Weapon;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class CharacterCreator {
    //method for creating characters in simulation
    //working with GUI
    public Character createCharater(){
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = setInteligenceType();
        return null;
    }
    private InteligenceType setInteligenceType(){
        //here method used in createCharacter returns pointer to created intelligenceType
        //Intelligence chose by used via Gui
        //return intelligence;
        return null;
    }
    public Character createCharacterFromFile(String [] characterStats,String [] inventoryStats){
        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        Inventory inventory = new Inventory();
        InteligenceType intelligence = null;
        int i = 0;
        String characterType = characterStats[i++];

        if(characterType.equals("Warrior")){
            int BlockChance = Integer.parseInt(characterStats[i++]);
            int BlockValue = Integer.parseInt(characterStats[i++]);
            if(characterStats[i++].equals("Knight")) {
                characters.Character knight = new Knight(BlockChance, BlockValue);
            }else if(characterStats[i++].equals("Paladin")) {
                Character paladin = new Paladin(BlockChance, BlockValue);
            }
        }else if(characterType.equals("Shooter"))
        {
            int CritChance = Integer.parseInt(characterStats[i++]);
            int CritValue = Integer.parseInt(characterStats[i++]);
            if(characterStats[i++].equals("Ranger")) {
                Character ranger = new Ranger(CritChance, CritValue);
                setCharactersStats(ranger,characterStats);
            }else if(characterStats[i++].equals("Marksman")) {
                Character marksman = new Marksman(CritChance, CritValue);
            }
        }
        return null;
    }
    private void setCharactersStats(Character character,String [] characterStats){

    }
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
