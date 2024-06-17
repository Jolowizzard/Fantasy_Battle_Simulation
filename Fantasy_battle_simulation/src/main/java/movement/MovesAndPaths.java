package movement;

import gui.GamePanel;
import map.MAPtable;
import map.Tile;
import simulation.Simulation;
import simulationsetup.Scribe;

import java.util.ArrayList;

public class MovesAndPaths {
 public static void Move(characters.Character character, ArrayList<Tile> locations){
        int movement = character.getMovement()-character.getInventory().getCurrentArmour().getMSReduction();
        if(movement<=0)
            return;
        Tile location = null;
        if(movement>locations.size()){
            try {
                smallMoveAnimation(character, locations);
            }catch (Exception e){
                e.printStackTrace();
            }
            location = locations.get((movement-1)-(movement-locations.size()));//Stands next to the target
        }
        else {
            try {
                smallMoveAnimation(character, locations);
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

     Scribe.addLog(character.getName()+ " Moves to " + location.col + " " + location.row);
        MAPtable.changeLocation(character,location);
    }
    private static void smallMoveAnimation(characters.Character character, ArrayList<Tile> locations) throws InterruptedException {
        for(int i = 0;i<character.getMovement();i++){
            character.getRepresentation().setPosition(locations.get(i).col,locations.get(i).row);
            Thread.sleep(500);
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
