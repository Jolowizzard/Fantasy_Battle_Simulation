package inventory.items;

import characters.Character;
import utils.RandomNumber;

import java.util.Random;

/**
 * Shield class - one of side items
 */
public class Shield extends Item {
    private int blockChance;

    /**
     * Specific constructor
     * @param name
     * @param BlockChance
     * @param MovementReduction
     */
    public Shield(String name, int BlockChance,int MovementReduction) {
        super(name,MovementReduction);
        this.blockChance = BlockChance;
    }

    /**
     * Constructor with preset values
     */
    public Shield() {
        setName("Shield");
        blockChance = 30;
        setMsReduction(1);
    }
    public int getBlockChance() {
        return blockChance;
    }
    public void setBlockChance(int BlockChance) {this.blockChance = BlockChance;}

    /**
     * Use shield and performs d100 roll, if value is lower, that blockChance, block succeeds.
     * @param character
     * @return
     */
    @Override
    public boolean use(Character character) {
        RandomNumber d100 = new RandomNumber();
        return blockChance <= d100.generateRandomNumber();
    }
}
