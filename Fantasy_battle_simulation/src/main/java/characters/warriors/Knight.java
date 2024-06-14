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
        setRace("Human");
        setMaxHp(200);
        setCurrentHp(200);
        setStrength(8);
        setDexterity(10);
        setIntelignece(10);
        setMovement(3);
        setDodgeChance(5);
        setBlockChance(50);
        setBlockValue(4);
        setSubClass("Knight");
    }
    public Knight(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(200);
        setCurrentHp(200);
        setStrength(8);
        setDexterity(10);
        setIntelignece(10);
        setMovement(3);
        setDodgeChance(5);
        setBlockChance(50);
        setBlockValue(4);
        setSubClass("Knight");
    }
}
