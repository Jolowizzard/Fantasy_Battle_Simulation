package characters.rogue;

import characters.rogue.Rogue;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public class Assasin extends Rogue {
    public Assasin(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position){
        super(Id,Name,Race,MaxHp,CurrentHp,Strength,Dexterity,Inteligence,Movement,DodgeChance,inventory,IntType,IsAlive,SecondMove,Position);
        this.subClass = "Assasin";
    }
    public Assasin(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory){
        super(Id,Name,inteligenceType,Position,inventory);
        this.subClass = "Assasin";
    }
}