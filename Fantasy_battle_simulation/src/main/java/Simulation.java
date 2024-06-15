import armours.Armour;
import armours.LightArmour;
import characters.rogue.Thief;
import characters.shooter.Marksman;
import characters.warriors.Knight;
import gamestructure.Team;
import inteligence.Agressive;
import inteligence.InteligenceType;
import inventory.Inventory;
import inventory.items.HealPotion;
import inventory.items.Item;
import map.MAPtable;
import map.Tile;
import simulationsetup.Scribe;
import weapons.Bow;
import weapons.Dagger;
import weapons.Sword;
import weapons.Weapon;

import java.util.ArrayList;

public class Simulation {
    private Team teamYellow;
    private Team teamPurple;
    public Simulation(String mapName,Team teamYellow,Team teamPurple){
        MAPtable.InitializeMap("mapName");
        this.teamYellow = teamYellow;
        this.teamPurple = teamPurple;

    }
    public void simulate(){
        boolean oneTeamWon = false;
        int simulationTime = 0;
        ArrayList<characters.Character> stack = new ArrayList<>();
        //checking which team is the biggest
        int BiggestTeamSize = teamYellow.getTeam().size();
        if(teamYellow.getTeam().size()<teamPurple.getTeam().size()){
            BiggestTeamSize = teamPurple.getTeam().size();
        }
        //preparing stack order . This order is permanent for the rest of the simulation and can not be changed
        for(int i = 0 ; i<BiggestTeamSize;i++)
        {
            if(i<teamPurple.getTeam().size())
                stack.add(teamPurple.getTeam().get(i));
            if(i<teamYellow.getTeam().size())
                stack.add(teamYellow.getTeam().get(i));
        }
        while( !oneTeamWon || simulationTime < 100){
            //Performing turns
            for(int i = 0; i < stack.size(); i++) {
                stack.get(i).getIntType().PerformTurn();
            }
            //VictoryCheck
            if (!teamYellow.CheckIfTeamIsTeamAlive()){
                oneTeamWon = true;
                System.out.printf("Team A won");
            }
            if (!teamPurple.CheckIfTeamIsTeamAlive()) {
                oneTeamWon = true;
                System.out.printf("Team B won");
            }
            simulationTime++;
        }
    }
    public static void main(String [] args ) {
        try {
            Scribe scribe = new Scribe("Log1.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }
            MAPtable.InitializeMap("map_3.txt");
            Weapon ssword = new Sword("weapons.Sword", 10, 0, 1, 100, false, false);
            Weapon bbow = new Bow("weapons.Bow", 10, 0, 6, 100, true, false);
            Weapon dagger = new Dagger();
            Armour lightArmour = new LightArmour();
            ArrayList<Weapon> Weapons = new ArrayList<>();
            Weapons.add(dagger);
            ArrayList<Weapon> Weapons2 = new ArrayList<>();
            Weapons2.add(bbow);
            ArrayList<Armour> armours = new ArrayList<>();
            armours.add(lightArmour);
            Item healPotion1 = new HealPotion("HealPotion");
            Item healPotion2 = new HealPotion("HealPotion");
            Item healPotion3 = new HealPotion("HealPotion");
            Item healPotion4 = new HealPotion("HealPotion");
            Inventory inventory = new Inventory(Weapons, armours);
            Inventory inventory2 = new Inventory(Weapons2, armours);
            InteligenceType inteligenceType1 = new Agressive(true);
            InteligenceType inteligenceType2 = new Agressive(true);
            InteligenceType inteligenceType3 = new Agressive(true);
            InteligenceType inteligenceType4 = new Agressive(true);
            inventory.addItem(healPotion1);
            inventory.addItem(healPotion2);
            inventory2.addItem(healPotion3);
            inventory2.addItem(healPotion4);
            Tile start = new Tile(0, 0);
            Tile testobject4Tile = new Tile(0, 1);
            Tile finish = new Tile(15, 15);
            Tile testobject1Tile = new Tile(15, 14);
            Tile g1 = new Tile(7, 7);
            Tile g2 = new Tile(6, 7);
            Tile g3 = new Tile(7, 6);
            Tile g4 = new Tile(7, 8);
            Tile g5 = new Tile(8, 7);
            characters.Character testobject1 = new Knight(2, "Test_1", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory, inteligenceType1, true, 20, 5, MAPtable.Map[start.col][start.row]);
            characters.Character testobject2 = new Thief(3, "Test_2", "Human", 100, 100, 50, 1, 1, 3, (float) 50.00, inventory, inteligenceType2, true, true, MAPtable.Map[finish.col][finish.row]);
            characters.Character testobject3 = new Knight(4, "Test_3", "Human", 100, 100, 1, 1, 1, 3, (float) 5.00, inventory2, inteligenceType3, true, 20, 5, MAPtable.Map[testobject1Tile.col][testobject1Tile.row]);
            characters.Character testobject4 = new Marksman(4, "Tobi", inteligenceType4, MAPtable.Map[testobject4Tile.col][testobject4Tile.row], inventory2);
            //inteligenceType.setTarget(testobject2);
            MAPtable.placeCharacterOnMap(start);
            MAPtable.placeCharacterOnMap(finish);
            MAPtable.placeCharacterOnMap(testobject1Tile);
            MAPtable.placeCharacterOnMap(testobject4Tile);
/*      map.MAPtable.placeCharacterOnMap(g1);
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
            System.out.println(teamA.getTeam());
            System.out.println(teamB.getTeam());
            testobject2.getIntType().setEnemies(teamA);
            testobject3.getIntType().setEnemies(teamA);
            testobject1.getIntType().setEnemies(teamB);
            testobject4.getIntType().setEnemies(teamB);

            testobject2.getIntType().setAllays(teamB);
            testobject3.getIntType().setAllays(teamB);
            testobject1.getIntType().setAllays(teamA);
            testobject4.getIntType().setAllays(teamA);

            testobject1.getIntType().inventorySetup();
            testobject2.getIntType().inventorySetup();
            testobject3.getIntType().inventorySetup();
            testobject4.getIntType().inventorySetup();
            boolean printed = false;
            for (int i = 0; i < 23; i++) {
                for (int col = 0; col < 16; col++) {
                    for (int row = 0; row < 16; row++) {
                        printed = false;
                        for (int j = 0; j < teamA.getTeam().size(); j++) {
                            if (MAPtable.Map[col][row] == teamA.getTeam().get(j).getPosition()) {
                                System.out.print("\u001B[41m");
                                System.out.print("A ");
                                printed = true;
                            }
                        }
                        for (int j = 0; j < teamB.getTeam().size(); j++) {
                            if (MAPtable.Map[col][row] == teamB.getTeam().get(j).getPosition()) {
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
                if (!teamB.CheckIfTeamIsTeamAlive()) {
                    System.out.printf("Team A won");
                    break;
                }
                if (!teamA.CheckIfTeamIsTeamAlive()) {
                    System.out.printf("Team B won");
                    break;
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
                System.out.println("Heath after combat");
                System.out.println("Test object 1 :" + testobject1.getCurrentHp());
                System.out.println("Test object 2 :" + testobject2.getCurrentHp());
                System.out.println("Test object 3 :" + testobject3.getCurrentHp());
                System.out.println("Test object 4 :" + testobject4.getCurrentHp());
            }
            System.out.println(testobject1.getName() + " : " + testobject1.getDamageTypesDealt());
            System.out.println(testobject1.getName() + " : " + testobject1.getDamageTypesBlocked());
            System.out.println(testobject1.getName() + " : " + testobject1.getDamageTaken());

    }
    }

