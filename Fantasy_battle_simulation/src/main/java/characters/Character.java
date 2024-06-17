package characters;
import gui.Entity;
import gui.Hero;
import inventory.Inventory;
import inteligence.*;
import map.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private final List<Integer> statusEffects = new ArrayList<>(List.of(0)); // There a status effects such as bleed, stun etc.
    private ArrayList<Integer> damageTypesDealt;
    private Hero representation;
    private ArrayList<Integer> damageTypesBlocked;
    private int damageTaken = 0;
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
    public Character(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
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
    public Character(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        this.Id = Id;
        this.Name = Name;
        this.IntType = inteligenceType;
        this.inventory = inventory;
    }
    public Character() {
        this.Id = 0;
        this.Name = null;
        this.Race = null;
        this.MaxHp = 0;
        this.CurrentHp = 0;
        this.Strength = 0;
        this.Dexterity = 0;
        this.Intelignece = 0;
        this.Movement = 0;
        this.DodgeChance = 0.0f;
        this.inventory = null;
        this.IntType = null;
        this.IsAlive = false;
        this.mainClass = null;
        this.subClass = null;
        this.temporalArmour = 0;
        this.Position = null;
    }
    public void setRepresentation(Hero hero){
        this.representation = hero;
    }
    public Hero getRepresentation(){return representation;}
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

    public void setStatusEffects(List<Integer> list) {
        this.statusEffects.clear();
        this.statusEffects.addAll(list);
    }
    public void setSpecificStatusEffect(int statusEffect, int newValue){this.statusEffects.set(statusEffect,newValue);}
    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }
    public List<Integer> getStatusEffects() {
        return statusEffects;
    }
    public int getSpecificStatusEffectValue(int statusEffect) {return statusEffects.get(statusEffect);}
    public void setPosition(Tile NewPosition){Position = NewPosition;}
    public void setTemporalArmour(int temporalArmour){this.temporalArmour = temporalArmour;}
    public boolean checkIfIsAlive(){
        return IsAlive;
    }
    public void takeDamage(int Damage){
        this.CurrentHp=this.CurrentHp-Damage;
        this.damageTaken+=Damage;
    }
    public void kill(){
        IsAlive = false;
        Position.occupied=false;
    }
    public void useClassAbility(Character character){
    }
    public int getDamageTaken() {
        return damageTaken;
    }
    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public void setDamageTypesBlocked(ArrayList<Integer> damageTypesBlocked) {
        this.damageTypesBlocked = damageTypesBlocked;
    }
    public void setDamageTypesDealt(ArrayList<Integer> damageTypesDealt) {
        this.damageTypesDealt = damageTypesDealt;
    }

    public ArrayList<Integer> getDamageTypesBlocked() {
        return damageTypesBlocked;
    }
    public ArrayList<Integer> getDamageTypesDealt() {
        return damageTypesDealt;
    }
    public void addDamageTypesBlocked(ArrayList<Integer> damageTypesBlocked) {
        for(int i = 0;i<damageTypesBlocked.size();i+=2){
            this.damageTypesBlocked.set(i+1,this.damageTypesBlocked.get(i+1)+damageTypesBlocked.get(i+1));
        }
    }
    public void addDamageTypesDealt(ArrayList<Integer> damageTypesDealt){
        for(int i = 0;i<damageTypesDealt.size();i+=2){
            this.damageTypesDealt.set(i+1,this.damageTypesDealt.get(i+1)+damageTypesDealt.get(i+1));
        }
    }
}
