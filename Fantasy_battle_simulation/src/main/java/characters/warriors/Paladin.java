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
        setRace("Human");
        setMaxHp(150);
        setCurrentHp(150);
        setStrength(10);
        setDexterity(10);
        setIntelignece(10);
        setMovement(3);
        setDodgeChance(5);
        setBlockChance(20);
        setBlockValue(15);
        setSubClass("Paladin");
    }
    public Paladin(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(150);
        setCurrentHp(150);
        setStrength(10);
        setDexterity(10);
        setIntelignece(10);
        setMovement(3);
        setDodgeChance(5);
        setBlockChance(20);
        setBlockValue(15);
        setSubClass("Paladin");
    }
}