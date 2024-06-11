package inteligence;

import characters.Character;
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
                MoveTowardsOpponent(character);
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
                    MoveTowardsOpponent(character);
                    if (character.getInventory().getCurrentWeapon().canAttack(character, target)) {
                        target.getIntType().setInCombat();
                        Combat combat = new Combat(character,target);
                        System.out.println(character.getName() + ": Enemy in range, ready to attack");
                        combat.BeginCombat();
                    }
                }
            }
/*                if(checkIfEnemyIsInRange())
                {
                    target.getIntType().setInCombat();
                    character.getInventory().getCurrentWeapon().attack(character,target);
                    System.out.println(character.getName() + ": Enemy in range, ready to attack");
                }
            }else{
                target.getIntType().setInCombat();
                character.getInventory().getCurrentWeapon().attack(character,target);
                System.out.println(character.getName()+ ": Enemy in range, ready to attack");*/

        }
        System.out.println(target.getName());
    }
    private void MoveTowardsOpponent(characters.Character character){
        SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),target.getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
        ArrayList<Tile> path = new ArrayList<>();
        path = searchAlgorythm.search();
        MovesAndPaths.Move(character,path);
    }
    private void setTarget(){
    }
    private Character lookForTarget(){
        int bestDistanse=999;
        Character OptimalTarget=null;
        for(int i = 0;i<enemies.team.size();i++){
            if(enemies.team.get(i).checkIfIsAlive())
            {
                SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),enemies.team.get(i).getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
                ArrayList<Tile> path = new ArrayList<>();
                path = searchAlgorythm.search();
                if(path.size()<bestDistanse) {
                    bestDistanse = path.size();
                    OptimalTarget=enemies.team.get(i);
                }
            }
        }
        return OptimalTarget;
    }
    public boolean checkIfYouWon(){
        if(target == null)
            return true;
        return false;
    }
}
