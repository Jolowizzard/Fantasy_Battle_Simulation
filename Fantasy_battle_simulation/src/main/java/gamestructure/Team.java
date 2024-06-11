package gamestructure;

import java.util.ArrayList;

public class Team{
    public ArrayList<characters.Character> team;

    public Team(ArrayList<characters.Character> team){
        ArrayList<characters.Character> teamc = new ArrayList<>(team);
        this.team = teamc;
    }
    public ArrayList<characters.Character> getTeam(){
        return team;
    }
    public void RemoveFromTeam (characters.Character character){
        if(!team.isEmpty()){
            team.remove(character);
        }
    }
    public boolean CheckIfTeamIsTeamAlive(){
        if(team.isEmpty())
            return false;
        else{
            return true;
        }
    }
}
