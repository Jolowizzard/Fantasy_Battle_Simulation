package gui;

import map.MAPtable;
import simulation.Simulation;
import simulationsetup.TeamCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // Ustawienia kranu
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int ScreenWidth = tileSize * maxScreenCol;
    public final int ScreenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    //System
    KeyHandler keyH = new KeyHandler(this);
    TileManager tileM = new TileManager(this);
    public UI ui = new UI(this);
    //Sound music = new Sound(); // Created 2 different objects for Sound Effect and Music. If you use 1 object SE or Music stops sometimes.
    //Sound se = new Sound();
    Thread gameThread;

    
    //gui.Entity
    Hero hero = new Hero(this, keyH);

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;

    int mapNumber = 1;
    String mapName = "map_1.txt";


    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);;
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){

        /*playMusic(0);   // 0 = BlueBoyAdventure.wav
        stopMusic();*/
        gameState = titleState;

    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //FPS
        double delta = 0;
        long lastTime = 0;
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null && gameState != playState){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(gameState == playState)
                break;
            /*FPS 
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }*/
        }
        Simulation simulation = new Simulation(this, MAPtable.mapName, TeamCreator.teamYellow,TeamCreator.teamPurple);
        simulation.run();
        System.out.println("Out of while");
    }
    public void update(){

        if(gameState == playState){
            hero.update();
        }
        if(gameState == pauseState){
            //nothing
        }

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Title Screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        else{
            //Tile
            tileM.draw(g2);
        
            //Heroes
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);
            hero.draw(g2);

            //gui.UI
            ui.draw(g2);

            g2.dispose();
        }
    }
}
