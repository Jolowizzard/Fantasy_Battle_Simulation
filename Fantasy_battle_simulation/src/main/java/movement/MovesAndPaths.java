package movement;

import characters.Character;
import gui.GamePanel;
import inventory.items.*;
import map.MAPtable;
import map.Tile;
import simulation.Simulation;
import simulationsetup.Scribe;
import java.util.ArrayList;

public class MovesAndPaths {
    public static void Move(characters.Character character, ArrayList<Tile> locations,GamePanel gamePanel){
        int movement = character.getMovement()-character.getInventory().getCurrentArmour().getMSReduction();
        if(movement<=0)
            return;
        Tile location = null;
        if(locations.size() == 0)
            return;
        if(movement>locations.size()){
            try {
                smallMoveAnimation((movement-1)-(movement-locations.size()), locations,character);
            }catch (Exception e){
                e.printStackTrace();
            }
           if((movement-1)-(movement-locations.size())>=0){
               location = locations.get((movement-1)-(movement-locations.size()));}//Stands next to the target
        }
        else {
            try {
                smallMoveAnimation(character.getMovement(),locations,character);
            }catch (Exception e){
                e.printStackTrace();
            }
            location = locations.get(movement - 1);
        }
     try {
         Thread.sleep(20);
     }catch (Exception e){
         e.printStackTrace();
     }
     gamePanel.logEvent(character.getName()+ " Moves to " + location.col + " " + location.row);
     Scribe.addLog(character.getName()+ " Moves to " + location.col + " " + location.row);
        MAPtable.changeLocation(character,location);
    }
    private static void smallMoveAnimation(int movement, ArrayList<Tile> locations, Character character) throws InterruptedException {
        for(int i = 0;i<movement;i++){
            character.getRepresentation().setPosition(locations.get(i).col,locations.get(i).row);
            Thread.sleep(200);
        }
    }
}
