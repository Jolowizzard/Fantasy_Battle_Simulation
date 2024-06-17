package gui;

import java.awt.image.BufferedImage;

public class Entity{

    public int x, y;

    public BufferedImage Knight_P, Knight_Y, Paladin_P, Paladin_Y, Archer_P, Archer_Y, Marksman_P, Marksman_Y, Archmage_P, Archmage_Y, Druid_P, Druid_Y, Assasin_P, Assasin_Y, Thief_P, Thief_Y;
    public String heroType;

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }
    public String getHeroType(){
        return heroType;
    }
    public void setHeroColor(String color){
        heroType = heroType + "_" + color;
    }
    public void setX(int x){
        this.x =x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}