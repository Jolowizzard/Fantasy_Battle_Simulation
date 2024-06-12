import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    GamePanel gp;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        System.out.println("Pressed " + code);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            titleState(code);
        }
        //PLAY STATE
        else if(gp.gameState == gp.playState){
            playState(code);
        }
        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            pauseState(code);
        }
        /*GAMEOVER STATE
        else if(gp.gameState == gp.gameOverState){
            gameOverState(code);
        }*/
    
    }
    public void titleState(int code)
    {
        //MAIN MENU
        if(gp.ui.titleScreenState == 0){
            if(code == KeyEvent.VK_W){
                System.out.println("Wciśnięto W");
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 1;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 1){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    //gp.ui.titleScreenState = 1; // Character class selection screen
                    gp.gameState = gp.playState; // Play game
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        /*//SECOND SCREEN  CHARACTER SELECTION
        else if (gp.ui.titleScreenState == 1) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                //FIGHTER
                if (gp.ui.commandNum == 0) {
                    System.out.println("Do some fighter specific stuff!");
                    gp.gameState = gp.playState;
                    //gp.playMusic(0);
                }
                //THIEF
                if (gp.ui.commandNum == 1) {
                    System.out.println("Do some thief specific stuff!");
                    gp.gameState = gp.playState;
                    //gp.playMusic(0);
                }
                //SORCERER
                if (gp.ui.commandNum == 2) {
                    System.out.println("Do some sorcerer specific stuff!");
                    gp.gameState = gp.playState;
                    //gp.playMusic(0);
                }
                //BACK
                if (gp.ui.commandNum == 3) {
                    gp.ui.titleScreenState = 0;
                }
            }
        }*/
    }
    public void playState(int code)
    {
        if(code == KeyEvent.VK_P){
            gp.gameState = gp.pauseState;
        }
    }
    public void pauseState(int code)
    {
        if(code == KeyEvent.VK_P){
            gp.gameState = gp.playState;
        }
    }

    /*public void gameOverState(int code){
        if(code == KeyEvent.VK_W)
        {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0)
            {
                gp.ui.commandNum = 1;
            }
            //gp.playSE(9);
        }
        if(code == KeyEvent.VK_S)
        {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1)
            {
                gp.ui.commandNum = 0;
            }
            //gp.playSE(9);
        }
        if(code == KeyEvent.VK_ENTER)
        {
            if(gp.ui.commandNum == 0) //RETRY, reset position, life, mana, monsters, npcs...
            {
                gp.gameState = gp.playState;
                //gp.playMusic(0);
            }
            else if(gp.ui.commandNum == 1) //QUIT, reset everything
            {
                gp.ui.titleScreenState = 0;
                gp.gameState = gp.titleState;
            }
        }
    }*/

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}
}