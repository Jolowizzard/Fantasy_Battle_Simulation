package characters.warriors;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;
import utils.RandomNumber;

public abstract class Warrior extends characters.Character {
    protected int BlockChance;
    protected int BlockValue;
    Warrior(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int BlockChance, int BlockValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.BlockChance=BlockChance;
        this.BlockValue=BlockValue;
        mainClass = "Warrior";
    }
    Warrior(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        BlockChance = 0;
        BlockValue = 0;
        mainClass = "Warrior";
    }
    Warrior(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        mainClass = "Warrior";
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
}
