package characters.rogue;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;


/**
 * rogue type assassin
 */
public class Assassin extends Rogue {
    public Assassin(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,SecondMove,Position);
    }

    /**
     * default constructor of assassin
     * @param Id
     * @param Name
     * @param inteligenceType
     * @param Position
     * @param inventory
     */
    public Assassin(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(80);
        setCurrentHp(80);
        setStrength(14);
        setDexterity(20);
        setIntelignece(13);
        setMovement(4);
        setDodgeChance(50);
        setSubClass("Assassin");

    }
    public Assassin(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(80);
        setCurrentHp(80);
        setStrength(14);
        setDexterity(20);
        setIntelignece(13);
        setMovement(4);
        setDodgeChance(50);
        setSubClass("Assassin");

    }
    public Assassin(boolean secondMove){
        setSecondMove(secondMove);
    }
    public Assassin(){}
}