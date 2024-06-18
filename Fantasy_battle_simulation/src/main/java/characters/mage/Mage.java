package characters.mage;

import gui.GamePanel;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;
import simulationsetup.Scribe;
import utils.RandomNumber;

import java.security.Provider;

public abstract class Mage extends characters.Character {
    private int MagicCritChance;
    private int MagicCritValue;
    Mage(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int MagicCritChance, int MagicCritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.MagicCritChance=MagicCritChance;
        this.MagicCritValue=MagicCritValue;
        setMainClass("Mage");
    }
    Mage(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        MagicCritChance = 0;
        MagicCritValue = 0;
        setMainClass("Mage");
    }
    public Mage(int CritChance, int CritValue, GamePanel gamePanel){
        MagicCritChance = CritChance;
        MagicCritValue = CritValue;
    }
    public Mage(){}

    public int getMagicCritChance(){
        return MagicCritChance;
    }
    public int getMagicCritValue(){
        return MagicCritValue;
    }
    public void setMagicCritChance(int magicCritChance) {
        MagicCritChance = magicCritChance;
    }
    public void setMagicCritValue(int magicCritValue) {
        MagicCritValue = magicCritValue;
    }

    public int passiveMagicCrit(){
    RandomNumber rand = new RandomNumber();
        if(rand.generateRandomNumber()<=MagicCritChance) {
            Scribe.addLog("Passive Magic Crit Succeeded");
            return MagicCritValue;
        }
        return 0;
    }
}

