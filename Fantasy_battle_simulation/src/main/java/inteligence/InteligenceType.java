package inteligence;
import characters.Character;
import gamestructure.*;
import map.MAPtable;
import map.Tile;
import movement.MovesAndPaths;
import searchalgorythm.SearchAlgorythm;

import java.util.ArrayList;

public abstract class InteligenceType{
    protected characters.Character target;
    protected characters.Character character;
    protected boolean inCombat=false;
    protected Team enemies;
    protected Team allays;
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
    public Character lookForTeammate(){
        int bestDistanse=999;
        Character OptimalTarget=null;
        for(int i = 0;i<allays.team.size();i++){
            if(allays.team.get(i).checkIfIsAlive() && allays.team.get(i) != character)
            {
                SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),allays.team.get(i).getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
                ArrayList<Tile> path = new ArrayList<>();
                path = searchAlgorythm.search();
                if(path.size()<bestDistanse) {
                    bestDistanse = path.size();
                    OptimalTarget=allays.team.get(i);
                }
            }
        }
        return OptimalTarget;
    }
    public void MoveTowardsOpponent(characters.Character character, characters.Character target){
        SearchAlgorythm searchAlgorythm = new SearchAlgorythm(character.getPosition(),target.getPosition(), MAPtable.Map, MAPtable.colSize, MAPtable.rowSize);
        ArrayList<Tile> path = new ArrayList<>();
        path = searchAlgorythm.search();
        MovesAndPaths.Move(character,path);
    }
    public abstract void PerformTurn();
    public Character getCharacter(){return character;}
}
