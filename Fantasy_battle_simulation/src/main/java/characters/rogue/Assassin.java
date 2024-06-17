package characters.rogue;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Assassin extends Rogue {
    public Assassin(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,SecondMove,Position);
/*        setSubClass("Assassin");
        setRace("Human");
        setMaxHp(90);
        setCurrentHp(90);
        setStrength(5);
        setDexterity(30);
        setIntelignece(15);
        setMovement(4);
        setDodgeChance(15);*/
    }
    public Assassin(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setSubClass("Assassin");
        setRace("Human");
        setMaxHp(90);
        setCurrentHp(90);
        setStrength(5);
        setDexterity(30);
        setIntelignece(15);
        setMovement(5);
        setDodgeChance(15);
    }
    public Assassin(boolean secondMove){
        setSecondMove(secondMove);
    }
    public Assassin(){}
}