package inteligence;

import characters.Character;
import characters.rogue.Rogue;
import characters.warriors.Warrior;
import combat.Combat;
import map.Tile;
import searchalgorythm.SearchAlgorythm;
import movement.MovesAndPaths;
import java.util.ArrayList;
import gamestructure.*;
import map.*;
public class Agressive extends InteligenceType {
    // First prototype. Only two states which specifies two action, fighting and healing.
    private boolean readyToFight;
    private boolean injured;
    public Agressive(boolean readyToFight){
        super();
        this.readyToFight=readyToFight;
    }
    @Override
    public void PerformTurn(){
        if(!character.checkIfIsAlive())
            return;
        System.out.println(character.getName() + " : performe turn");
        if(character.getInventory().getCurrentWeapon()==null) {
            character.getInventory().setCurrentWeapon(character.getInventory().getWeapons().get(0));
        }
        target = lookForTarget();
        if(inCombat)
        {
            target = lookForTarget();
        }
        if(checkIfYouWon())
            return;
        if(readyToFight){
            if(!checkIfEnemyIsInRange()){
                MoveTowardsOpponent(character,target);
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
                    MoveTowardsOpponent(character,target);
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
        System.out.println(target.getName());
    }
    private void setTarget(){
    }

    public boolean checkIfYouWon(){
        if(target == null)
            return true;
        return false;
    }
}
