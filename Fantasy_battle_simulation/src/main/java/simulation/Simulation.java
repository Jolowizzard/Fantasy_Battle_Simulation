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

/**
 * Class of a simulation
 * Simple structure of game flow
 * Firstly characters are added to a stack which represents order of characters performing turns.
 * Thane intelligences can prepare inventories and set enemies and friends
 * Simulation begins and characters perform turns
 * Simulation last until all characters from one team have been eliminated
 * During simulation Scribe writes all ivents in .txt file
 * As an output we can read how well characters have fought (Types of damage dealt and taken)
 */
public class Simulation implements Runnable{
    private Team teamYellow;
    private Team teamPurple;
    private GamePanel gamePanel;
    public static Graphics2D g2;
    private boolean oneTeamWon;

    /**
     * Constructor of simulation class
     * @param gamePanel
     * @param mapName
     * @param teamYellow
     * @param teamPurple
     */
    public Simulation(GamePanel gamePanel,String mapName,Team teamYellow,Team teamPurple){
        this.gamePanel=gamePanel;
        MAPtable.InitializeMap(mapName);
        this.teamYellow = teamYellow;
        this.teamPurple = teamPurple;

    }

    /**
     * Method runs a simulation
     */
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
                    teamPurple.getTeam().get(i).getIntType().setGamePanel(gamePanel);
                }
                if (i < teamYellow.getTeam().size()) {
                    stack.add(teamYellow.getTeam().get(i));
                    teamYellow.getTeam().get(i).getIntType().setEnemies(teamPurple);
                    teamYellow.getTeam().get(i).getIntType().setAllays(teamYellow);
                    teamYellow.getTeam().get(i).getIntType().setGamePanel(gamePanel);
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
                    gamePanel.logEvent(". . . . . . .");
                    Scribe.addLog(".......");
                    Thread.sleep(500);
                    System.out.println(stack.get(i).getCurrentHp());
                }
                //VictoryCheck
                if (!teamYellow.CheckIfTeamIsTeamAlive()) {
                    Scribe.addLog("Team Purple wins");
                    setOneTeamWon(true);
                    gamePanel.logEvent("Team Purple wins");
                    gamePanel.stopGamePanel();
                    //System.out.printf("Team A won");
                }
                if (!teamPurple.CheckIfTeamIsTeamAlive()) {
                    setOneTeamWon(true);
                    Scribe.addLog("Team Yellow wins");
                    gamePanel.logEvent("Team Yellow wins");
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
    }

