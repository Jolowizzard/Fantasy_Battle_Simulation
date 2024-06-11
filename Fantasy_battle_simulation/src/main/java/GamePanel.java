import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // Ustawienia kranu
    final int originalTileSize = 16;
    final int scale = 4;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int ScreenWidth = tileSize * maxScreenCol;
    public final int ScreenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 30;

    //System
    KeyHandler kayH = new KeyHandler(this);
    TileManager tileM = new TileManager(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    //Entity
    Hero hero = new Hero(this);

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;


    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);;
        this.setDoubleBuffered(true);
    }

    public void setupGame(){

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

        while(gameThread != null){

            //Czy działa
            // System.out.println("Gra wlaczana");

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

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
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

            //UI
            ui.draw(g2);

        }
        
        g2.dispose();
    }
}
