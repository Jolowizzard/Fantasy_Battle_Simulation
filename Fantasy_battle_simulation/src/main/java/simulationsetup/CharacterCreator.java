package simulationsetup;

import characters.Character;
import characters.shooter.Marksman;
import characters.shooter.Ranger;
import characters.warriors.Knight;
import characters.warriors.Paladin;
import characters.warriors.Warrior;
import inteligence.InteligenceType;
import inventory.Inventory;
import inventory.items.Item;
import weapons.Weapon;

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
}
