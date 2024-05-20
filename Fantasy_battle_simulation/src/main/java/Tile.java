public class Tile {
    Tile parent;
    int col;
    int row;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean destination;
    boolean solid;
    boolean open;
    boolean checked;
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
    public void SetAsSolid(){
        solid = true;
    }
    public void SetAsChecked(){
        if(start == false && destination == false)
            checked=true;
    }
    public void SetAsOpen(){
        open = true;
    }
}
