import characters.warriors.Knight;
import gamestructure.Team;
import inteligence.Agressive;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.MAPtable;
import map.Tile;
import weapons.Bow;
import weapons.Sword;
import weapons.Weapon;

import java.util.ArrayList;

public class Simulation {
    public static void main(String [] args ) {

        MAPtable.InitializeMap("C:\\Users\\aleks\\Java_projects\\Fantasy_battle_simulator\\Fantasy_Battle_Simulation\\Fantasy_battle_simulation\\src\\main\\resources\\map_1.txt");
        Weapon ssword = new Sword("weapons.Sword", 10, 0, 1, 100, false);
        Weapon bbow = new Bow("weapons.Bow", 10, 0, 6, 100, true);
        ArrayList<Weapon> Weapons = new ArrayList<>();
        Weapons.add(ssword);
        ArrayList<Weapon> Weapons2 = new ArrayList<>();
        Weapons2.add(bbow);
        Inventory inventory = new Inventory(Weapons);
        Inventory inventory2 = new Inventory(Weapons2);
        InteligenceType inteligenceType1 = new Agressive(true);
        InteligenceType inteligenceType2 = new Agressive(true);
        InteligenceType inteligenceType3 = new Agressive(true);
        InteligenceType inteligenceType4 = new Agressive(true);
        Tile start = new Tile(0, 4);
        Tile testobject4Tile = new Tile(0, 3);
        Tile finish = new Tile(15, 15);
        Tile testobject1Tile = new Tile(15, 14);
        Tile g1 = new Tile(7, 7);
        Tile g2 = new Tile(6, 7);
        Tile g3 = new Tile(7, 6);
        Tile g4 = new Tile(7, 8);
        Tile g5 = new Tile(8, 7);
        characters.Character testobject1 = new Knight(2, "Test_1", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType1, true, 20, 5, MAPtable.Map[start.col][start.row]);
        characters.Character testobject2 = new Knight(3, "Test_2", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType2, true, 50, 5, MAPtable.Map[finish.col][finish.row]);
        characters.Character testobject3 = new Knight(4, "Test_3", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory2, inteligenceType3, true, 20, 5, MAPtable.Map[testobject1Tile.col][testobject1Tile.row]);
        characters.Character testobject4 = new Knight(5, "Test_4", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory2, inteligenceType4, true, 20, 5, MAPtable.Map[testobject4Tile.col][testobject4Tile.row]);
        //inteligenceType.setTarget(testobject2);
        MAPtable.placeCharacterOnMap(start);
        MAPtable.placeCharacterOnMap(finish);
        MAPtable.placeCharacterOnMap(testobject1Tile);
        MAPtable.placeCharacterOnMap(testobject4Tile);
/*        map.MAPtable.placeCharacterOnMap(g1);
        map.MAPtable.placeCharacterOnMap(g2);
        map.MAPtable.placeCharacterOnMap(g3);
        map.MAPtable.placeCharacterOnMap(g4);
        map.MAPtable.placeCharacterOnMap(g5);*/
        inteligenceType1.setCharacter(testobject1);
        inteligenceType2.setCharacter(testobject2);
        inteligenceType3.setCharacter(testobject3);
        inteligenceType4.setCharacter(testobject4);
        ArrayList<characters.Character> team = new ArrayList<>();
        team.add(testobject1);
        team.add(testobject4);
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
        testobject4.getIntType().setEnemies(teamB);
        boolean printed = false;
        for (int i = 0; i < 23; i++) {
            if (!teamB.CheckIfTeamIsTeamAlive()) {
                System.out.printf("A team won");
                return;
            }
            if (!teamA.CheckIfTeamIsTeamAlive()) {
                System.out.printf("B team won");
                return;
            }
            for (int col = 0; col < 16; col++) {
                for (int row = 0; row < 16; row++) {
                    printed = false;
                    for (int j = 0; j < teamA.team.size(); j++) {
                        if (MAPtable.Map[col][row] == teamA.team.get(j).getPosition()) {
                            System.out.print("\u001B[41m");
                            System.out.print("A ");
                            printed = true;
                        }
                    }
                    for (int j = 0; j < teamB.team.size(); j++) {
                        if (MAPtable.Map[col][row] == teamB.team.get(j).getPosition()) {
                            System.out.print("\u001B[44m");
                            System.out.print("B ");
                            printed = true;
                        }
                    }
                    if (!printed) {
                        if (MAPtable.Map[col][row].solid) {
                            System.out.print("\u001B[47m");
                            System.out.print("1 ");
                        } else {
                            System.out.print("\u001B[40m");
                            System.out.print("0 ");
                        }
                    }
                    System.out.print(" \u001B[0m");

                }

                System.out.println();

            }
            System.out.println("Test object 1 :" + testobject1.getCurrentHp());
            System.out.println("Test object 2 :" + testobject2.getCurrentHp());
            System.out.println("Test object 3 :" + testobject3.getCurrentHp());
            System.out.println("Test object 4 :" + testobject4.getCurrentHp());

/*            for(int r =0;r<16;r++){
                for(int k=0;k<16;k++){
                    if(map.MAPtable.Map[r][k].occupied==true){
                        System.out.print(map.MAPtable.Map[r][k]+" ");
                    }
                }
            }*/
            System.out.println();
            if (testobject1.checkIfIsAlive())
                testobject1.getIntType().PerformTurn();
            if (testobject2.checkIfIsAlive())
                testobject2.getIntType().PerformTurn();
            if (testobject3.checkIfIsAlive())
                testobject3.getIntType().PerformTurn();
            if (testobject4.checkIfIsAlive())
                testobject4.getIntType().PerformTurn();
    }
        }
    }

