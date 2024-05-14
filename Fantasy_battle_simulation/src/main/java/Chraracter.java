import java.util.ArrayList;

abstract class Chraracter {
    private int Id;
    private String Name;
    private String Race;
    private float MaxHp;
    private float CurrentHp;
    private int Strength;
    private int Dexterity;
    private int Intelignece;
    private int Movement;
    private float DodgeChance;
    private Inventory inventory;
    private InteligenceType IntType;
    private boolean IsAlive;
    Chraracter(int Id,String Name,String Race,float MaxHp,float CurrentHp,int Strength,int Dexterity,int Inteligence, int Movement, float DodgeChance,Inventory inventory, InteligenceType IntType,boolean IsAlive){
        this.Id=Id;
        this.Name=Name;
        this.Race=Race;
        this.MaxHp=MaxHp;
        this.CurrentHp=CurrentHp;
        this.Strength=Strength;
        this.Dexterity=Dexterity;
        this.Intelignece=Inteligence;
        this.Movement=Movement;
        this.DodgeChance=DodgeChance;
        this.inventory=inventory;
        this.IntType=IntType;
        this.IsAlive=IsAlive;
    }
    public int getId(){
        return Id;
    }
    public String getName(){
        return Name;
    }
    public String getRace(){
        return Race;
    }
    public double getMaxHp(){
        return MaxHp;
    }
    public double getCurrentHp(){
        return CurrentHp;
    }
    public int getStrength(){
        return Strength;
    }
    public int getDexterity(){
        return Dexterity;
    }
    public int getIntelignece(){
        return Intelignece;
    }
    public int getMovement(){
        return Movement;
    }

    public double getDodgeChance() {
        return DodgeChance;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public InteligenceType getIntType() {
        return IntType;
    }
    public boolean checkIfIsAlive(){
        return IsAlive;
    }
    public void takeDamage(double damage){
        CurrentHp = CurrentHp-damage;
    }
    public void kill(){
        IsAlive = false;
    }
}
