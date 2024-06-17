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
import gamestructure.Team;
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

//import static jdk.vm.ci.hotspot.riscv64.RISCV64HotSpotRegisterConfig.gp;

public class CharacterCreator {

    private int whichteam = 0;
    int SavedPositions = 0;

    private int purplesaved = 0;
    private int yellowsaved = 0;

    private int coordX;
    private int coordY;

    Tile TempTile = new Tile(16,16); // jesli blad to zmienic na istniejacy tile od 0 do 15;
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

            if(characterStats[i].equals("Knight")) {
                characters.Character knight = new Knight(BlockChance, BlockValue);
                setCharactersStatsFromString(knight,characterStats,++i);
                knight.setInventory(inventory);
                return knight;

            }else if(characterStats[i].equals("Paladin")) {
                Character paladin = new Paladin(BlockChance, BlockValue);
                setCharactersStatsFromString(paladin,characterStats,++i);
                paladin.setInventory(inventory);
                return paladin;
            }

        }else if(characterType.equals("Shooter")) {
            int CritChance = Integer.parseInt(characterStats[i++]);
            int CritValue = Integer.parseInt(characterStats[i++]);

            if (characterStats[i].equals("Ranger")) {
                Character ranger = new Ranger(CritChance, CritValue);
                setCharactersStatsFromString(ranger, characterStats, ++i);
                ranger.setInventory(inventory);
                return ranger;

            } else if (characterStats[i].equals("Marksman")) {
                Character marksman = new Marksman(CritChance, CritValue);
                setCharactersStatsFromString(marksman, characterStats, ++i);
                marksman.setInventory(inventory);
                return marksman;
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
            character.getIntType().setCharacter(character);
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
                return new Sword();
            }
            case "Staff" -> {
                return new Staff();
            }
            case "Fists" -> {
                return new Fists();
            }
            case "Bow" -> {
                return new Bow();
            }
            case "Dagger" -> {
                return new Dagger();
            }
        }
        return null;
    }
    private Item createItem(String name){
        switch (name) {
            case "HealPotion" -> {
                return new HealPotion();
            }
            case "Shield" -> {
                return new Shield();
            }
        }
        return null;
    }
    private Armour createArmour(String name){
        switch (name) {
            case "NoArmour" -> {
                return new NoArmor();
            }
            case "LightArmour" -> {
                return new LightArmour();
            }
            case "MediumArmour" -> {
                return new MediumArmour();
            }
            case "HeavyArmour" -> {
                return new HeavyArmour();
            }
        }
        return null;
    }

    public Character CharacterCreation(Tile ChoosenTile)
    {
        Character error = new Knight();
        if(getKnight()==true)
        {
            String ChoosenName = "Knight"+String.valueOf(CounterId);
            Character character=createKnight(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getPaladin()==true) {
            String ChoosenName = "Paladin"+String.valueOf(CounterId);
            Character character=createPaladin(CounterId, ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getWizard()==true)
        {
            String ChoosenName = "Wizard"+String.valueOf(CounterId);
            Character character=createWizard(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getDruid()==true)
        {
            String ChoosenName = "Druid"+String.valueOf(CounterId);
            Character character=createDruid(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getMarksman()==true)
        {
            String ChoosenName = "Marksman"+String.valueOf(CounterId);
            Character character=createMarksman(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getRanger()==true)
        {
            String ChoosenName = "Ranger"+String.valueOf(CounterId);
            Character character=createRanger(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getAssassin()==true)
        {
            String ChoosenName = "Assassin"+String.valueOf(CounterId);
            Character character=createAssassin(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;
        }
        if(getThief()==true)
        {
            String ChoosenName = "Thief"+String.valueOf(CounterId);
            Character character = createThief(CounterId,ChoosenTile, ChoosenName);
            CounterId = CounterId - 1;
            return character;

        }
        CounterId = CounterId - 1;
        return error;
    }

    public void SaveHerotoPurple(Team teampurple)
    {
       teampurple.addCharacter(CharacterCreation(TempTile));
    }

    public void SaveHerotoYellow(Team teamyellow)
    {
        teamyellow.addCharacter(CharacterCreation(TempTile));
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

public void SavePosition(Character character,int coordX, int coordY)
{
    Tile temp = new Tile(coordX,coordY);
    character.setPosition(temp);
}

public void SaveAllCharactersPositions(int coordX, int coordY) {

    if (SavedPositions < TeamCreator.teamYellow.getTeam().size() + TeamCreator.teamPurple.getTeam().size()) {
        if (purplesaved < TeamCreator.teamPurple.getTeam().size())
        {
            System.out.println(TeamCreator.teamPurple.getTeam().get(purplesaved).getName()+"    "+TeamCreator.teamPurple.getTeam().get(purplesaved).getPosition().col+","+TeamCreator.teamPurple.getTeam().get(purplesaved).getPosition().row);
            purplesaved = purplesaved+1;
            SavedPositions = SavedPositions+1;
        }
        else if (yellowsaved < TeamCreator.teamYellow.getTeam().size())
        {
            System.out.println(TeamCreator.teamYellow.getTeam().get(yellowsaved).getName()+"    "+TeamCreator.teamYellow.getTeam().get(yellowsaved).getPosition().col+","+TeamCreator.teamYellow.getTeam().get(yellowsaved).getPosition().row);
            yellowsaved = yellowsaved+1;
            SavedPositions = SavedPositions+1;
        }
    }
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
