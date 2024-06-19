package characters.rogue;

import characters.Character;
import inteligence.InteligenceType;
import inventory.Inventory;
import map.Tile;

import java.math.RoundingMode;

/**
 * character type rogue
 */
public abstract class Rogue extends characters.Character {
    private boolean SecondMove;

    public Rogue(int Id, String Name, String Race, int MaxHp, int CurrentHp, int Strength, int Dexterity, int Inteligence, int Movement, float DodgeChance, Inventory inventory, InteligenceType IntType, boolean IsAlive, boolean SecondMove, Tile Position) {
        super(Id, Name, Race, MaxHp, CurrentHp, Strength, Dexterity, Inteligence, Movement, DodgeChance, inventory, IntType, IsAlive, Position);
        this.SecondMove = SecondMove;
        setMainClass("Rogue");
    }

    /**
     * default constructor of a rogue
     * @param Id
     * @param Name
     * @param inteligenceType
     * @param Position
     * @param inventory
     */
    public Rogue(int Id, String Name, InteligenceType inteligenceType, Tile Position, Inventory inventory) {
        super(Id, Name, inteligenceType, Position, inventory);
        SecondMove = false;
        setMainClass("Rogue");
    }
    public Rogue(int Id, String Name, InteligenceType inteligenceType, Inventory inventory) {
        super(Id, Name, inteligenceType, inventory);
        SecondMove = false;
        setMainClass("Rouge");
    }
    public Rogue(){};
    public Rogue(boolean secondMove){
        this.SecondMove = secondMove;
    }
    public boolean getSecondMove() {
        return SecondMove;
    }
    public void setSecondMove(boolean secondMove){this.SecondMove = secondMove;}

    /**
     * method performs second move during characters turn (rogue passive)
     * @param wantsToAttack
     */
    public void performSecondMove(boolean wantsToAttack){
        InteligenceType intTyp = getIntType();

        if(wantsToAttack){
            intTyp.MoveTowardsOpponent(intTyp.getCharacter(),intTyp.GetTarget(),intTyp.getGamePanel());
        }
        else{
            Character target = intTyp.lookForTeammate();
            if(target != null) {
                Character character = intTyp.getCharacter();
                double distance;
                distance = Math.sqrt(Math.pow(character.getPosition().col - target.getPosition().col, 2) + Math.pow(character.getPosition().row - target.getPosition().row, 2));
                if (distance > 1)
                    intTyp.MoveTowardsOpponent(character, target,intTyp.getGamePanel());
            }
        }
    }


}
