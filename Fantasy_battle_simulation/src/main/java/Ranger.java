public class Ranger extends Shooter {
    public Ranger(int Id,String Name,String Race,int MaxHp,int CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive,int CritChance,int CritValue,Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,CritChance,CritValue,Position);
    }
    public Ranger(int Id,String Name, InteligenceType inteligenceType, Tile Position,Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
    }
}