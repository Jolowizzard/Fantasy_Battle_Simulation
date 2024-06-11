package inteligence;
import gamestructure.*;
public abstract class InteligenceType{
    protected characters.Character target;
    protected characters.Character character;
    protected boolean inCombat=false;
    protected Team enemies;
    public InteligenceType(){
    }
    public characters.Character GetTarget(){return target;}
    public void setCharacter(characters.Character character){this.character = character;}
    public void setTarget(characters.Character character){target = character;}
    public void setEnemies(Team enemies){
        this.enemies=enemies;
    }
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
    public abstract void PerformTurn();
}
