package movement;

import map.MAPtable;
import map.Tile;

import java.util.ArrayList;

public class MovesAndPaths {
 public static void Move(characters.Character character, ArrayList<Tile> locations){
        int movement = character.getMovement();
        if(movement<=0)
            return;
        Tile location = null;
        if(movement>locations.size()){
            location = locations.get((movement-1)-(movement-locations.size()));//Stands next to the target
        }
        else
            location = locations.get(movement-1);
        MAPtable.changeLocation(character,location);
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
