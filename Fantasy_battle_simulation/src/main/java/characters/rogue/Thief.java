package characters.rogue;

import characters.rogue.Rogue;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Thief extends Rogue {
    public Thief(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,SecondMove,Position);
    }
    public Thief(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(120);
        setCurrentHp(120);
        setStrength(10);
        setDexterity(19);
        setIntelignece(15);
        setMovement(4);
        setDodgeChance(40);
        setSubClass("Thief");

    }
    public Thief(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(120);
        setCurrentHp(120);
        setStrength(10);
        setDexterity(19);
        setIntelignece(15);
        setMovement(4);
        setDodgeChance(40);
        setSubClass("Thief");
        
    }
    public Thief(boolean secondMove){
        setSecondMove(secondMove);
    }
    public Thief(){}
}