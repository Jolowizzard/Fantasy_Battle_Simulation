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
import gui.Entity;
import gui.GamePanel;
import gui.Hero;
import gamestructure.Team;
import inteligence.Agressive;
import inteligence.InteligenceType;
import inventory.Inventory;
import inventory.items.HealPotion;
import inventory.items.Item;
import inventory.items.Shield;
import map.MAPtable;
import map.Tile;
import weapons.*;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

import static map.MAPtable.Map;

//import static jdk.vm.ci.hotspot.riscv64.RISCV64HotSpotRegisterConfig.gp;

public class CharacterCreator {

    private int whichteam = 0;
    public static int SavedPositions = 0;

    private int purplesaved = 0;
    private int yellowsaved = 0;

    private int coordX;
    private int coordY;

    Tile TempTile = new Tile(16,16);
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

    /**
     * creates new character from given String (used to read from file)
     * @param characterStats
     * @param inventoryStats
     * @param gamePanel
     * @return
     */
    public Character createCharacterFromString(String [] characterStats, String [] inventoryStats, GamePanel gamePanel){
        Inventory inventory = new Inventory();
        setInventoryStatsFromString(inventory,inventoryStats);

        int i = 0;
        String characterType = characterStats[i++];

        if(characterType.equals("Warrior")){

            int BlockChance = Integer.parseInt(characterStats[i++]);
            int BlockValue = Integer.parseInt(characterStats[i++]);

            if(characterStats[i].equals("Knight")) {

                //creating new knight
                characters.Character knight = new Knight(BlockChance, BlockValue);
                Hero characterRepresentation = new Hero(gamePanel);

                //Creating representation of character as a Hero for GamePanel
                characterRepresentation.setHeroType("Knight");
                knight.setRepresentation(characterRepresentation);

                //Setting characters types
                knight.setMainClass(characterType);
                knight.setSubClass("Knight");

                //Setting character stats
                setCharactersStatsFromString(knight,characterStats,++i);
                knight.setInventory(inventory);

                return knight;

            }else if(characterStats[i].equals("Paladin")) {

                Character paladin = new Paladin(BlockChance, BlockValue);
                Hero characterRepresentation = new Hero(gamePanel);

                characterRepresentation.setHeroType("Paladin");
                paladin.setRepresentation(characterRepresentation);

                paladin.setMainClass(characterType);
                paladin.setSubClass("Paladin");

                setCharactersStatsFromString(paladin,characterStats,++i);
                paladin.setInventory(inventory);

                return paladin;
            }

        }else if(characterType.equals("Shooter")) {
            int CritChance = Integer.parseInt(characterStats[i++]);
            int CritValue = Integer.parseInt(characterStats[i++]);

            if (characterStats[i].equals("Ranger")) {
                Character ranger = new Ranger(CritChance, CritValue);
                Hero characterRepresentation = new Hero(gamePanel);

                characterRepresentation.setHeroType("Archer");
                ranger.setRepresentation(characterRepresentation);

                ranger.setMainClass(characterType);
                ranger.setSubClass("Ranger");

                setCharactersStatsFromString(ranger, characterStats, ++i);
                ranger.setInventory(inventory);

                return ranger;

            } else if (characterStats[i].equals("Marksman")) {
                Character marksman = new Marksman(CritChance, CritValue);
                Hero characterRepresentation = new Hero(gamePanel);

                characterRepresentation.setHeroType("Marksman");
                marksman.setRepresentation(characterRepresentation);

                marksman.setMainClass(characterType);
                marksman.setSubClass("Marksman");

                setCharactersStatsFromString(marksman, characterStats, ++i);
                marksman.setInventory(inventory);

                return marksman;
            }
        }else if(characterType.equals("Mage")){
            int MagicCritChance = Integer.parseInt(characterStats[i++]);
            int MagicCritValue = Integer.parseInt(characterStats[i++]);

            if (characterStats[i].equals("Wizard")) {
                Character wizard = new Wizard(MagicCritChance, MagicCritValue,gamePanel);

                createRepresentation(wizard,"Archmage",gamePanel);

                wizard.setMainClass(characterType);
                wizard.setSubClass("Wizard");

                setCharactersStatsFromString(wizard, characterStats, ++i);
                wizard.setInventory(inventory);

                return wizard;

            } else if (characterStats[i].equals("Druid")) {
                Character druid = new Druid(MagicCritChance, MagicCritValue,gamePanel);

                createRepresentation(druid,"Druid",gamePanel);

                druid.setMainClass(characterType);
                druid.setSubClass("Druid");

                setCharactersStatsFromString(druid, characterStats, ++i);
                druid.setInventory(inventory);

                return druid;
            }
        }else if(characterType.equals("Rogue")){
            boolean secoundMove = false;
            if(Integer.parseInt(characterStats[i++])==1)
                secoundMove = true;
            else
                secoundMove = false;

            if (characterStats[i].equals("Thief")) {
                Character Thief = new Thief(secoundMove);

                createRepresentation(Thief,"Thief",gamePanel);

                Thief.setMainClass(characterType);
                Thief.setSubClass("Thief");

                setCharactersStatsFromString(Thief, characterStats, ++i);
                Thief.setInventory(inventory);

                return Thief;

            } else if (characterStats[i].equals("Assassin")) {
                Character assassin = new Assassin(secoundMove);

                createRepresentation(assassin,"Assassin",gamePanel);

                assassin.setMainClass(characterType);
                assassin.setSubClass("Assassin");

                setCharactersStatsFromString(assassin, characterStats, ++i);
                assassin.setInventory(inventory);

                return assassin;
            }

        }
        return null;
    }


    /**
     * sets characters stats from String(used to read stats from file)
     * @param character
     * @param characterStats
     * @param currentIndex
     */
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
        character.setAlive(true);
        //setting posit ion
        Tile tile = new Tile(Integer.parseInt(characterStats[currentIndex++]), Integer.parseInt(characterStats[currentIndex++]));
        character.getRepresentation().setPosition(tile.col,tile.row);
        character.setPosition(tile);

        //setting Intelligence Type
        if(characterStats[currentIndex++].equals("Aggressive")){
            InteligenceType inteligence = new Agressive(true);
            character.setIntType(inteligence);
            character.getIntType().setCharacter(character);
        }
    }

    /**
     * assings graphic representation to a character
     * @param character
     * @param name
     * @param gamePanel
     */
    private void createRepresentation(Character character,String name,GamePanel gamePanel){
        Hero characterRepresentation = new Hero(gamePanel);
        characterRepresentation.setHeroType(name);
        character.setRepresentation(characterRepresentation);
    }

    /**
     * sets inventory from String (used to read  Inventory form file)
     * @param inventory
     * @param inventoryString
     */
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

    /**
     * Creates new character of a type and inventory set via gui
     * @param ChoosenTile
     * @param gamePanel
     * @return
     */
    //creates character with inventory choosen via GUI
    public Character CharacterCreation(Tile ChoosenTile, GamePanel gamePanel)
    {
        Character error = new Knight();
        if(getKnight()==true)
        {
            String ChoosenName = "Knight"+String.valueOf(CounterId);
            Character character=createKnight(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getPaladin()==true) {
            String ChoosenName = "Paladin"+String.valueOf(CounterId);
            Character character=createPaladin(CounterId, ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getWizard()==true)
        {
            String ChoosenName = "Wizard"+String.valueOf(CounterId);
            Character character=createWizard(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getDruid()==true)
        {
            String ChoosenName = "Druid"+String.valueOf(CounterId);
            Character character=createDruid(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getMarksman()==true)
        {
            String ChoosenName = "Marksman"+String.valueOf(CounterId);
            Character character=createMarksman(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getRanger()==true)
        {
            String ChoosenName = "Ranger"+String.valueOf(CounterId);
            Character character=createRanger(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getAssassin()==true)
        {
            String ChoosenName = "Assassin"+String.valueOf(CounterId);
            Character character=createAssassin(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;
        }
        if(getThief()==true)
        {
            String ChoosenName = "Thief"+String.valueOf(CounterId);
            Character character = createThief(CounterId,ChoosenTile, ChoosenName, gamePanel);
            CounterId = CounterId - 1;
            return character;

        }
        CounterId = CounterId - 1;
        return error;
    }


    /**
     * adds choosen hero to team purple
     * @param teampurple
     * @param gamePanel
     */
    public void SaveHerotoPurple(Team teampurple, GamePanel gamePanel)
    {
        Character character = CharacterCreation(TempTile,gamePanel);
        character.getRepresentation().setHeroColor("P");
        teampurple.addCharacter(character);
    }

    /**
     * adds chosem hero to team yellow
     * @param teamyellow
     * @param gamePanel
     */
    //adds hero to yellow team
    public void SaveHerotoYellow(Team teamyellow, GamePanel gamePanel)
    {
        Character character = CharacterCreation(TempTile,gamePanel);
        character.getRepresentation().setHeroColor("Y");
        teamyellow.addCharacter(character);
    }


    //sets all character booleans to false
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




    /**
     * saves characters position as a new Tile
     * @param character
     * @param coordX
     * @param coordY
     */
    public void SavePosition(Character character,int coordX, int coordY)
{
    Tile temp = new Tile(coordY,coordX);
    character.setPosition(temp);
    character.getRepresentation().setPosition(coordY,coordX);
    System.out.println(character.getInventory().getWeapons().get(0).getName());
}


    /**
     * saves all created characters(via gui) new positions
     * @param coordX
     * @param coordY
     * @param gamePanel
     */
    public void SaveAllCharactersPositions(int coordX, int coordY, GamePanel gamePanel) {

    if (SavedPositions < TeamCreator.teamYellow.getTeam().size() + TeamCreator.teamPurple.getTeam().size()) {
        if (purplesaved < TeamCreator.teamPurple.getTeam().size())
        {
            SavePosition(TeamCreator.teamPurple.getTeam().get(purplesaved),coordX, coordY );
            System.out.println(TeamCreator.teamPurple.getTeam().get(purplesaved).getName()+"  row; "+TeamCreator.teamPurple.getTeam().get(purplesaved).getPosition().row+" col:  "+TeamCreator.teamPurple.getTeam().get(purplesaved).getPosition().col);
            System.out.println(TeamCreator.teamPurple.getTeam().get(purplesaved).getName());
            //System.out.println(TeamCreator.teamPurple.getTeam().get(purplesaved).getRepresentation().getHeroType());
            Map[coordX][coordY].SetAsOccupied();
            purplesaved = purplesaved+1;
            if(purplesaved<TeamCreator.teamPurple.getTeam().size()){
            gamePanel.setcursor(TeamCreator.teamPurple.getTeam().get(purplesaved).getRepresentation().heroType);}else{gamePanel.setcursor(TeamCreator.teamYellow.getTeam().get(0).getRepresentation().heroType);}
            SavedPositions = SavedPositions+1;
        }
        else if (yellowsaved < TeamCreator.teamYellow.getTeam().size())
        {
            SavePosition(TeamCreator.teamYellow.getTeam().get(yellowsaved),coordX, coordY );
            System.out.println(TeamCreator.teamYellow.getTeam().get(yellowsaved).getName()+"  row; "+TeamCreator.teamYellow.getTeam().get(yellowsaved).getPosition().row+" col:  "+TeamCreator.teamYellow.getTeam().get(yellowsaved).getPosition().col);
            System.out.println(TeamCreator.teamYellow.getTeam().get(yellowsaved).getName());
            //System.out.println(TeamCreator.teamYellow.getTeam().get(yellowsaved).getRepresentation().getHeroType());
            Map[coordX][coordY].SetAsOccupied();
            yellowsaved = yellowsaved+1;
            if(yellowsaved <TeamCreator.teamYellow.getTeam().size()){
            gamePanel.setcursor(TeamCreator.teamYellow.getTeam().get(yellowsaved).getRepresentation().heroType) ;}
            SavedPositions = SavedPositions+1;
        }
    }
}






//functions creating hero of a certain class
    public Character createKnight(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newKnight = new Knight(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newKnight);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newKnight,"Knight",gamePanel);
        return newKnight;
    }

    public Character createPaladin(int id, Tile position, String Name,GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newPaladin = new Paladin(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newPaladin);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newPaladin,"Paladin",gamePanel);
        return newPaladin;
    }

    public Character createRanger(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newRanger = new Ranger(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newRanger);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newRanger,"Archer",gamePanel);
        return newRanger;
    }

    public Character createMarksman(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newMarksman = new Marksman(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newMarksman);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newMarksman,"Marksman",gamePanel);
        return newMarksman;
    }

    public Character createDruid(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newDruid = new Druid(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newDruid);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newDruid,"Druid",gamePanel);
        return newDruid;
    }

    public Character createWizard(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newWizard = new Wizard(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newWizard);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newWizard,"Archmage",gamePanel);
        return newWizard;
    }

    public Character createAssassin(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newAssasin = new Assassin(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newAssasin);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        createRepresentation(newAssasin,"Assasin",gamePanel);
        return newAssasin;
    }

    public Character createThief(int id, Tile position, String Name, GamePanel gamePanel) {
        Inventory inv = new Inventory();
        InventoryCreator inventory = new InventoryCreator();
        InteligenceType intelligence = new Agressive(true);
        characters.Character newThief = new Thief(id, Name, intelligence, position, inv);
        intelligence.setCharacter(newThief);
        inventory.AddWeaponsToInventory(inv);
        inventory.AddArmorToInventory(inv);
        inventory.AddItems(inv);
        System.out.println(newThief.getInventory().getWeapons().get(0).getName());
        createRepresentation(newThief,"Thief",gamePanel);
        return newThief;
    }
}
