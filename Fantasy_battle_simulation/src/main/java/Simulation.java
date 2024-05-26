import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Simulation {
    public static void main(String [] args ){

        MAPtable.InitializeMap("Mapa_1.txt");
        Weapon ssword = new Sword("Sword",10,0,1,100,false);
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Weapons.add(ssword);
        Inventory inventory = new Inventory(Weapons);
        InteligenceType inteligenceType1 = new Agressive(true);
        InteligenceType inteligenceType2 = new Agressive(true);
        InteligenceType inteligenceType3 = new Agressive(true);
        Tile start = new Tile(0,0);
        Tile finish = new Tile(15,15);
        Tile testobject1Tile = new Tile (15,14);
        Tile g1 = new Tile(7,7);
        Tile g2 = new Tile(6,7);
        Tile g3 = new Tile(7,6);
        Tile g4 = new Tile(7,8);
        Tile g5 = new Tile(8,7);
        Character testobject1 = new Knight(2, "Test_1", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType1, true, 0, 0,MAPtable.Map[start.col][start.row]);
        Character testobject2 = new Knight(3, "Test_2", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType2, true, 0, 0,MAPtable.Map[finish.col][finish.row]);
        Character testobject3 = new Knight(4, "Test_3", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType3, true, 0, 0,MAPtable.Map[testobject1Tile.col][testobject1Tile.row]);
        //inteligenceType.setTarget(testobject2);
        MAPtable.placeCharacterOnMap(start);
        MAPtable.placeCharacterOnMap(finish);
        MAPtable.placeCharacterOnMap(testobject1Tile);
        MAPtable.placeCharacterOnMap(g1);
        MAPtable.placeCharacterOnMap(g2);
        MAPtable.placeCharacterOnMap(g3);
        MAPtable.placeCharacterOnMap(g4);
        MAPtable.placeCharacterOnMap(g5);
        inteligenceType1.setCharacter(testobject1);
        inteligenceType2.setCharacter(testobject2);
        inteligenceType3.setCharacter(testobject3);
        ArrayList<Character> team = new ArrayList<>();
        team.add(testobject1);
        Team teamA = new Team(team);
        team.clear();
        team.add(testobject2);
        team.add(testobject3);
        Team teamB = new Team(team);
        System.out.println(teamA.team);
        System.out.println(teamB.team);
        testobject2.getIntType().setEnemies(teamA);
        testobject3.getIntType().setEnemies(teamA);
        testobject1.getIntType().setEnemies(teamB);
        boolean printed = false;
        for(int i = 0;i<11;i++){
            testobject1.getIntType().PerformTurn();
            testobject2.getIntType().PerformTurn();
            testobject3.getIntType().PerformTurn();
            for(int col =0;col<16;col++){
                for(int row=0;row<16;row++){
                    printed = false;
                    for(int j=0;j<teamA.team.size();j++) {
                        if (MAPtable.Map[col][row] == teamA.team.get(j).getPosition()) {
                            System.out.print("A ");
                            printed=true;
                        }
                    }
                    for(int j=0;j<teamB.team.size();j++){
                        if(MAPtable.Map[col][row]==teamB.team.get(j).getPosition()) {
                            System.out.print("B ");
                            printed=true;
                        }
                    }
/*                    for(int j=0;j<teamB.team.size();j++){
                        if(MAPtable.Map[col][row]==teamB.team.get(j).getPosition()) {
                            System.out.print("C ");
                            printed=true;
                        }
                    }*/
                    if(!printed) {
                        if (MAPtable.Map[col][row].solid)
                            System.out.print("1 ");
                        else
                            System.out.print("0 ");
                    }
                }

                System.out.println();

            }
/*            for(int r =0;r<16;r++){
                for(int k=0;k<16;k++){
                    if(MAPtable.Map[r][k].occupied==true){
                        System.out.print(MAPtable.Map[r][k]+" ");
                    }
                }
            }*/
            System.out.println();
        }

    }
    }
