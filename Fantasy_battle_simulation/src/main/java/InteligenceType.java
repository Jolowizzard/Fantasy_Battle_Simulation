public abstract class InteligenceType{
    protected Character target;
    protected Character character;
    protected Team enemies;
    public InteligenceType(){
    }
    public Character GetTarget(){return target;}
    public void setCharacter(Character character){this.character = character;}
    public void setTarget(Character character){target = character;}
    public void setEnemies(Team enemies){
        this.enemies=enemies;
    }
    protected boolean checkIfEnemyIsInRange(){
        double distance;
        //calculating euclidean distance between to characters
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }
    public abstract void PerformTurn();
}
