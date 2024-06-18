package map;

import java.awt.image.BufferedImage;

/**
 * Map consists of Tiles
 */
public class Tile {
    public Tile parent;
    public int col;
    public int row;
    public int gCost;
    public int hCost;
    public int fCost;
    public boolean start;
    public boolean destination;
    public boolean solid;
    public boolean open;
    public boolean checked;
    public boolean occupied;
    public boolean stop;

    public BufferedImage image;

    /**
     * Tile consists of coordinates row and column
     * @param col
     * @param row
     */
    public  Tile(int col, int row){
        this.col = col;
        this.row = row;
    }
    public void SetAsStart(){
        start = true;
    }
    public void SetAsDestination(){
        destination = true;
    }

    /**
     * Solid indicates that on certain Tile there is an obsticle
     */
    public void SetAsSolid(){
        solid = true;
    }

    /**
     * Occupied indicates that on certain Tile there is another character
     */
    public void SetAsOccupied(){
        occupied = true;
    }
    public void SetAsUnoccupied(){
        occupied = false;
    }


    public void SetAsChecked(){
        if(start == false && destination == false)
            checked=true;
    }
    public void SetAsOpen(){
        open = true;
    }
    public void SetAsUnsolid(){ solid = false;}
    public void SetAsStop(){stop = true;}
}
