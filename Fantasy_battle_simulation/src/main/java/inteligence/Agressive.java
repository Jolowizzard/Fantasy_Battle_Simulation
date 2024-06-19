package inteligence;

import characters.Character;
import characters.rogue.Rogue;
import characters.warriors.Warrior;
import combat.Combat;
import gui.GamePanel;
import inventory.items.Item;
import map.Tile;
import searchalgorythm.SearchAlgorythm;
import movement.MovesAndPaths;
import java.util.ArrayList;
import gamestructure.*;
import map.*;
public class Agressive extends InteligenceType {
    // First prototype. Only two states which specifies two action, fighting and healing.
    private boolean readyToFight;
    public Agressive(boolean readyToFight){
        super();
        this.readyToFight=readyToFight;
    }

    /**
     * This method preforms turn of a character
     * Makes decision and gives orders
     */
    @Override
    public void PerformTurn(){
        resolveStatusEffects();
        if(!character.checkIfIsAlive())
            return;
        gamePanel.logEvent(character.getName() + " performs turn");
        System.out.println(character.getName() + " : performe turn. In combat :" + inCombat + " Injured : " + isInjured());
        if(character.getInventory().getCurrentWeapon()==null) {
            character.getInventory().setCurrentWeapon(character.getInventory().getWeapons().get(0));
        }

        target = lookForTarget();
        //System.out.println(target);
        if(checkIfYouWon())
            return;
        //Performing healing actions
        if(isInjured())
        {

            System.out.println("Checking for using healing potion : " +character.getCurrentHp() + " < " + (int)(((float)character.getMaxHp())*(float)(20.0/100.0)));
            if(character.getCurrentHp()<(int)(((float)character.getMaxHp())*(float)(20.0/100.0))){
                //Searching for HealPotion in the inventory this is not optimal thou, because he will try to use empty healpotions
                for(int i =0; i< character.getInventory().getItems().size(); i++){
                    if(character.getInventory().getItems().get(i).getName().equals("HealPotion")) {
                        character.getInventory().getItems().get(i).use(character);
                        break;
                    }
                }
            }
        }
        if(readyToFight){
            if(!checkIfEnemyIsInRange()){
                MoveTowardsOpponent(character,target,gamePanel);
                if(character.getMainClass().equals("Rogue") && !checkIfEnemyIsInRange()){
                    Rogue rogue = (Rogue) character;
                    boolean acitveSecondMove = rogue.getSecondMove();
                    if(acitveSecondMove) {
                        rogue.performSecondMove(true);
                        rogue.setSecondMove(false);
                    }

                }
                if(checkIfEnemyIsInRange()){
                    if (character.getInventory().getCurrentWeapon().canAttack(character, target)) {
                        target.getIntType().setInCombat();
                        Combat combat = new Combat(character,target);
                        System.out.println(character.getName() + ": Enemy in range, ready to attack");
                        combat.BeginCombat();
                    }
                }
            }
            else {
                if (character.getInventory().getCurrentWeapon().canAttack(character, target)) {
                    target.getIntType().setInCombat();
                    Combat combat = new Combat(character,target);
                    System.out.println(character.getName() + ": Enemy in range, ready to attack");
                    combat.BeginCombat();
                } else {
                    MoveTowardsOpponent(character,target,gamePanel);
                    if (character.getInventory().getCurrentWeapon().canAttack(character, target)) {
                        target.getIntType().setInCombat();
                        Combat combat = new Combat(character,target);
                        System.out.println(character.getName() + ": Enemy in range, ready to attack");
                        combat.BeginCombat();
                    }
                }
            }
            if(character.getMainClass().equals("Rogue")){
                Rogue rogue = (Rogue) character;
                boolean acitveSecondMove = rogue.getSecondMove();
                if(acitveSecondMove)
                    rogue.performSecondMove(false);
                rogue.setSecondMove(true);
            }
        }
        target = lookForTarget();
    }
    private void setTarget(){
    }

    public boolean checkIfYouWon(){
        if(target == null)
            return true;
        return false;
    }
}
