package weapons;

import characters.Character;
import map.MAPtable;
import map.Tile;
import weapons.Weapon;
import combat.Combat;
import java.util.ArrayList;
import characters.*;
public class Bow extends Weapon {
    public Bow(String Name, int PhisicalDamage, int MagicDamage, int Range, int Accuracy, boolean Hands,boolean magickWeapon){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands,magickWeapon);
    }
    public Bow(){
        setHands(true);
        setAccuracy(70);
        setRange(4);
        setMagicDamage(0);
        setMagickWeapon(false);
        setPhisicalDamage(10);
    }
    @Override
    public int attack(Character user) {
        return getPhisicalDamage() + user.getDexterity();
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
public Tile FindPlaceToAttackFrom(Character character, Character target){
     ArrayList <Tile> openTiles = new ArrayList<>();
     ArrayList <Tile> checkedTiles = new ArrayList<>();
     ArrayList<Tile> finalPath = new ArrayList<>();
     Tile currentTile = new Tile(character.getPosition().col,character.getPosition().row);
     Tile tile;
             for(int i = 0;i< character.getMovement();i++)
             {
                 int col = currentTile.col;
                 int row = currentTile.row;

                 currentTile.SetAsChecked();
                 checkedTiles.add(currentTile);
                 openTiles.remove(currentTile);
                 //opening tiles
                 if(row-1 >= 0) {
                     tile = MAPtable.Map[col][row - 1];
                     if(tile.open == false && tile.checked == false && tile.solid == false && tile.occupied == false){
                         tile.SetAsOpen();
                         openTiles.add(tile);
                         GetCost(tile,character,target);
                     }
                 }
                 if(row+1 < MAPtable.rowSize) {
                     tile = MAPtable.Map[col][row + 1];
                     if(tile.open == false && tile.checked == false && tile.solid == false && tile.occupied == false){
                         tile.SetAsOpen();
                         openTiles.add(tile);
                         GetCost(tile,character,target);
                     }
                 }
                 if(col-1 >= 0) {
                     tile = MAPtable.Map[col - 1][row];
                     if(tile.open == false && tile.checked == false && tile.solid == false && tile.occupied == false){
                         tile.SetAsOpen();
                         openTiles.add(tile);
                         GetCost(tile,character,target);
                     }
                 }
                 if(col+1 < MAPtable.colSize) {
                     tile = MAPtable.Map[col + 1][row];
                     if(tile.open == false && tile.checked == false && tile.solid == false && tile.occupied == false){
                         tile.SetAsOpen();
                         openTiles.add(tile);
                     }
                 }
                 int bestTileIndex = 0;
                 int bestTilefCost = Integer.MAX_VALUE;
                 /*for(int i=0; i < openTiles.size();i++){
                     if(openTiles.get(i).fCost < bestTilefCost && character.getInventory().getCurrentWeapon().getRange()-openTiles.get(i).hCost){
                         bestTileIndex = i;
                         bestTilefCost = openTiles.get(i).fCost;
                     }
                     else if(openTiles.get(i).fCost == bestTilefCost){
                         if(openTiles.get(i).fCost < openTiles.get(bestTileIndex).fCost){
                             bestTilefCost = i;
                         }
                     }
                 }*/
             }
        /*return tile;*/
    return null;
    }
    private void GetCost(Tile tile, characters.Character character, characters.Character target){
        int xDis = Math.abs(tile.col - character.getPosition().col);
        int yDis = Math.abs(tile.row - character.getPosition().col);
        tile.gCost = xDis + yDis;
        xDis = Math.abs(tile.col - target.getPosition().col);
        yDis = Math.abs(tile.row - target.getPosition().col);
        tile.hCost = xDis + yDis;
        tile.fCost = tile.gCost + tile.hCost;
    }
}
