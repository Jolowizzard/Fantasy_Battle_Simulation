import java.util.ArrayList;
import java.util.HashSet;

public class MAPtable {
    static int Map[][] = new int[16][16];
    static int ToNumberMap[][] = new int [16][16];

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


    //returns X coordinate of field
    static int xLocationOf(int example)
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
    }


    //returns Y coordinate of field
    static int yLocationOf(int example)
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
    }



    //returns numbers of all empty fields around input field
    static ArrayList<Integer> EmptyCloseNeighbours(int example)
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
    }



    //returns all possible fields to which a troop can move with certain number of movement points
    static HashSet<Integer> PossibleMoves(int trooplocation, int movementpts)
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
    }
}