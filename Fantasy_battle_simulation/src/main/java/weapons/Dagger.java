package weapons;

import characters.Character;
import utils.RandomNumber;

import java.util.ArrayList;

/**
 * Weapon type Dagger
 */
public class Dagger extends Weapon{
    private int  bleedDamage;
    private int bleedChance;

    /**
     * constructor of a dagger
     */
    public Dagger () {
        setName("Dagger");
        setHands(false);
        setAccuracy(100);
        setMagicDamage(0);
        setMagickWeapon(false);
        setPhisicalDamage(10);
        setRange(1);
        setBleedChance(70);
        setBleedDamage(10);
    }
    public int getBleedChance() {
        return bleedChance;
    }
    public void setBleedChance(int bleedChance) {this.bleedChance = bleedChance;}
    public int getBleedDamage() {return bleedDamage;}
    public void setBleedDamage(int bleedDamage) {this.bleedDamage = bleedDamage;}

    @Override
    /**
     * returns damage types of a dagger
     */
    public ArrayList<Integer> attack(Character user) {
        //Dagger sets a bleed status effect, which is another type of damage
            ArrayList<Integer> damageTypes = new ArrayList<>();
            //Now we use only two damage types - magical and physical
            damageTypes.add(0);
            damageTypes.add(getPhisicalDamage() + user.getDexterity()/2);

            damageTypes.add(1);
            if(getMagickWeapon())
                damageTypes.add(getMagicDamage() + user.getIntelignece());
            else
                damageTypes.add(0);

            damageTypes.add(2);
            damageTypes.add(applyBleed(user));

            return damageTypes;
    }
    @Override
    /**
     * returns if a character can attack target with dagger
     */
    public boolean canAttack(Character character, Character target) {
        double distance;
        //calculating euclidean distance between to characters
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }

    /**
     * applies passive of a dagger - bleed
     * @param user
     * @return
     */
    private int applyBleed(Character user){
        RandomNumber d100 = new RandomNumber();
        if(d100.generateRandomNumber()<=bleedChance) {
            return bleedDamage;
        }
        return 0;
    }
}
