import simulationsetup.CharacterCreator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
CharacterCreator characterCreator = new CharacterCreator();
    GamePanel gp;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

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
                    gp.ui.commandNum = 0;
                    gp.ui.titleScreenState = 1; // Character class selection screen
                    //gp.gameState = gp.playState; // Play game
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        //SECOND SCREEN  CHOOSE START TYPE
        else if(gp.ui.titleScreenState == 1){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                //BUILD TEAM
                if(gp.ui.commandNum == 0){
                    gp.ui.commandNum = 0;
                    gp.ui.commandCount = 0;
                    gp.ui.commandCol = 0;
                    gp.ui.commandRow = 0;
                    gp.ui.titleScreenState = 2;
                }
                //READ FILE
                if(gp.ui.commandNum == 1){
                    //tu trzba funkcję czytaj z pliku
                    gp.gameState = gp.playState;
                }
                //BACK
                if(gp.ui.commandNum == 2){
                    gp.ui.commandNum = 0;
                    gp.ui.titleScreenState = 0;
                }
            }
        }
        //THIRD SCREEN  CHARACTER SELECTION
        else if(gp.ui.titleScreenState == 2){
            if(code == KeyEvent.VK_W){
                gp.ui.commandRow--;
                if(gp.ui.commandRow < 0 && gp.ui.commandCol == 0){
                    gp.ui.commandRow = 7;
                }
                else if(gp.ui.commandRow < 0 && gp.ui.commandCol == 1){
                    gp.ui.commandRow = 5;
                }
                else if(gp.ui.commandRow < 0 && gp.ui.commandCol == 2){
                    gp.ui.commandRow = 2;
                }
                else if(gp.ui.commandRow < 0 && gp.ui.commandCol == 3){
                    gp.ui.commandRow = 1;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandRow++;
                if(gp.ui.commandRow > 7 && gp.ui.commandCol == 0){
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandRow > 5 && gp.ui.commandCol == 1){
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandRow > 2 && gp.ui.commandCol == 2){
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandRow > 1 && gp.ui.commandCol == 3){
                    gp.ui.commandRow = 0;
                }
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.commandCol == 0 && gp.ui.commandRow == 7){
                    gp.ui.commandCol--;
                    gp.ui.commandRow = 1;
                }
                else if(gp.ui.commandCol == 0){
                    gp.ui.commandCol--;
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandCol == 3){
                    gp.ui.commandCol--;
                    gp.ui.commandRow = 2;
                }
                else 
                    gp.ui.commandCol--;
                if(gp.ui.commandCol < 0){
                    gp.ui.commandCol = 3;
                }
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.commandCol == 0 && gp.ui.commandRow > 5){
                    gp.ui.commandCol++;
                    gp.ui.commandRow = 5;
                }
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow > 2){
                    gp.ui.commandCol++;
                    gp.ui.commandRow = 2;
                }
                else if(gp.ui.commandCol == 2){
                    gp.ui.commandCol++;
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandCol == 3){
                    gp.ui.commandCol++;
                    gp.ui.commandRow += 6;
                }
                else 
                    gp.ui.commandCol++;
                if(gp.ui.commandCol > 3){
                    gp.ui.commandCol = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                //Knight
                if(gp.ui.commandCol == 0 && gp.ui.commandRow == 0){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setKnight(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Paladin
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 1){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setPaladin(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Archer
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 2){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setRanger(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Marksman
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 3){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setMarksman(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Archmage
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 4){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setWizard(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Druid
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 5){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setDruid(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Assasin
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 6){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setAssassin(true);
                    //zaznacz
                    //odznacz pozostałe
                }
                //Thieft
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 7){
                   characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setThief(true);
                    //zaznacz
                    //odznacz pozostałe
                }

                //Fists
                if(gp.ui.commandCol == 1 && gp.ui.commandRow == 0){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że fists
                    //zaznacz
                    //odznacz pozostałe
                }
                //Sword
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 1){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że sword
                    //zaznacz
                    //odznacz pozostałe
                }
                //Sword+Shield
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 2){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że sword+shield
                    //zaznacz
                    //odznacz pozostałe
                }
                //Bow
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 3){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że bow
                    //zaznacz
                    //odznacz pozostałe
                }
                //Staff
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 4){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że staff
                    //zaznacz
                    //odznacz pozostałe
                }
                //Daggers
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 5){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że daggers
                    //zaznacz
                    //odznacz pozostałe
                }

                //Light Armor
                if(gp.ui.commandCol == 2 && gp.ui.commandRow == 0){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że light
                    //zaznacz
                    //odznacz pozostałe
                }
                //Medium armor
                else if(gp.ui.commandCol == 2 && gp.ui.commandRow == 1){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że medium
                    //zaznacz
                    //odznacz pozostałe
                }
                //Heavy armor
                else if(gp.ui.commandCol == 2 && gp.ui.commandRow == 2){
                    //usuń poprzedni wybór jeśli był
                    //zapisz że heavy
                    //zaznacz
                    //odznacz pozostałe
                }

                //Next
                if(gp.ui.commandCol == 3 && gp.ui.commandRow == 0){
                    //sprawdź czy żołnież gotowy?
                    if(gp.ui.commandCount == 3 && gp.ui.commandNum == 1){
                        gp.gameState = gp.playState;
                    }
                    else if(gp.ui.commandCount == 3 && gp.ui.commandNum == 0){
                        gp.ui.commandCount = 0;
                        gp.ui.commandNum++;
                    }
                    else{
                        gp.ui.commandCount++;
                    } 
                }
                //Skip
                else if(gp.ui.commandCol == 3 && gp.ui.commandRow == 1){
                    //sprawdź czy żołnież gotowy?
                    if(gp.ui.commandCount > 0 && gp.ui.commandNum == 1){
                        gp.gameState = gp.playState;
                    }
                    else if(gp.ui.commandCount > 0 && gp.ui.commandNum == 0){
                        gp.ui.commandNum++;
                    }
                }
            }
        }
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