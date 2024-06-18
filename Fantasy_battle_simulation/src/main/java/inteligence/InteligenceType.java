package inteligence;
import armours.Armour;
import characters.Character;
import gamestructure.*;
import gui.GamePanel;
import inventory.items.Item;
import map.MAPtable;
import map.Tile;
import movement.MovesAndPaths;
import searchalgorythm.SearchAlgorythm;
import simulationsetup.Scribe;
import weapons.Weapon;

import java.util.ArrayList;


public abstract class InteligenceType{

    protected Character target;

    protected Character character;
    protected boolean inCombat=false;
    protected Team enemies;
    protected Team allays;
    protected boolean injured;
    protected GamePanel gamePanel;

    public void setGamePanel(GamePanel gamePanel){this.gamePanel = gamePanel;}
    public GamePanel getGamePanel(){return gamePanel;}
    public InteligenceType(){
    }
    public characters.Character GetTarget(){return target;}
    public void setCharacter(characters.Character character){this.character = character;}
    public void setTarget(characters.Character character){target = character;}
    public void setEnemies(Team enemies){
        this.enemies=enemies;
    }
    public void setAllays(Team allays){this.allays=allays;}
    public void setInCombat(){
        inCombat = true;
    }
    protected boolean checkIfEnemyIsInRange(){
        double distance;
        //calculating euclidean distance between to characters
        if(target == null)
            return false;
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }
    public Character lookForTarget(){
        int bestDistanse=999;
        Character OptimalTarget=null;
        for(int i = 0;i<enemies.getTeam().size();i++){
            if(enemies.getTeam().get(i).checkIfIsAlive())
            {
                SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),enemies.getTeam().get(i).getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
                ArrayList<Tile> path = new ArrayList<>();
                path = searchAlgorythm.search();
                if(path.size()<bestDistanse) {
                    bestDistanse = path.size();
                    OptimalTarget=enemies.getTeam().get(i);
                }
            }
        }
        return OptimalTarget;
    }
    public Character lookForTeammate(){
        int bestDistanse=999;
        Character OptimalTarget=null;
        for(int i = 0;i<allays.getTeam().size();i++){
            if(allays.getTeam().get(i).checkIfIsAlive() && allays.getTeam().get(i) != character)
            {
                SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),allays.getTeam().get(i).getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
                ArrayList<Tile> path = new ArrayList<>();
                path = searchAlgorythm.search();
                if(path.size()<bestDistanse) {
                    bestDistanse = path.size();
                    OptimalTarget=allays.getTeam().get(i);
                }
            }
        }
        return OptimalTarget;
    }
    public void MoveTowardsOpponent(characters.Character character, characters.Character target,GamePanel gamePanel){
        SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),target.getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
        ArrayList<Tile> path = new ArrayList<>();
        path = searchAlgorythm.search();
        MovesAndPaths.Move(character,path,gamePanel);
    }
    public abstract void PerformTurn();

    public Character getCharacter(){return character;}

    public void inventorySetup(){
        //setting optimal weapon - looking for the highest range and then the highest damage output
        ArrayList<Weapon> weapons = character.getInventory().getWeapons();
        int expectedDamageOutput;
        int optimalWeaponIndex = -1;
        int tmp = 0;
        int maxRange = 0;
        for(int i =0;i<weapons.size();i++){
            //calculating expected damage output
            if(weapons.get(i).getRange()>=maxRange) {
                maxRange = weapons.get(i).getRange();
                expectedDamageOutput = 0;
                ArrayList<Integer> damageString =  weapons.get(i).attack(character);
                for (int j = 1; j < damageString.size(); j += 2)
                    expectedDamageOutput += damageString.get(j);

                if (expectedDamageOutput > tmp) {
                    optimalWeaponIndex = i;
                    tmp = expectedDamageOutput;
                }
            }
        }
        //setting optimal armour - this with highest damage reduction
        ArrayList<Armour> armours = character.getInventory().getArmours();
        int expectedDamageReduction = 0;
        int optimalArmourIndex = -1;
        tmp = 0;
        for(int i =0;i<armours.size();i++){
            expectedDamageReduction = 0;
            ArrayList<Integer> reductionString = armours.get(i).blockDamage();
            for(int j=1;j<reductionString.size();j+=2)
                expectedDamageReduction += reductionString.get(j);
            if(expectedDamageReduction>tmp) {
                optimalArmourIndex = i;
                tmp = expectedDamageReduction;
            }
        }
        if(optimalWeaponIndex!=-1)
            character.getInventory().setCurrentWeapon(weapons.get(optimalWeaponIndex));
        if(optimalArmourIndex!=-1)
            character.getInventory().setCurrentArmour(armours.get(optimalArmourIndex));
        ArrayList<Item> items = character.getInventory().getItems();
        //Looking for shield if both in hand is one-handed weapon
        if(!character.getInventory().getCurrentWeapon().getHands()) {

            for (Item item : items) {
                if (item.getName().equals("Shield")) {
                    character.getInventory().setCurrentItem(item);
                    break;
                }
            }
        }

    }
    public void resolveStatusEffects(){
        int bleed = character.getSpecificStatusEffectValue(0);
        System.out.println("Character " + character.getName() + " Bleed: "+bleed);
        Scribe.addLog(character.getName()+ " Bleeds : " + bleed);
        character.takeDamage(bleed);
        character.setSpecificStatusEffect(0,0);
        if(character.getCurrentHp()<=0)
            character.kill();
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }
    public boolean isInjured() {return injured;}

}
