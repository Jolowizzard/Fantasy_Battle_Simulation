import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class MovesAndPaths {
 static void Move(Character character,ArrayList<Tile> locations){
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
        if(MAPtable.Map[MAPtable.xLocationOf(position)][MAPtable.xLocationOf(position)]==1)
            return true;
        return false;
    }*/
/*    static double CalculateDistanse(int a,int b){
        int xa = MAPtable.xLocationOf(a);
        int ya = MAPtable.yLocationOf(a);
        int xb = MAPtable.xLocationOf(b);
        int yb = MAPtable.yLocationOf(b);
        return Math.sqrt((xa+xb)*(xa+xb)+(ya+yb)*(ya+yb));
    }*/
}
