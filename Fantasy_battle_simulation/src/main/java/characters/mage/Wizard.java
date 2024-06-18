package characters.mage;

import characters.mage.Mage;
import gui.GamePanel;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Wizard extends Mage {
    public Wizard(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int MagicCritChance, int MagicCritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,MagicCritChance,MagicCritValue,Position);
    }
    public Wizard(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(110);
        setCurrentHp(110);
        setStrength(7);
        setDexterity(8);
        setIntelignece(20);
        setMovement(2);
        setDodgeChance(4);
        setMagicCritChance(8);
        setMagicCritValue(50);
        setSubClass("Wizard");

    }
    public Wizard(int CritChance, int CritValue, GamePanel gamePanel){
        super(CritChance,CritValue,gamePanel);
        setRace("Human");
        setMaxHp(110);
        setCurrentHp(110);
        setStrength(7);
        setDexterity(8);
        setIntelignece(20);
        setMovement(2);
        setDodgeChance(4);
        setMagicCritChance(8);
        setMagicCritValue(50);
        setSubClass("Wizard");
        
    }
    public Wizard(){}
}