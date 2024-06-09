import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class Bow extends Weapon{
    Bow(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }
    @Override
    public void attack(Character attacker, Character defender) {
            Combat combat = new Combat();
            combat.DealDamage(defender, getPhisicalDamage() * attacker.getStrength());
    }
    public boolean canAttack(Character character, Character target){
        Tile startTile = character.getPosition();
        Tile finish = target.getPosition();
        double xVector = finish.col - startTile.col;
        double yVector = finish.row - startTile.row;
        double currentX = startTile.col;
        double currentY = startTile.row;
        //Edge case if tiles are in the same column
        if(xVector == 0 ){
            yVector = yVector/Math.abs(yVector);
            while(currentY!=finish.row)
            {
                currentY+=yVector;
                //System.out.println(MAPtable.Map[startTile.col][(int)currentY] + " : " + MAPtable.Map[startTile.col][(int)currentY].solid);
                System.out.println(MAPtable.Map[startTile.col][(int)currentY].col + MAPtable.Map[startTile.col][(int)currentY].row+ " : "  + MAPtable.Map[startTile.col][(int)currentY].solid);
                if(MAPtable.Map[startTile.col][(int)currentY].solid)//Checking for collision
                    return false;
            }
        }
        else
        {
            //Normalised vector
            yVector = yVector/Math.abs(xVector);
            xVector = xVector/Math.abs(xVector);
            while(currentY!=finish.row && currentX!=finish.col)
            {
                currentY+=yVector;
                currentX+=xVector;
                //System.out.println(MAPtable.Map[(int)currentX][(int)Math.floor(currentY)] + " : " + MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid);
                System.out.println(MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].col + "," + MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].row + " : " + MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid);
                if(MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid)//Checking for collision
                    return false;
            }
        }
        return true;
    }
/* public Tile FindPlaceToAttackFrom(Character character){
     ArrayList <Tile> openTiles = new ArrayList<>();
     ArrayList <Tile> checkedTiles = new ArrayList<>();
     ArrayList<Tile> finalPath = new ArrayList<>();
             for(int i = 0;i< character.getMovement();i++)
             {

             }
        return tile;
    }*/
}
