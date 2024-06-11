package characters.warriors;

import characters.warriors.Warrior;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Knight extends Warrior {
    public Knight(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int BlockChance, int BlockValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,BlockChance,BlockValue,Position);
    }
    public Knight(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        Race = "Human";
        MaxHp = 200;
        CurrentHp = MaxHp;
        Strength = 8;
        Dexterity = 10;
        Intelignece = 10;
        Movement = 3;
        DodgeChance = 5;
        BlockChance = 50;
        BlockValue = 3;
        subClass = "Knight";
        mainClass = "Warrior";
    }
}
