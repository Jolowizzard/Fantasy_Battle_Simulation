public abstract class Warrior extends Character{
    private int BlockChance;
    private int BlockValue;
    Warrior(int Id,String Name,String Race,int MaxHp,int CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive,int BlockChance,int BlockValue,Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.BlockChance=BlockChance;
        this.BlockValue=BlockValue;
    }
    Warrior(int Id,String Name, InteligenceType inteligenceType, Tile Position,Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        BlockChance = 0;
        BlockValue = 0;
    }

    public int getBlockChance(){
        return BlockChance;
    }
    public int getBlockValue(){
        return BlockValue;
    }

    /*public int passiveBlock()
        return hier will be method checking if passiveBlock worked or not
    }*/
}
