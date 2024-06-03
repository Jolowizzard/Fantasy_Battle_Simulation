public class Bow extends Weapon{
    Bow(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }
    @Override
    public void attack(Character attacker, Character defender) {
        if(!checkColision(attacker.getPosition(),defender.getPosition())) {
            Combat combat = new Combat();
            combat.DealDamage(defender, getPhisicalDamage() * attacker.getStrength());
        }
    }
    private boolean checkColision(Tile startTile, Tile finish){
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
                    return true;
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
                    return true;
            }
        }
        return false;
    }
}
