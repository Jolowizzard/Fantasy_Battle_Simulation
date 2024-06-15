package simulationsetup;

import gamestructure.Team;

import java.io.FileReader;
import java.util.List;

public class TeamCreator {
    private Team teamYellow;
    private Team teamPurple;
    public TeamCreator() {
        teamPurple = new Team();
        teamYellow = new Team();
    }
    public void CreateTeamsFromFile(String fileName){
        try {
            CharacterCreator characterCreator = new CharacterCreator();
            CSVReader csvReader = new CSVReader(fileName);
            List<String[]> csvData = csvReader.readAll();
            for(int i = 0; i < csvData.size()/2; i+=2){
                teamYellow.addCharacter(characterCreator.createCharacterFromString(csvData.get(i), csvData.get(i+1)));//reading characters statistics and inventor setup
            }
            for(int i = (csvData.size()/2); i < csvData.size(); i+=2){
                teamPurple.addCharacter(characterCreator.createCharacterFromString(csvData.get(i), csvData.get(i+1)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
