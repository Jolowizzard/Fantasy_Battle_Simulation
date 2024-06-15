package weapons;

import characters.Character;
import utils.RandomNumber;

import java.util.ArrayList;

public class Dagger extends Weapon{
    private int  bleedDamage;
    private int bleedChance;
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
    public ArrayList<Integer> attack(Character user) {
        //Dagger sets a bleed status effect, which is another type of damage
            ArrayList<Integer> damageTypes = new ArrayList<>();
            //Now we use only two damage types - magical and physical
            damageTypes.add(0);
            damageTypes.add(getPhisicalDamage() + user.getStrength()/20 + user.getDexterity());

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
    public boolean canAttack(Character character, Character target) {
        double distance;
        //calculating euclidean distance between to characters
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }
    private int applyBleed(Character user){
        RandomNumber d100 = new RandomNumber();
        if(d100.generateRandomNumber()<=bleedChance) {
            return bleedDamage;
        }
        return 0;
    }
}
