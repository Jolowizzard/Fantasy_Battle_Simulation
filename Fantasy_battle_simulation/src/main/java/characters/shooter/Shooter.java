package characters.shooter;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;
import utils.RandomNumber;

import java.awt.image.CropImageFilter;

public abstract class Shooter extends characters.Character {
    protected int CritChance;
    protected int CritValue;
    public Shooter(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int CritChance, int CritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.CritChance=CritChance;
        this.CritValue=CritValue;
        setMainClass("Shooter");
    }
    public Shooter(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        CritChance = 0;
        CritValue = 0;
        setMainClass("Shooter");
    }
    public Shooter(int id, String name, InteligenceType inteligenceType, Inventory inventory) {
        super(id,name,inteligenceType,inventory);
        setMainClass("Shooter");
    }
    public Shooter(int CritChance, int CritValue){
        this.CritChance = CritChance;
        this.CritValue = CritValue;
    }
    public Shooter(){}
    public int getCritChance(){
        return CritChance;
    }
    public int getCritValue(){
        return CritValue;
    }
    public int passiveCrit(){
        RandomNumber rand = new RandomNumber();
        if(rand.generateRandomNumber()<=CritChance)
            return CritValue;
        return 0;
    }


    public void setCritChance(int critChance) {
        CritChance = critChance;
    }

    public void setCritValue(int critValue) {
        CritValue = critValue;
    }
}