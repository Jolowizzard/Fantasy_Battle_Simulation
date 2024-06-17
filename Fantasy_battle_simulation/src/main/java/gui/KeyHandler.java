package gui;
import map.MAPtable;
import map.Tile;


import gui.GamePanel;
import simulationsetup.CharacterCreator;
import simulationsetup.InventoryCreator;
import simulationsetup.TeamCreator;
import utils.FileChooserUtil;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
CharacterCreator characterCreator = new CharacterCreator();
InventoryCreator inventoryCreator = new InventoryCreator();
TeamCreator teamCreator = new TeamCreator();
int SavedPositions = 0;

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
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_D){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 1;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_A){
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
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_D){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_A){
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
                    String filepath = FileChooserUtil.selectFilePath();
                    if(filepath!= null) {
                        TeamCreator teamCreator = new TeamCreator();
                        teamCreator.CreateTeamsFromFile(filepath,gp);
                        //Tworzenie postaci do symulacji
                        gp.gameState = gp.playState;
                    }

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
                    gp.ui.commandRow = 2;
                }
                else if(gp.ui.commandRow < 0 && gp.ui.commandCol == 4){
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
                else if(gp.ui.commandRow > 2 && gp.ui.commandCol == 3){
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandRow > 1 && gp.ui.commandCol == 4){
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
                else if(gp.ui.commandCol == 4){
                    gp.ui.commandCol--;
                    gp.ui.commandRow = 2;
                }
                else 
                    gp.ui.commandCol--;
                if(gp.ui.commandCol < 0){
                    gp.ui.commandCol = 4;
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
                else if(gp.ui.commandCol == 3){
                    gp.ui.commandCol++;
                    gp.ui.commandRow = 0;
                }
                else if(gp.ui.commandCol == 4){
                    gp.ui.commandCol++;
                    gp.ui.commandRow += 6;
                }
                else 
                    gp.ui.commandCol++;
                if(gp.ui.commandCol > 4){
                    gp.ui.commandCol = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                //Knight
                if(gp.ui.commandCol == 0 && gp.ui.commandRow == 0){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setKnight(true);
                    gp.ui.col0 = 1;
                }
                //Paladin
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 1){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setPaladin(true);
                    gp.ui.col0 = 2;
                }
                //Archer
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 2){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setRanger(true);
                    gp.ui.col0 = 3;
                }
                //Marksman
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 3){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setMarksman(true);
                    gp.ui.col0 = 4;
                }
                //Archmage
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 4){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setWizard(true);
                    gp.ui.col0 = 5;
                }
                //Druid
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 5){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setDruid(true);
                    gp.ui.col0 = 6;
                }
                //Assasin
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 6){
                    characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setAssassin(true);
                    gp.ui.col0 = 7;
                }
                //Thief
                else if(gp.ui.commandCol == 0 && gp.ui.commandRow == 7){
                   characterCreator.SetCharacterBooleansToFalse();
                    characterCreator.setThief(true);
                    gp.ui.col0 = 8;
                }

                //Fists
                if(gp.ui.commandCol == 1 && gp.ui.commandRow == 0){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setfists(true);
                    gp.ui.col1 = 1;
                }
                //Sword
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 1){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setsword(true);
                    gp.ui.col1 = 2;
                }
                //Sword+Shield
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 2){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setswordshield(true);
                    gp.ui.col1 = 3;
                }
                //Bow
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 3){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setbow(true);
                    gp.ui.col1 = 4;
                }
                //Staff
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 4){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setstaff(true);
                    gp.ui.col1 = 5;
                }
                //Daggers
                else if(gp.ui.commandCol == 1 && gp.ui.commandRow == 5){
                    inventoryCreator.setWeaponsToFalse();
                    inventoryCreator.setdaggers(true);
                    gp.ui.col1 = 6;
                }

                //Light Armor
                if(gp.ui.commandCol == 2 && gp.ui.commandRow == 0){
                    inventoryCreator.setArmorToFalse();
                    inventoryCreator.setlight(true);
                    gp.ui.col2 = 1;
                }
                //Medium armor
                else if(gp.ui.commandCol == 2 && gp.ui.commandRow == 1){
                    inventoryCreator.setArmorToFalse();
                    inventoryCreator.setmedium(true);
                    gp.ui.col2 = 2;
                }
                //Heavy armor
                else if(gp.ui.commandCol == 2 && gp.ui.commandRow == 2){
                    inventoryCreator.setArmorToFalse();
                    inventoryCreator.setheavy(true);
                    gp.ui.col2 = 3;
                }

                //1 Potion
                if(gp.ui.commandCol == 3 && gp.ui.commandRow == 0){
                    inventoryCreator.SetpotionsToFalse();
                    inventoryCreator.setpotion1(true);
                    gp.ui.col3 = 1;
                }
                //2 Potions
                else if(gp.ui.commandCol == 3 && gp.ui.commandRow == 1){
                    inventoryCreator.SetpotionsToFalse();
                    inventoryCreator.setpotion2(true);
                    gp.ui.col3 = 2;
                }
                //3 Potions
                else if(gp.ui.commandCol == 3 && gp.ui.commandRow == 2){
                    inventoryCreator.SetpotionsToFalse();
                    inventoryCreator.setpotion3(true);
                    gp.ui.col3 = 3;
                }

                //Next
                if(gp.ui.commandCol == 4 && gp.ui.commandRow == 0){
                    if(gp.ui.col0 != 0 && gp.ui.col1 != 0 && gp.ui.col2 != 0 && gp.ui.col3 != 0){
                        gp.ui.col0 = 0;
                        gp.ui.col1 = 0;
                        gp.ui.col2 = 0;
                        gp.ui.col3 = 0;
                        if(gp.ui.commandCount == 3 && gp.ui.commandNum == 1){ //tu wybrano wszytkich bohaterów
                            gp.ui.commandCol = 0;
                            gp.ui.commandRow = 0;
                            gp.tileM.lodaMap();
                            gp.ui.titleScreenState = 3;
                        }
                        else if(gp.ui.commandCount == 3 && gp.ui.commandNum == 0){ //tu team się zmienia
                            characterCreator.SaveHerotoPurple(teamCreator.teamPurple,gp);
                            gp.ui.commandCount = 0;
                            gp.ui.commandNum++;
                        }
                        else{                   //next
                            if(gp.ui.commandNum == 0){characterCreator.SaveHerotoPurple(teamCreator.teamPurple,gp);}
                            if(gp.ui.commandNum == 1){characterCreator.SaveHerotoYellow(teamCreator.teamYellow, gp);}
                            gp.ui.commandCount++;
                        } 
                    }
                }
                //Skip
                else if(gp.ui.commandCol == 4 && gp.ui.commandRow == 1){
                    gp.ui.col0 = 0;
                    gp.ui.col1 = 0;
                    gp.ui.col2 = 0;
                    gp.ui.col3 = 0;
                    if(gp.ui.commandCount > 0 && gp.ui.commandNum == 1){ //tu wybrano wszytkich bohaterów
                        gp.tileM.lodaMap();
                        gp.ui.commandCol = 0;
                        gp.ui.commandRow = 0;
                        gp.ui.titleScreenState = 3;
                    }
                    else if(gp.ui.commandCount > 0 && gp.ui.commandNum == 0){  //tu team się zmienia
                        gp.ui.commandNum++;
                        gp.ui.commandCount = 0;
                    }
                }
            }
        }
        //FOURTH SCREEN  MAP SELECTION
        else if(gp.ui.titleScreenState == 3){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_D){
                gp.mapNumber++;
                if(gp.mapNumber > 9){
                    gp.mapNumber = 1;
                }
                gp.mapName = "map_" + gp.mapNumber + ".txt";
                gp.tileM.lodaMap();
                //draw
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_A){
                gp.mapNumber--;
                if(gp.mapNumber < 1){
                    gp.mapNumber = 9;
                }
                gp.mapName = "map_" + gp.mapNumber + ".txt";
                gp.tileM.lodaMap();
                //draw
            }
            if(code == KeyEvent.VK_ENTER){
                MAPtable.InitializeMap(gp.mapName);
                gp.ui.titleScreenState = 4;
                }
        }

        //FIFTH SCREEN  MAP SELECTION
        else if(gp.ui.titleScreenState == 4){
            if(code == KeyEvent.VK_W){
                gp.ui.commandRow--;
                if(gp.ui.commandRow < 0){
                    gp.ui.commandRow = 15;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandRow++;
                if(gp.ui.commandRow > 15){
                    gp.ui.commandRow = 0;
                }
            }
            if(code == KeyEvent.VK_A){
                gp.ui.commandCol--;
                if(gp.ui.commandCol < 0){
                    gp.ui.commandCol = 15;
                }
            }
            if(code == KeyEvent.VK_D){
                gp.ui.commandCol++;
                if(gp.ui.commandCol > 15){
                    gp.ui.commandCol = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){ //franek tutaj = = == = == = == = == = == == == = = = == = = == = = = = = = = == = == == = = == = == = == = == = == = = = == = = = == = = = = = == = = = = = = = == 
                if(MAPtable.Map[gp.ui.commandRow][gp.ui.commandCol].occupied == false && MAPtable.Map[gp.ui.commandRow][gp.ui.commandCol].solid == false){
                    characterCreator.SaveAllCharactersPositions(gp.ui.commandRow,gp.ui.commandCol);
                }
                //zacząć grę jak postawiono wszystkie jednostki
                if(SavedPositions==TeamCreator.teamYellow.getTeam().size() + TeamCreator.teamPurple.getTeam().size())
                {
                    gp.gameState = gp.playState;
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