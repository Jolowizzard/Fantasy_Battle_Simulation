import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    public int commandNum = 0;
    public int commandRow = 0;
    public int commandCount = 0;
    public int commandCol = 0;
    public int col0 = 0;
    public int col1 = 0;
    public int col2 = 0;
    public int col3 = 0;
    public int titleScreenState = 0; // 0 : Main Menu, 1 : the second screen, 2 : character screen
    BufferedImage csp, csy, sel, selected;

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Castellar", Font.PLAIN, 40);

        try{
            csp = ImageIO.read(getClass().getResourceAsStream("Character screen P.png"));
            csy = ImageIO.read(getClass().getResourceAsStream("Character screen Y.png"));
            sel = ImageIO.read(getClass().getResourceAsStream("Select.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        //Title State
        if(gp.gameState == gp.titleState){
            if(titleScreenState == 2){
                drawCharacterScreen();
            }
            else if(titleScreenState == 1){
                drawStartScreen();
            }
            else
                drawTitleScreen();
        }

        //Play State
        if(gp.gameState == gp.playState){

        }

        //Psuse State
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

    }
    public void drawPauseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,100F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.ScreenHeight/2;
        g2.drawString(text,x,y);

    }
    public int getXforCenteredText(String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.ScreenWidth/2 - lenght/2;
        return x;
    }
    public void drawTitleScreen(){
        
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.ScreenWidth, gp.ScreenHeight);

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        String text = "Fantasy Battle Simulator";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*4;

        //Shadow
        g2.setColor(new Color(107, 0, 0));
        g2.drawString(text, x+4, y+4);
        //Main Text
        g2.setColor(new Color(254, 32, 32));
        g2.drawString(text, x, y);
        //Knight
        x = gp.ScreenWidth/2 - (gp.tileSize*4)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.hero.Knight_P, x, y, gp.tileSize*4, gp.tileSize*4, null);
        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));

        text = "NEW SIMULATION";
        x = getXforCenteredText(text);
        y += gp.tileSize*6;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
    }
    public void drawStartScreen(){
        
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.ScreenWidth, gp.ScreenHeight);

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        String text = "Choose Type Of Simulation";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*4;

        //Shadow
        g2.setColor(new Color(107, 0, 0));
        g2.drawString(text, x+4, y+4);
        //Main Text
        g2.setColor(new Color(254, 32, 32));
        g2.drawString(text, x, y);
        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));

        text = "BUILD YOUR TEAM";
        x = getXforCenteredText(text);
        y += gp.tileSize*6;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "READ TEAM FROM FILE";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "BACK";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }
    }
    public void drawCharacterScreen(){
        
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.ScreenWidth, gp.ScreenHeight);

        if(commandNum == 0){
            g2.drawImage(csp, 0, 0, gp.tileSize*16, gp.tileSize*16, null);
        }
        else{
            g2.drawImage(csy, 0, 0, gp.tileSize*16, gp.tileSize*16, null);
        }
        

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,35F));
        String text;
        String text2;
        if(commandNum == 0){
            text = "Purple Team";
            text2 = "Hero " + Integer.toString(commandCount+1);
        }
        else{
            text = "Yellow Team" + Integer.toString(commandCount+1);
            text2 = "Hero " + Integer.toString(commandCount+1);
        }
        int x = gp.tileSize*9;
        int y = gp.tileSize*1;

        //Shadow
        if(commandNum == 0){
            g2.setColor(new Color(119, 0, 200));
        }
        else{
            g2.setColor(new Color(255, 174, 66));
        }
        g2.drawString(text, x+3, y+3);
        g2.drawString(text2, x+3, gp.tileSize+y+3);
        //Main Text
        if(commandNum == 0){
            g2.setColor(new Color(174, 55, 255));
        }
        else{
            g2.setColor(new Color(255, 255, 0));
        }
        g2.drawString(text, x, y);
        g2.drawString(text2, x+3, gp.tileSize+y);
        
        //Menu

        //Selected
        if(gp.ui.col0 != 0){
            drawSelected(0, gp.ui.col0);
        }
        if(gp.ui.col1 != 0){
            drawSelected(0, gp.ui.col1);
        }
        if(gp.ui.col2 != 0){
            drawSelected(0, gp.ui.col2);
        }
        if(gp.ui.col3 != 0){
            drawSelected(0, gp.ui.col3);
        }

        //COLUMN 1
        //knight
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 0){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //paladin
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 1){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //archer
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 2){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //marskman
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 3){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //archmage
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 4){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //druid
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 5){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //assasin
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 6){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //thief
        if(gp.ui.commandCol == 0 && gp.ui.commandRow == 7){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }

        //COLUMN 2
        //Fists
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 0){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //Sword + Shield
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 1){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //Sword
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 2){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //Bow
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 3){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //Staff
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 4){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //Daggers
        if(gp.ui.commandCol == 1 && gp.ui.commandRow == 5){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }

        //COLUMN 3
        //light
        if(gp.ui.commandCol == 2 && gp.ui.commandRow == 0){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //medium
        if(gp.ui.commandCol == 2 && gp.ui.commandRow == 1){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //heavy
        if(gp.ui.commandCol == 2 && gp.ui.commandRow == 2){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }

        //COLUMN 4
        //1
        if(gp.ui.commandCol == 3 && gp.ui.commandRow == 0){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //2
        if(gp.ui.commandCol == 3 && gp.ui.commandRow == 1){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }
        //3
        if(gp.ui.commandCol == 3 && gp.ui.commandRow == 2){
            drawSelect(gp.ui.commandCol, gp.ui.commandRow);
        }

        //COLUMN 5
        //next
        if(gp.ui.commandCol == 4 && gp.ui.commandRow == 0){
            drawSelect(7, 6);
        }
        //skip
        if(gp.ui.commandCol == 4 && gp.ui.commandRow == 1){
            drawSelect(7, 7);
        }
    }
    public void drawSelect(int x, int y){
        g2.drawImage(sel, x*gp.tileSize*2, y*gp.tileSize*2, gp.tileSize*2, gp.tileSize*2, null);
    }
    public void drawSelected(int x, int y){
        g2.drawImage(selected, x*gp.tileSize*2, y*gp.tileSize*2, gp.tileSize*2, gp.tileSize*2, null);
    }
}
