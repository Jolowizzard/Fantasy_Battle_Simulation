package simulationsetup;

import gamestructure.Team;

import java.io.FileReader;
import java.util.List;

public class TeamCreator {
    public static Team teamYellow;
    public static Team teamPurple;

    public TeamCreator() {
        teamPurple = new Team();
        teamYellow = new Team();
    }
    public void CreateTeamsFromFile(String fileName){
        try {
            CharacterCreator characterCreator = new CharacterCreator();
            CSVReader csvReader = new CSVReader(fileName);
            List<String[]> csvData = csvReader.readAll();
            if(csvData.size() > 0) {
                for (int i = 0; i < csvData.size() / 2; i += 2) {
                    teamYellow.addCharacter(characterCreator.createCharacterFromString(csvData.get(i), csvData.get(i + 1)));//reading characters statistics and inventor setup
                }
                if(csvData.size()>2) {
                    for (int i = (csvData.size() / 2); i < csvData.size(); i += 2) {
                        teamPurple.addCharacter(characterCreator.createCharacterFromString(csvData.get(i), csvData.get(i + 1)));
                    }
                }
                System.out.println(teamYellow.getTeam());
                System.out.println(teamPurple.getTeam());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Team getTeamPurple() {
        return teamPurple;
    }
    public Team getTeamYellow() {
        return teamYellow;}
}
