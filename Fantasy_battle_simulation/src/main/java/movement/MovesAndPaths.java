package movement;

import characters.Character;
import gui.GamePanel;
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
        //locations.forEach(tile -> System.out.println(tile.col + " " + tile.row));
        if(locations.size() == 0)
            return;
        if(movement>locations.size()){
            try {
                smallMoveAnimation((movement-1)-(movement-locations.size()), locations,character);
            }catch (Exception e){
                e.printStackTrace();
            }
           if((movement-1)-(movement-locations.size())>=0){location = locations.get((movement-1)-(movement-locations.size()));}//Stands next to the target
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
   /* static ArrayList<Integer> FindPath(int start,int target){
        int position=start;
        int tmp=position;
        double currentDistance;
        while(position!=target){
            currentDistance = CalculateDistanse(position,target);
            if()
        }
    }*/
  /*  static boolean CheckForObstacles(int position){
        if(map.MAPtable.Map[map.MAPtable.xLocationOf(position)][map.MAPtable.xLocationOf(position)]==1)
            return true;
        return false;
    }*/
/*    static double CalculateDistanse(int a,int b){
        int xa = map.MAPtable.xLocationOf(a);
        int ya = map.MAPtable.yLocationOf(a);
        int xb = map.MAPtable.xLocationOf(b);
        int yb = map.MAPtable.yLocationOf(b);
        return Math.sqrt((xa+xb)*(xa+xb)+(ya+yb)*(ya+yb));
    }*/
}
