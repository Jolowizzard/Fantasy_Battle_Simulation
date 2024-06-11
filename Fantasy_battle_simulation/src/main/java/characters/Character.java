package characters;
import inventory.Inventory;
import inteligence.*;
import map.Tile;

abstract public class Character {
    protected int Id;
    protected String Name;
    protected String Race;
    protected int MaxHp;
    protected int CurrentHp;
    protected int Strength;
    protected int Dexterity;
    protected int Intelignece;
    protected int Movement;
    protected float DodgeChance;
    protected Inventory inventory;
    protected InteligenceType IntType;
    protected boolean IsAlive;
    protected String mainClass;//stores information about character's main class warrior shooter, etc
    protected String subClass;//stores information about character's sub class Knight, Paladin etc.
    protected int temporalArmour;
    protected Tile Position;  // holds an information on which tile character is currently staying on.
    protected Character(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, Tile Position){
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
        this.Position=Position;
    }
    protected Character(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        this.Id = Id;
        this.Position=Position;
        this.Name = Name;
        this.IntType = inteligenceType;
        Race = "Human";
        MaxHp = 100;
        CurrentHp = MaxHp;
        Strength = 10;
        Dexterity = 10;
        Intelignece = 10;
        Movement = 3;
        DodgeChance = 5;
        this.inventory = inventory;
        IsAlive = true;
    }
    protected Character(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        this.Id = Id;
        this.Name = Name;
        this.IntType = inteligenceType;
        this.inventory = inventory;
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
    public int getMaxHp(){
        return MaxHp;
    }
    public int getCurrentHp(){
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
    public int getTemporalArmour(){return temporalArmour;};

    public double getDodgeChance() {
        return DodgeChance;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public InteligenceType getIntType() {
        return IntType;
    }
    public Tile getPosition(){return  Position;}
    public String getMainClass(){
        return mainClass;
    }
    public String getSubClass(){
        return subClass;
    }

    public void setPosition(Tile NewPosition){Position = NewPosition;}
    public void setTemporalArmour(int temporalArmour){this.temporalArmour = temporalArmour;}
    public boolean checkIfIsAlive(){
        return IsAlive;
    }
    public void takeDamage(int Damage){this.CurrentHp=this.CurrentHp-Damage;}
    public void kill(){
        IsAlive = false;
        Position.occupied=false;
    }
    public void useClassAbility(Character character){
    }

}
