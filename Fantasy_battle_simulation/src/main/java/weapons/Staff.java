package weapons;

import characters.Character;
import map.MAPtable;
import map.Tile;

import java.util.ArrayList;

public class Staff extends Weapon{
    Staff(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands,boolean MagickWeapon){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands,MagickWeapon);
    }
    Staff(){
        setHands(true);
        setAccuracy(100);
        setMagicDamage(15);
        setName("Staff");
        setRange(5);
        setPhisicalDamage(0);
        setMagickWeapon(true);
    }
    @Override
    public ArrayList<Integer> attack(Character user) {
            ArrayList<Integer> damageTypes = new ArrayList<>();
            //Now we use only two damage types - magical and physical
            damageTypes.add(0);
            damageTypes.add(getPhisicalDamage() + user.getStrength()/10);
            if(getMagickWeapon()) {
                damageTypes.add(1);
                damageTypes.add(getMagicDamage() + user.getIntelignece());
            }
            return damageTypes;
    }
    @Override
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
                //System.out.println(map.MAPtable.Map[startTile.col][(int)currentY] + " : " + map.MAPtable.Map[startTile.col][(int)currentY].solid);
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
                //System.out.println(map.MAPtable.Map[(int)currentX][(int)Math.floor(currentY)] + " : " + map.MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid);
                System.out.println(MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].col + "," + MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].row + " : " + MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid);
                if(MAPtable.Map[(int)currentX][(int)Math.floor(currentY)].solid)//Checking for collision
                    return false;
            }
        }
        return true;
    }
}
