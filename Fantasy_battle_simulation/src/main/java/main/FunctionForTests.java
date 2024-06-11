package main;

import map.MAPtable;
import map.Tile;

import java.util.ArrayList;

public class FunctionForTests {
    static void PrintMap(Tile start, Tile finish, ArrayList<Tile> path){
        boolean printed=false;
        for(int i =0;i<16;i++){
            for(int j=0;j<16;j++){
                printed=false;
                for(int k=0;k<path.size();k++){
                    if(MAPtable.Map[i][j].col==path.get(k).col && MAPtable.Map[i][j].row==path.get(k).row) {
                        System.out.print("# ");
                        printed=true;
                    }
                }
                if(MAPtable.Map[i][j].solid==false && printed==false)
                    System.out.print("0 ");
                else if(printed==false)
                    System.out.print("1 ");
                else if(printed==false && MAPtable.Map[i][j].col==start.col && MAPtable.Map[i][j].row==start.row){
                    System.out.print("S ");
                }
                else if(printed==false && MAPtable.Map[i][j].col==start.col && MAPtable.Map[i][j].row==start.row){
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}
