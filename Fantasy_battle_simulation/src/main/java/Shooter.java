public abstract class Shooter extends Character{
    private int CritChance;
    private int CritValue;
    Shooter(int Id,String Name,String Race,int MaxHp,int CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive,int CritChance,int CritValue,Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,Position);
        this.CritChance=CritChance;
        this.CritValue=CritValue;
    }
    Shooter(int Id,String Name, InteligenceType inteligenceType, Tile Position,Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        CritChance = 0;
        CritValue = 0;
    }

    public int getCritChance(){
        return CritChance;
    }
    public int getCritValue(){
        return CritValue;
    }

    /*public int passiveCrit()
        return hier will be method checking if passiveCrit worked;
    }*/
}