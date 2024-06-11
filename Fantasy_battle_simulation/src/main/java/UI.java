import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Castellar", Font.PLAIN, 40);
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        

        //Title State
        if(gp.gameState == gp.titleState){
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

    }
    public int  getXforCenteredText(String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.ScreenWidth/2 - lenght/2;
        return x;
    }
    public void drawTitleScreen(){
        
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.ScreenWidth, gp.ScreenHeight);

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,55F));
        String text = "Fantasy Battle Simulator";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*4;

        //Shadow
        g2.setColor(new Color(107, 0, 0));
        g2.drawString(text, x+5, y+5);
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
}
