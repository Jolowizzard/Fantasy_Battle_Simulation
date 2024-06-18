package characters.shooter;

import characters.shooter.Shooter;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Marksman extends Shooter {
    public Marksman(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int CritChance, int CritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,CritChance,CritValue,Position);
    }
    public Marksman(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(100);
        setCurrentHp(100);
        setStrength(10);
        setDexterity(16);
        setIntelignece(12);
        setMovement(3);
        setDodgeChance(10);
        setCritChance(10);
        setCritValue(50);
        setSubClass("Marksman");

    }
    public Marksman(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(100);
        setCurrentHp(100);
        setStrength(10);
        setDexterity(16);
        setIntelignece(12);
        setMovement(3);
        setDodgeChance(10);
        setCritChance(10);
        setCritValue(50);
        setSubClass("Marksman");
    }
    public Marksman(int CritChance, int CritValue){
        this.CritChance = CritChance;
        this.CritValue = CritValue;
    }
    public Marksman(){}
}