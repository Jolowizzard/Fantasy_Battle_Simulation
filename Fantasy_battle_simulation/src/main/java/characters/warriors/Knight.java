package characters.warriors;

import characters.warriors.Warrior;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

/**
 * warrior type knight
 */
public class Knight extends Warrior {
    public Knight(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int BlockChance, int BlockValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,BlockChance,BlockValue,Position);
    }
    public Knight(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(180);
        setCurrentHp(180);
        setStrength(20);
        setDexterity(15);
        setIntelignece(5);
        setMovement(3);
        setDodgeChance(7);
        setBlockChance(50);
        setBlockValue(10);
        setSubClass("Knight");

    }

    /**
     * default constructor of knight
     * @param Id
     * @param Name
     * @param inteligenceType
     * @param inventory
     */
    public Knight(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(180);
        setCurrentHp(180);
        setStrength(20);
        setDexterity(15);
        setIntelignece(5);
        setMovement(3);
        setDodgeChance(7);
        setBlockChance(50);
        setBlockValue(10);
        setSubClass("Knight");

    }
    public Knight(int BlockChance, int BlockValue){
        super(BlockChance,BlockValue);
    }
    public Knight(){}
}
