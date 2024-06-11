package characters.rogue;

import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

public abstract class Rogue extends characters.Character {
    private boolean SecondMove;

    Rogue(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position) {
        super(Id, Name, Race, MaxHp, CurrentHp, Strength, Dexterity, Inteligence, Movement, DodgeChance, inventory, IntType, IsAlive, Position);
        this.SecondMove = SecondMove;
    }

    Rogue(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory) {
        super(Id, Name, inteligenceType, Position, inventory);
        SecondMove = false;
    }

    public boolean getSecondMove() {
        return SecondMove;
    }

}
