package simulation;

import armours.Armour;
import armours.LightArmour;
import characters.rogue.Thief;
import characters.shooter.Marksman;
import characters.warriors.Knight;
import gamestructure.Team;
import gui.GamePanel;
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

import java.awt.*;
import java.util.ArrayList;
public class Simulation implements Runnable{
    private Team teamYellow;
    private Team teamPurple;
    private GamePanel gamePanel;
    public static Graphics2D g2;
    private boolean oneTeamWon;
    public Simulation(GamePanel gamePanel,String mapName,Team teamYellow,Team teamPurple){
        this.gamePanel=gamePanel;
        MAPtable.InitializeMap(mapName);
        this.teamYellow = teamYellow;
        this.teamPurple = teamPurple;

    }
    @Override
    public void run(){
        try {
            try {
                Scribe scribe = new Scribe("Log1.txt");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            int simulationTime = 0;
            ArrayList<characters.Character> stack = new ArrayList<>();

            //checking which team is the biggest
            int BiggestTeamSize = teamYellow.getTeam().size();
            if (teamYellow.getTeam().size() < teamPurple.getTeam().size()) {
                BiggestTeamSize = teamPurple.getTeam().size();
            }
            for (int col = 0; col < 16; col++) {
                for (int row = 0; row < 16; row++) {
                    if (MAPtable.Map[col][row].solid) {
                        System.out.print("\u001B[47m");
                        System.out.print("1 ");
                    } else {
                        System.out.print("\u001B[40m");
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
            //preparing stack order . This order is permanent for the rest of the simulation and can not be changed
            for (int i = 0; i < BiggestTeamSize; i++) {
                if (i < teamPurple.getTeam().size()) {
                    stack.add(teamPurple.getTeam().get(i));
                    //Final steps in preparing intelligence
                    teamPurple.getTeam().get(i).getIntType().setEnemies(teamYellow);
                    teamPurple.getTeam().get(i).getIntType().setAllays(teamPurple);
                }
                if (i < teamYellow.getTeam().size()) {
                    stack.add(teamYellow.getTeam().get(i));
                    teamYellow.getTeam().get(i).getIntType().setEnemies(teamPurple);
                    teamYellow.getTeam().get(i).getIntType().setAllays(teamYellow);
                }
            }
            //Some simulation setup
            double drawInterval = 1000000000/60; //FPS
            double delta = 0;
            long lastTime = 0;
            long currentTime;
            long timer = 0;

            //Setting up inventory
            stack.forEach(character -> character.getIntType().inventorySetup());

            //placing characters on map
            stack.forEach(character -> MAPtable.placeCharacterOnMap(character.getPosition()));
            while (!oneTeamWon) {
                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if(delta >= 1){
                    delta--;
                }
                //Performing turns
                Thread.sleep(1000);
                for (int i = 0; i < stack.size(); i++) {
                    Scribe.addLog(stack.get(i).getName() + " performs turn");
                    Thread.sleep(500);
                    stack.get(i).getIntType().PerformTurn();
                    Scribe.addLog(".......");
                    Thread.sleep(500);
                    System.out.println(stack.get(i).getCurrentHp());
                }
                //VictoryCheck
                if (!teamYellow.CheckIfTeamIsTeamAlive()) {
                    Scribe.addLog("Team Yellow wins");
                    setOneTeamWon(true);
                    gamePanel.stopGamePanel();
                    //System.out.printf("Team A won");
                }
                if (!teamPurple.CheckIfTeamIsTeamAlive()) {
                    setOneTeamWon(true);
                    Scribe.addLog("Team Purple wins");
                    gamePanel.stopGamePanel();
                    //System.out.printf("Team B won");
                }
                simulationTime++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean checkIfSimulationEnded(){return oneTeamWon;}
    private void setOneTeamWon(boolean value){oneTeamWon = value;}
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
            Team teamA = new Team();
            teamA.addCharacter(testobject1);
            teamA.addCharacter(testobject4);

            Team teamB = new Team();
            teamB.addCharacter(testobject2);
            teamB.addCharacter(testobject3);

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
                System.out.println("Test object 1 :" + testobject1.getCurrentHp() + " Position " + testobject1.getPosition().col + " : " + testobject1.getPosition().row);
                System.out.println("Test object 2 :" + testobject2.getCurrentHp()+ " Position " + testobject2.getPosition().col + " : " + testobject2.getPosition().row);
                System.out.println("Test object 3 :" + testobject3.getCurrentHp()+ " Position " + testobject3.getPosition().col + " : " + testobject3.getPosition().row);
                System.out.println("Test object 4 :" + testobject4.getCurrentHp()+ " Position " + testobject4.getPosition().col + " : " + testobject4.getPosition().row);

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
                System.out.println("Health after combat");
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

