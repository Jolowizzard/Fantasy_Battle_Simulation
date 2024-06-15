package map;

import java.io.*;
import java.util.Scanner;

public class MAPtable implements Cloneable {
    public static Tile [][] Map = new Tile[16][16];
    public static int colSize = 16;
    public static int rowSize = 16;
    //static int ToNumberMap[][] = new int [16][16];
    //adds field numbering
    static void NumberMap(int ToNumberMap[][])
    {
        int iteration = 1;
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                ToNumberMap[i][j] = iteration;
                iteration++;
            }
        }
    }
    public static void placeCharacterOnMap(Tile location){
        int row = location.row;
        int col = location.col;
        Map[col][row].SetAsOccupied();
    }
    static void PrintMap(){
        for(int i =0;i<16;i++){
            for(int j =0;j<16;j++){
                System.out.print(MAPtable.Map[i][j]);
            }
            System.out.println();
        }
    }
    public static void changeLocation(characters.Character character, Tile location){
        Tile previousLocation = character.getPosition();
        Map[previousLocation.col][previousLocation.row].SetAsUnoccupied();
        int row = location.row;
        int col = location.col;
        character.setPosition(Map[col][row]);
        Map[col][row].SetAsOccupied();
    }
    //Function initializes the map from a .txt file
    public static void InitializeMap(String fileName){
        try {
            InputStream is = MAPtable.class.getResourceAsStream("/" + fileName);// Reading a file from resources
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            int x = 0;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s", "");
                for (int i = 0; i < line.length(); i++) {
                    Map[x][i] = new Tile(x, i);
                    if (line.charAt(i) == '1')
                        Map[x][i].SetAsSolid();
                }
                x++;
            }
        }
        catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //returns location as a integer value corresponding to a ToNumberMap
    //returns X coordinate of field
 /*   static int xLocationOf(int example)
    {

        for (int i = 0; i < 16; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                if(ToNumberMap[i][i2]==example)
                {
                    return i2;
                }
            }
        }
        return 420;
    }*/
    //Fuction changes values on files, that corresponds character present location and past location
    /*static void changeLocation(characters.Character character,int location){
        int x = xLocationOf(location);
        int y = yLocationOf(location);
        Map[x][y] = character.getId();
        x = xLocationOf(character.getPosition());
        y = xLocationOf(character.getPosition());
        Map[x][y] = 0;
        character.setPosition(location);
    }*/
    //returns Y coordinate of field
    /*static int yLocationOf(int example)
    {

        for (int i = 0; i < 16; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                if(ToNumberMap[i][i2]==example)
                {
                    return i;
                }
            }
        }
        return 420;
    }*/



    //returns numbers of all empty fields around input field
    /*static ArrayList<Integer> EmptyCloseNeighbours(int example)
    {
        ArrayList <Integer> CloseNeighbourTab = new ArrayList<Integer>() ;
        if(xLocationOf(example)>0 && Map[xLocationOf(example)-1][yLocationOf(example)]==0)
        {
            CloseNeighbourTab.add(example-1);
        }
        if(xLocationOf(example)<15 && Map[xLocationOf(example)+1][yLocationOf(example)]==0)
        {
            CloseNeighbourTab.add(example+1);
        }
        if (yLocationOf(example) > 0 && Map[xLocationOf(example)][yLocationOf(example) - 1] == 0)
        {
            CloseNeighbourTab.add(example-16);
        }
        if (yLocationOf(example) < 15 && Map[xLocationOf(example)][yLocationOf(example) + 1] == 0)
        {
            CloseNeighbourTab.add(example+16);
        }
        return CloseNeighbourTab;
    }*/
    /*static int GetPosition(int id){
        int iteration = 0;
        for(int i = 0;i<16;i++){
            for(int j=0;j<16;j++){
                iteration++;
                if(Map[i][j]==id){
                    return iteration;
                }
            }
        }
        return -1;//postion not found
    }*/
    //returns all possible fields to which a troop can move with certain number of movement points
    /*static HashSet<Integer> PossibleMoves(int trooplocation, int movementpts)
    {
        HashSet<Integer>temp = new HashSet<Integer>();
        HashSet <Integer> AllPossibleMoves = new HashSet<Integer>();
        temp.add(trooplocation);
        for(int i=0;i<=movementpts;i++)
        {
            for (int element : AllPossibleMoves)
            {
                temp.addAll(EmptyCloseNeighbours(element));
            }
            AllPossibleMoves.addAll(temp);
        }
        return AllPossibleMoves;
    }*/
}