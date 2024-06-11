import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hero extends Entity{
    
    GamePanel gp;

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

            Knight_P = ImageIO.read(getClass().getResourceAsStream("Knight_P.png"));
            Knight_Y = ImageIO.read(getClass().getResourceAsStream("Knight_Y.png"));
            Archer_P = ImageIO.read(getClass().getResourceAsStream("Archer_P.png"));
            Archer_Y = ImageIO.read(getClass().getResourceAsStream("Archer_Y.png"));
            Archmage_P = ImageIO.read(getClass().getResourceAsStream("Archmage_P.png"));
            Archmage_Y = ImageIO.read(getClass().getResourceAsStream("Archmage_Y.png"));
            Assasin_P = ImageIO.read(getClass().getResourceAsStream("Assasin_P.png"));
            Assasin_Y = ImageIO.read(getClass().getResourceAsStream("Assasin_Y.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //tu x i y zmieniać

    }
    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (heroType) {
            case "Knight_P":
                image = Knight_P;
                break;
            case "Knight_Y":
                image = Knight_Y;
                break;
            case "Archer_P":
                image = Archer_P;
                break;
            case "Archer_Y":
                image = Archer_Y;
                break;
            case "Archmage_P":
                image = Archmage_P;
                break;
            case "Archmage_Y":
                image = Archmage_Y;
                break;
            case "Assasin_P":
                image = Assasin_P;
                break;
            case "Assasin_Y":
                image = Assasin_Y;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
