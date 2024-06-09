public abstract class Mage extends Character{
    private int MagicCritChance;
    private int MagicCritValue;
    Mage(int Id,String Name,String Race,int MaxHp,int CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive,int MagicCritChance,int MagicCritValue,Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.MagicCritChance=MagicCritChance;
        this.MagicCritValue=MagicCritValue;
    }
    Mage(int Id,String Name, InteligenceType inteligenceType, Tile Position,Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        MagicCritChance = 0;
        MagicCritValue = 0;
    }

    public int getMagicCritChance(){
        return MagicCritChance;
    }
    public int getMagicCritValue(){
        return MagicCritValue;
    }

    /*public int passiveMagicCrit()
        return hier will be method checking if MagicCrit worked or not
    }*/
}

