package characters.warriors;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;
import utils.RandomNumber;

public abstract class Warrior extends characters.Character {
    private int BlockChance;
    private int BlockValue;
    Warrior(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int BlockChance, int BlockValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.BlockChance=BlockChance;
        this.BlockValue=BlockValue;
        setMainClass("Warrior");
    }
    Warrior(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        BlockChance = 0;
        BlockValue = 0;
        setMainClass("Warrior");
    }
    Warrior(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setMainClass("Warrior");
    }
    public int getBlockChance(){
        return BlockChance;
    }
    public int getBlockValue(){
        return BlockValue;
    }
    public int passiveBlock(){
        RandomNumber rand = new RandomNumber();
        if(rand.generateRandomNumber()<=BlockChance)
            return BlockValue;
        return 0;
    }
    public void setBlockChance(int blockChance) {
        BlockChance = blockChance;
    }
    public void setBlockValue(int blockValue) {
        BlockValue = blockValue;
    }
}
