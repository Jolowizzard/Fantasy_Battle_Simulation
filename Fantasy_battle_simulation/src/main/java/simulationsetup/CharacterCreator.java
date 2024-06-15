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
   private int CounterId = 99;
    private boolean Knight = false;
    private boolean Paladin = false;
    private boolean Marksman = false;
    private boolean Ranger = false;
    private boolean Assassin = false;
    private boolean Thief = false;
    private boolean Wizard = false;
    private boolean Druid = false;

    public boolean getKnight(){return Knight;}
    public boolean getPaladin(){return Paladin;}
    public boolean getWizard(){return Wizard;}
    public boolean getDruid(){return Druid;}
    public boolean getMarksman(){return Marksman;}
    public boolean getRanger(){return Ranger;}
    public boolean getAssassin(){return Assassin;}
    public boolean getThief(){return Thief;}

    public void setKnight(boolean bool){Knight=bool;}
    public void setPaladin(boolean bool){Paladin=bool;}
    public void setWizard(boolean bool){Wizard=bool;}
    public void setDruid(boolean bool){Druid=bool;}
    public void setMarksman(boolean bool){Marksman=bool;}
    public void setRanger(boolean bool){Ranger=bool;}
    public void setAssassin(boolean bool){Assassin=bool;}
    public void setThief(boolean bool){Thief=bool;}
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
    public void CharacterCreation(Tile ChoosenTile, String ChoosenName )
    {
        if(getKnight()==true)
        {
            createKnight(CounterId,ChoosenTile, ChoosenName);
        }
        if(getPaladin()==true) {
            createPaladin(CounterId, ChoosenTile, ChoosenName);
        }
            if(getWizard()==true)
            {
                createWizard(CounterId,ChoosenTile, ChoosenName);
            }
            if(getDruid()==true)
            {
                createDruid(CounterId,ChoosenTile, ChoosenName);
            }
            if(getMarksman()==true)
            {
                createMarksman(CounterId,ChoosenTile, ChoosenName);
            }
            if(getRanger()==true)
            {
                createRanger(CounterId,ChoosenTile, ChoosenName);
            }
            if(getAssassin()==true)
            {
                createAssassin(CounterId,ChoosenTile, ChoosenName);
            }
            if(getThief()==true)
            {
                createThief(CounterId,ChoosenTile, ChoosenName);

            }
            CounterId = CounterId - 1;
    }

public void SetCharacterBooleansToFalse()
{
    setKnight(false);
    setPaladin(false);
    setMarksman(false);
    setRanger(false);
    setThief(false);
    setAssassin(false);
    setDruid(false);
    setWizard(false);
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

    public void createAssassin(int id, Tile position, String Name) {
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
