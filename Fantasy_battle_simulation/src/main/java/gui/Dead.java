package gui;

import gui.Entity;
import gui.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Creates and Draws Dead Unit Sprite
 */
public class Dead extends Entity{

    GamePanel gp;

    public Dead(GamePanel gp){
        this.gp = gp;

        getDeadImage();
    }
/**
 * Loads Dead Unit Sprite
 */
    public void getDeadImage(){

        try{
            Dead = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dead_Unit.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/**
 * Draws Dead Unit
 * @param g2
 */
    public void draw(Graphics2D g2){

        BufferedImage image = Dead;

        g2.drawImage(image, x*gp.tileSize, y*gp.tileSize, gp.tileSize, gp.tileSize, null);
    }
}
