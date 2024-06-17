package gui;

import gui.Entity;
import gui.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hero extends Entity {
    
    GamePanel gp;
    //KeyHandler keyH;

    public Hero(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getHeroImage();
    }
    public void setDefaultValues(){
        x = 0;
        y = 0;
        heroType = "Knight_P";
    }
    public void getHeroImage(){

        try{

            Knight_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Knight_P.png"));
            Knight_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Knight_Y.png"));
            Paladin_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Paladin_P.png"));
            Paladin_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Paladin_Y.png"));
            Archer_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Archer_P.png"));
            Archer_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Archer_Y.png"));
            Marksman_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Marksman_P.png"));
            Marksman_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Marksman_Y.png"));
            Archmage_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Archmage_P.png"));
            Archmage_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Archmage_Y.png"));
            Druid_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Druid_P.png"));
            Druid_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Druid_Y.png"));
            Assasin_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Assasin_P.png"));
            Assasin_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Assasin_Y.png"));
            Thief_P = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Thief_P.png"));
            Thief_Y = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Thief_Y.png"));
            Dead = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dead_Unit.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (heroType) {
            case "Knight_P":
                image = Knight_P;
                break;
            case "Knight_Y":
                image = Knight_Y;
                break;
            case "Paladin_P":
                image = Paladin_P;
                break;
            case "Paladin_Y":
                image = Paladin_Y;
                break;    
            case "Archer_P":
                image = Archer_P;
                break;
            case "Archer_Y":
                image = Archer_Y;
                break;
            case "Marksman_P":
                image = Marksman_P;
                break;
            case "Marksman_Y":
                image = Marksman_Y;
                break;
            case "Archmage_P":
                image = Archmage_P;
                break;
            case "Archmage_Y":
                image = Archmage_Y;
                break;
            case "Druid_P":
                image = Druid_P;
                break;
            case "Druid_Y":
                image = Druid_Y;
                break;
            case "Assasin_P":
                image = Assasin_P;
                break;
            case "Assasin_Y":
                image = Assasin_Y;
                break;
            case "Thief_P":
                image = Thief_P;
                break;
            case "Thief_Y":
                image = Thief_Y;
                break;
            case "Dead":
                image = Dead;
                break;
        }
        g2.drawImage(image, x*gp.tileSize, y*gp.tileSize, gp.tileSize, gp.tileSize, null);
    }
    public void updatePositon(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void updateType(String name){
        this.heroType = name;
    }
}
