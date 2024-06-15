package inventory.items;

import characters.Character;
import utils.RandomNumber;

import java.util.Random;

public class Shield extends Item {
    private int blockChance;
    private int movementReduction;
    public Shield(String name, int BlockChance,int MovementReduction) {
        super(name);
        this.blockChance = BlockChance;
        this.movementReduction = MovementReduction;
    }
    public Shield() {
        setName("Shield");
        blockChance = 30;
        movementReduction = 1;
    }
    public int getBlockChance() {
        return blockChance;
    }
    public void setBlockChance(int BlockChance) {this.blockChance = BlockChance;}
    public int getMovementReduction() {
        return movementReduction;}

    public void setMovementReduction(int movementReduction) {
        this.movementReduction = movementReduction;
    }

    @Override
    public boolean use(Character character) {
        RandomNumber d100 = new RandomNumber();
        return blockChance <= d100.generateRandomNumber();
    }
}
