import java.util.ArrayList;
import java.util.HashSet;
import java.math.*;
import java.util.Iterator;

public class Agressive extends InteligenceType{
    // First prototype. Only two states which specifies two action, fighting and healing.
    private boolean readyToFight;
    private boolean injured;
    public Agressive(boolean readyToFight){
        super();
        this.readyToFight=readyToFight;
    }
    @Override
    public void PerformTurn(){
        System.out.println(character.getName() + " : performe turn");
        if(character.getInventory().getCurrentWeapon()==null) {
            character.getInventory().setCurrentWeapon(character.getInventory().getWeapons().get(0));
        }
        target = lookForTarget();
        if(inCombat)
        {
            target = lookForTarget();
        }
        if(readyToFight){
            if(!checkIfEnemyIsInRange()) {
                MoveTowardsOpponent(character);
                if(checkIfEnemyIsInRange())
                {
                    target.getIntType().setInCombat();
                    character.getInventory().getCurrentWeapon().attack(character,target);
                    System.out.println(character.getName() + ": Enemy in range, ready to attack");
                }
            }else{
                target.getIntType().setInCombat();
                character.getInventory().getCurrentWeapon().attack(character,target);
                System.out.println(character.getName()+ ": Enemy in range, ready to attack");
            }
        }
        System.out.println(target.getName());
    }
    private void MoveTowardsOpponent(Character character){
        SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),target.getPosition(),MAPtable.Map,MAPtable.colSize,MAPtable.rowSize);
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
                SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),enemies.team.get(i).getPosition(),MAPtable.Map,MAPtable.colSize,MAPtable.rowSize);
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
}
