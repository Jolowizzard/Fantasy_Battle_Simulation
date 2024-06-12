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
        Race = "Human";
        MaxHp = 80;
        CurrentHp = MaxHp;
        Strength = 10;
        Dexterity = 30;
        Intelignece = 10;
        Movement = 4;
        DodgeChance = 10;
        CritChance = 5;
        CritValue = 50;
    }
    public Marksman(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        Race = "Human";
        MaxHp = 80;
        CurrentHp = MaxHp;
        Strength = 10;
        Dexterity = 30;
        Intelignece = 10;
        Movement = 4;
        DodgeChance = 10;
        CritChance = 5;
        CritValue = 50;
    }
}