package gamestructure;

import java.util.ArrayList;
import characters.Character;

public class Team{
    private ArrayList<Character> team;

    public Team(ArrayList<Character> team){
        ArrayList<Character> teamc = new ArrayList<>(team);
        this.team = team;
    }
    public Team(){
        team = new ArrayList<>();
    }
    public void addCharacter(Character c){
        team.add(c);
    }
    public ArrayList<Character> getTeam(){
        return team;
    }
    public void RemoveFromTeam (Character character){
        if(!team.isEmpty()){
            team.remove(character);
        }
    }
    public boolean CheckIfTeamIsTeamAlive(){
        int aliveCharacters=0;

        for(int i =0; i<team.size();i++){
            if(team.get(i).checkIfIsAlive())
                aliveCharacters++;
        }
            if(aliveCharacters==0)
                return false;
            return true;
    }
}
