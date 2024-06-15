package simulationsetup;

import armours.*;
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
import inventory.items.HealPotion;
import inventory.items.Item;
import inventory.items.Shield;
import map.Tile;
import weapons.*;

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
    public Character createCharacterFromString(String [] characterStats,String [] inventoryStats){
        Inventory inventory = new Inventory();
        InteligenceType intelligence = null;
        setInventoryStatsFromString(inventory,inventoryStats);
        int i = 0;
        String characterType = characterStats[i++];
        if(characterType.equals("Warrior")){
            int BlockChance = Integer.parseInt(characterStats[i++]);
            int BlockValue = Integer.parseInt(characterStats[i++]);
            if(characterStats[i++].equals("Knight")) {
                characters.Character knight = new Knight(BlockChance, BlockValue);
                setCharactersStatsFromString(knight,characterStats,i);
                knight.setInventory(inventory);
            }else if(characterStats[i++].equals("Paladin")) {
                Character paladin = new Paladin(BlockChance, BlockValue);
                setCharactersStatsFromString(paladin,characterStats,i);
            }
        }else if(characterType.equals("Shooter")) {
            int CritChance = Integer.parseInt(characterStats[i++]);
            int CritValue = Integer.parseInt(characterStats[i++]);
            if (characterStats[i++].equals("Ranger")) {
                Character ranger = new Ranger(CritChance, CritValue);
                setCharactersStatsFromString(ranger, characterStats, i);
            } else if (characterStats[i++].equals("Marksman")) {
                Character marksman = new Marksman(CritChance, CritValue);
                setCharactersStatsFromString(marksman, characterStats, i);
            }
        }
        return null;
    }
    private void setCharactersStatsFromString(Character character,String [] characterStats,int currentIndex){
        character.setName(characterStats[currentIndex++]);
        character.setRace(characterStats[currentIndex++]);
        character.setMaxHp(Integer.parseInt(characterStats[currentIndex++]));
        character.setCurrentHp(Integer.parseInt(characterStats[currentIndex++]));
        character.setStrength(Integer.parseInt(characterStats[currentIndex++]));
        character.setDexterity(Integer.parseInt(characterStats[currentIndex++]));
        character.setIntelignece(Integer.parseInt(characterStats[currentIndex++]));
        character.setMovement(Integer.parseInt(characterStats[currentIndex++]));
        character.setDodgeChance(Integer.parseInt(characterStats[currentIndex++]));
        //setting position
        Tile tile = new Tile(Integer.parseInt(characterStats[currentIndex++]), Integer.parseInt(characterStats[currentIndex++]));
        character.setPosition(tile);
        //setting Intelligence Type
        if(characterStats[currentIndex++].equals("Aggressive")){
            InteligenceType inteligence = new Agressive(true);
            character.setIntType(inteligence);
        }
    }
    private void setInventoryStatsFromString(Inventory inventory,String [] inventoryString){
        for(int i = 0 ;i< inventoryString.length;i++){
            if(inventoryString[i].equals("Weapons")){
                i++;
                while(!inventoryString[i].equals("WeaponsEnd")){
                    inventory.addWeapon(createWeapon(inventoryString[i]));
                    i++;
                }
            }
            if(inventoryString[i].equals("Items")){
                i++;
                while(!inventoryString[i].equals("ItemsEnd")){
                    inventory.addItem(createItem(inventoryString[i]));
                    i++;
                }
            }
            if(inventoryString[i].equals("Armours")){
                i++;
                while(!inventoryString[i].equals("ArmoursEnd")){
                    inventory.addArmour(createArmour(inventoryString[i]));
                    i++;
                }
            }
        }
    }
    private Weapon createWeapon(String name){
        switch (name) {
            case "Sword" -> {
                Weapon weapon = new Sword();
                return weapon;
            }
            case "Staff" -> {
                Weapon weapon = new Staff();
                return weapon;
            }
            case "Fists" -> {
                Weapon weapon = new Fists();
                return weapon;
            }
            case "Bow" -> {
                Weapon weapon = new Bow();
                return weapon;
            }
            case "Dagger" -> {
                Weapon weapon = new Dagger();
                return weapon;
            }
        }
        return null;
    }
    private Item createItem(String name){
        switch (name) {
            case "HealPotion" -> {
                Item healPotion = new HealPotion();
                return healPotion;
            }
            case "Shield" -> {
                Item shield = new Shield();
                return shield;
            }
        }
        return null;
    }
    private Armour createArmour(String name){
        switch (name) {
            case "NoArmour" -> {
                Armour noArmour = new NoArmor();
                return noArmour;
            }
            case "LightArmour" -> {
                Armour lightArmour = new LightArmour();
                return lightArmour;
            }
            case "MediumArmour" -> {
                Armour mediumArmour = new MediumArmour();
                return mediumArmour;
            }
            case "HeavyArmour" -> {
                Armour heavyArmour = new HeavyArmour();
                return heavyArmour;
            }
        }
        return null;
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
    public Character createKnight(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newKnight = new Knight(id, Name, intelligence, position, inventory.CreateInventory());
        return newKnight;
    }

    public Character createPaladin(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newPaladin = new Paladin(id, Name, intelligence, position, inventory.CreateInventory());
        return newPaladin;
    }

    public Character createRanger(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newRanger = new Ranger(id, Name, intelligence, position, inventory.CreateInventory());
        return newRanger;
    }

    public Character createMarksman(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newMarksman = new Marksman(id, Name, intelligence, position, inventory.CreateInventory());
        return newMarksman;
    }

    public Character createDruid(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newDruid = new Druid(id, Name, intelligence, position, inventory.CreateInventory());
        return newDruid;
    }

    public Character createWizard(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newWizard = new Wizard(id, Name, intelligence, position, inventory.CreateInventory());
        return newWizard;
    }

    public Character createAssassin(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newAssasin = new Assassin(id, Name, intelligence, position, inventory.CreateInventory());
        return newAssasin;
    }

    public Character createThief(int id, Tile position, String Name) {
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newThief = new Thief(id, Name, intelligence, position, inventory.CreateInventory());
        return newThief;
    }
}
