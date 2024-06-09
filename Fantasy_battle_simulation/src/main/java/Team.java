import java.util.ArrayList;

public class Team{
    public ArrayList<Character> team;

    public Team(ArrayList<Character> team){
        ArrayList<Character> teamc = new ArrayList<>(team);
        this.team = teamc;
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
        if(team.isEmpty())
            return false;
        else{
            return true;
        }
    }
}
