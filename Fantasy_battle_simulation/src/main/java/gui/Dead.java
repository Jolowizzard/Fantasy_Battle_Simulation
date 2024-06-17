package gui;

import gui.Entity;
import gui.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dead extends Entity{

    GamePanel gp;

    public Dead(GamePanel gp){
        this.gp = gp;

        getDeadImage();
    }
    public void getDeadImage(){

        try{
            Dead = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dead_Unit.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = Dead;

        g2.drawImage(image, x*gp.tileSize, y*gp.tileSize, gp.tileSize, gp.tileSize, null);
    }
    public void updatePositon(int x, int y){
        this.x = x;
        this.y = y;
    }
}
