package characters.mage;

import characters.mage.Mage;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Druid extends Mage {
    public Druid(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, int MagicCritChance, int MagicCritValue, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,MagicCritChance,MagicCritValue,Position);
    }
    public Druid(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
    }
    public Druid(){
    }

}
