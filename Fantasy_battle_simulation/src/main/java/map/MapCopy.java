package map;

import map.Tile;

import java.util.ArrayList;

public class MapCopy {
    private int maxCol = 16;
    private int maxRow = 16;
    Tile startTile, destinationTile, currentTile;
    Tile[][] tiles = new Tile[maxCol][maxRow];
    ArrayList<Tile> checked = new ArrayList<>();
    ArrayList<Tile> open = new ArrayList<>();


    /**
     * makes copy of a map
     * @param startTile
     * @param destinationTile
     * @param map
     * @param maxCol
     * @param maxRow
     */
    public MapCopy(Tile startTile,Tile destinationTile,Tile [][] map,int maxCol,int maxRow){
        Clone(map);
        this.startTile = startTile;
        this.destinationTile = destinationTile;
        this.maxCol = maxCol;
        this.maxRow = maxRow;
    }

    /**
     * clones Tiles of a map
     * @param map
     */
    private void Clone(Tile [][] map){
        for(int i = 0;i<maxCol;i++){
            for(int j =0 ;j<maxRow;j++){
                tiles[i][j] = new Tile(map[i][j].col,map[i][j].row);
                if(map[i][j].solid)
                    tiles[i][j].SetAsSolid();
                if(map[i][j].occupied)
                    tiles[i][j].SetAsOccupied();
            }
        }
    }

    /**
     *
     * @param tile
     */
    public void GetCost(Tile tile){
        int xDis = Math.abs(tile.col - startTile.col);
        int yDis = Math.abs(tile.row - startTile.col);
        tile.gCost = xDis + yDis;
        xDis = Math.abs(tile.col - destinationTile.col);
        yDis = Math.abs(tile.row - destinationTile.col);
        tile.hCost = xDis + yDis;
        tile.fCost = tile.gCost + tile.hCost;
    }
    private void SetStartTile(int col, int row){
        tiles[col][row].SetAsStart();
        startTile = tiles[col][row];
        currentTile = startTile;
    }
    public void openTile(Tile tile){
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
}
