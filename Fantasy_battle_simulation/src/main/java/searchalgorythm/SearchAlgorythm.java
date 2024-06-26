package searchalgorythm;

import map.Tile;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * used for pathfinding during simulation
 */
public class SearchAlgorythm {
    private int maxCol = 16;
    private int maxRow = 16;
    /*final int nodeSize = 70;*//*
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;*/
    Tile startTile, destinationTile, currentTile;
    boolean goalReached = false;

    Tile[][] tiles = new Tile[maxRow][maxCol];
    ArrayList<Tile> checked = new ArrayList<>();
    ArrayList<Tile> open = new ArrayList<>();
    // Constructor needs start tile, destination map.Tile, map used in simulation, size of the map, numbers of columns and rows

    /**
     * sets parameters for future pathfinding
     * @param startTile
     * @param destinationTile
     * @param map
     * @param maxCol
     * @param maxRow
     */
    public SearchAlgorythm(Tile startTile, Tile destinationTile, Tile[][] map, int maxCol, int maxRow){
        Clone(map);
        this.startTile = startTile;
        this.destinationTile = destinationTile;
        this.maxCol = maxCol;
        this.maxRow = maxRow;
    }
    private void Clone(Tile[][] map){
        for(int col = 0;col<maxCol;col++){
            for(int row =0 ;row<maxRow;row++){
                tiles[row][col] = new Tile(map[row][col].col,map[row][col].row);
                if(map[row][col].solid)
                    tiles[row][col].SetAsSolid();
                if(map[row][col].occupied)
                    tiles[row][col].SetAsOccupied();
            }
        }
    }
/*    public void PlaceNodes(){
        for(int col=0;col<maxCol;col++){
            for(int row=0;row<maxRow;row++)
                tiles[col][row] = new map.Tile(col,row);
        }
    }*/

    /**
     * sets starting tile
     * @param col
     * @param row
     */
    private void SetStartTile(int col, int row){
        tiles[row][col].SetAsStart();
        startTile = tiles[row][col];
        currentTile = startTile;
    }

    /**
     * sets destination tile
     * @param col
     * @param row
     */
    private void SetDestinationTile(int col, int row){
        tiles[row][col].SetAsDestination();
        destinationTile = tiles[row][col];
    }
    /*private void SetSolidNode(int col, int row){
        tiles[row][col].SetAsSolid();
    }*/

    private void SetCostOnTiles(){
        for(int col = 0;col<maxCol;col++){
            for(int row = 0;row<maxRow;row++)
                GetCost(tiles[row][col]);
        }
    }
    private void GetCost(Tile tile){
        int xDis = Math.abs(tile.col - startTile.col);
        int yDis = Math.abs(tile.row - startTile.col);
        tile.gCost = xDis + yDis;
        xDis = Math.abs(tile.col - destinationTile.col);
        yDis = Math.abs(tile.row - destinationTile.col);
        tile.hCost = xDis + yDis;
        tile.fCost = tile.gCost + tile.hCost;
    }
    //Method searches for the shortest path to a destination and returns ArrayList of tiles from this path

    /**
     * pathfinding algorithm
     * @return
     */
    public ArrayList<Tile> search(){
        int steps=0;
        ArrayList<Tile> finalPath = new ArrayList<>();
        SetStartTile(startTile.col,startTile.row);
        SetDestinationTile(destinationTile.col,destinationTile.row);
        SetCostOnTiles();
        while(goalReached == false && steps<300){
            steps++;
            int col = currentTile.col;
            int row = currentTile.row;

            currentTile.SetAsChecked();
            checked.add(currentTile);
            open.remove(currentTile);
            if(row-1 >= 0)
                openTile(tiles[row-1][col]);
            if(row+1 < maxRow)
                openTile(tiles[row+1][col]);
            if(col-1 >= 0)
                openTile(tiles[row][col-1]);
            if(col+1 < maxCol)
                openTile(tiles[row][col+1]);

            int bestTileIndex = 0;
            int bestTilefCost = Integer.MAX_VALUE;

            for(int i=0; i < open.size();i++){
                if(open.get(i).fCost < bestTilefCost){
                    bestTileIndex = i;
                    bestTilefCost = open.get(i).fCost;
                }
                else if(open.get(i).fCost == bestTilefCost){
                    if(open.get(i).fCost < open.get(bestTileIndex).fCost){
                        bestTilefCost = i;
                    }
                }
            }
            //hier is an error occuring on map_4 when finish is set on 15,1
            if(open.size() == 0)
                break;
            if(open.get(bestTileIndex).stop)
            {
                goalReached = true;
                finalPath = trackThePath();
                ResetParents();
                return finalPath;
            }
            currentTile = open.get(bestTileIndex);
            if(currentTile == destinationTile){
                goalReached = true;
                finalPath = trackThePath();
                ResetParents();
                return finalPath;
            }
        }
        return finalPath;
    }

    private void openTile(Tile tile){
        if(tile.destination == true && tile.occupied == true){
            tile.SetAsOpen();
            tile.SetAsStop();
            tile.parent = currentTile;
            open.add(tile);
        }
        if(tile.open == false && tile.checked == false && tile.solid == false && tile.occupied == false){
            tile.SetAsOpen();
            tile.parent = currentTile;
            open.add(tile);
        }
    }

    /**
     * resets pathfinding parameters
     */
    private void ResetParents(){
        for(int i=0;i<maxCol;i++){
            for(int j=0; j<maxRow;j++){
                tiles[j][i].parent=null;
            }
        }
    }
    //funtion returns array list as a path from a start to destination without destination map.Tile and starting tile
    private ArrayList<Tile> trackThePath(){
        Tile current = destinationTile;
        ArrayList<Tile> path = new ArrayList<>();
        ArrayList<Tile> revesredPath = new ArrayList<>();// output of a method
        while(current != startTile){
            current = current.parent;
            if(current != startTile){
                path.add(current);
            }
        }
        //Reversing path to order from start to finish
        for(int i = path.size()-1 ; i >= 0 ; i--){
            revesredPath.add(path.get(i));
        }
        path.remove(destinationTile);
        return revesredPath;
    }
}
