package characters.rogue;

import characters.rogue.Rogue;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Thief extends Rogue {
    public Thief(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,SecondMove,Position);
        setSubClass("Thief");
        setRace("Human");
        setMaxHp(70);
        setCurrentHp(70);
        setStrength(5);
        setDexterity(35);
        setIntelignece(20);
        setMovement(5);
        setDodgeChance(25);
    }

    public Thief(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setSubClass("Thief");
        setRace("Human");
        setMaxHp(70);
        setCurrentHp(70);
        setStrength(5);
        setDexterity(35);
        setIntelignece(20);
        setMovement(5);
        setDodgeChance(25);
    }
    public Thief(boolean secondMove){
        setSecondMove(secondMove);
    }
    public Thief(){}
}