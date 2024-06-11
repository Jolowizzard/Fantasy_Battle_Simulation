package characters.warriors;

import characters.warriors.Warrior;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Paladin extends Warrior {
    public Paladin(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int BlockChance, int BlockValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,BlockChance,BlockValue,Position);
    }
    public Paladin(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
    }
    public Paladin(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        Race = "Human";
        MaxHp = 150;
        CurrentHp = MaxHp;
        Strength = 10;
        Dexterity = 10;
        Intelignece = 10;
        Movement = 3;
        DodgeChance = 5;
        BlockChance = 20;
        BlockValue = 15;
        subClass = "Paladin";
    }
}