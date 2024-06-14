package characters;
import inventory.Inventory;
import inteligence.*;
import map.Tile;

abstract public class Character {
    private int Id;
    private String Name;
    private String Race;
    private int MaxHp;
    private int CurrentHp;
    private int Strength;
    private int Dexterity;
    private int Intelignece;
    private int Movement;
    private float DodgeChance;
    private Inventory inventory;
    private InteligenceType IntType;
    private boolean IsAlive;
    private String mainClass;//stores information about character's main class warrior shooter, etc
    private String subClass;//stores information about character's sub class Knight, Paladin etc.
    private int temporalArmour;
    private Tile Position;  // holds an information on which tile character is currently staying on.
    private int [] statusEffects = new int [1]; // There a status effects such as bleed, stun etc.
    public Character(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, Tile Position){
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

    public void setAlive(boolean alive) {
        IsAlive = alive;
    }

    public void setCurrentHp(int currentHp) {
        CurrentHp = currentHp;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public void setDodgeChance(float dodgeChance) {
        DodgeChance = dodgeChance;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setIntelignece(int intelignece) {
        Intelignece = intelignece;
    }

    public void setIntType(InteligenceType intType) {
        IntType = intType;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public void setMaxHp(int maxHp) {
        MaxHp = maxHp;
    }

    public void setMovement(int movement) {
        Movement = movement;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRace(String race) {
        Race = race;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setStatusEffects(int[] statusEffects) {
        this.statusEffects = statusEffects;
    }
    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }
    public int[] getStatusEffects() {
        return statusEffects;
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
