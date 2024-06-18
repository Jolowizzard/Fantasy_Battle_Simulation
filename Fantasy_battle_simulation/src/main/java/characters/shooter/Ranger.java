package characters.shooter;

import characters.shooter.Shooter;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

/**
 * shooter type ranger
 */
public class Ranger extends Shooter {
    public Ranger(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int CritChance, int CritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,CritChance,CritValue,Position);
        setMainClass("Ranger");
    }
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        setRace("Human");
        setMaxHp(130);
        setCurrentHp(130);
        setStrength(11);
        setDexterity(18);
        setIntelignece(11);
        setMovement(4);
        setDodgeChance(20);
        setCritChance(5);
        setCritValue(30);
        setSubClass("Ranger");

    }

    /**
     * default constructor of ranger
     * @param Id
     * @param Name
     * @param inteligenceType
     * @param inventory
     */
    public Ranger(int Id, String Name, InteligenceType inteligenceType, Inventory inventory){
        super(Id,Name,inteligenceType,inventory);
        setRace("Human");
        setMaxHp(130);
        setCurrentHp(130);
        setStrength(11);
        setDexterity(18);
        setIntelignece(11);
        setMovement(4);
        setDodgeChance(20);
        setCritChance(5);
        setCritValue(30);
        setSubClass("Ranger");
    }
    public Ranger(int CritChance, int CritValue){
        this.CritChance = CritChance;
        this.CritValue = CritValue;
    }
    public Ranger(){}
}