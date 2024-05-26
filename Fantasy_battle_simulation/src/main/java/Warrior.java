public abstract class Warrior extends Character{
    private int BlockChance;
    private int BlockValue;
    Warrior(int Id,String Name,String Race,int MaxHp,int CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive,int BlockChance,int BlockValue,Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.BlockChance=BlockChance;
        this.BlockValue=BlockValue;
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
