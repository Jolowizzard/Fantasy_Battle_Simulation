package characters.shooter;

import characters.shooter.Shooter;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Ranger extends Shooter {
    public Ranger(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int CritChance, int CritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,CritChance,CritValue,Position);
        setMainClass("Ranger");
    }
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setSubClass("Ranger");
        setRace("Human");
        setMaxHp(80);
        setCurrentHp(80);
        setStrength(10);
        setDexterity(30);
        setIntelignece(10);
        setMovement(4);
        setDodgeChance(10);
        setCritChance(5);
        setCritValue(50);
    }
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setSubClass("Ranger");
        setRace("Human");
        setMaxHp(80);
        setCurrentHp(80);
        setStrength(10);
        setDexterity(30);
        setIntelignece(10);
        setMovement(4);
        setDodgeChance(10);
        setCritChance(5);
        setCritValue(50);
    }
    public Ranger(int CritChance, int CritValue){
        this.CritChance = CritChance;
        this.CritValue = CritValue;
    }
    public Ranger(){}
}