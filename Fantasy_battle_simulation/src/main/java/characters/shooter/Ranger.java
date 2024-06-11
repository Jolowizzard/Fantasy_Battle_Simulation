package characters.shooter;

import characters.shooter.Shooter;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Ranger extends Shooter {
    public Ranger(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int CritChance, int CritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,CritChance,CritValue,Position);
        mainClass = "Shooter";
    }
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
    }
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        Race = "Human";
        MaxHp = 100;
        CurrentHp = MaxHp;
        Strength = 10;
        Dexterity = 15;
        Intelignece = 10;
        Movement = 4;
        DodgeChance = 10;
        CritChance = 40;
        CritValue = 6;
    }
}