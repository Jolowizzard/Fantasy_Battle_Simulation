package gui;

import java.awt.image.BufferedImage;

/**
 * Helps with Units drawing Generation 
 */
public class Entity{

    public int x, y;

    public BufferedImage Knight_P, Knight_Y, Paladin_P, Paladin_Y, Archer_P, Archer_Y, Marksman_P, Marksman_Y, Archmage_P, Archmage_Y, Druid_P, Druid_Y, Assasin_P, Assasin_Y, Thief_P, Thief_Y, Dead;
    public String heroType;

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }
/**
 * Choosing Hero Type
 * @return
 */
    public String getHeroType(){
        return heroType;
    }
/**
 * Sets Hero Color Depending on Team
 * @param color
 */
    public void setHeroColor(String color){
        heroType = heroType + "_" + color;
    }
/**
 * Sets x Value
 * @param x
 */
    public void setX(int x){
        this.x = x;
    }
/**
 * Sets y Value
 * @param y
 */
    public void setY(int y){
        this.y = y;
    }
/**
 * Sets x and y Value
 * @param x
 * @param y
 */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}