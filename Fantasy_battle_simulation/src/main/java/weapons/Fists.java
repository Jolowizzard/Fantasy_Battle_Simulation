package weapons;

import characters.Character;

import java.util.ArrayList;

public class Fists extends Weapon{
    public Fists(String Name, int PhisicalDamage, int MagicDamage, int Range, int Accuracy, boolean Hands,boolean magickWeapon){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands,magickWeapon);
    }
    public Fists() {
        setName("Fists");
        setHands(false);
        setAccuracy(100);
        setMagicDamage(0);
        setMagickWeapon(false);
        setPhisicalDamage(10);
        setRange(1);
    }

    @Override
    public ArrayList<Integer> attack(Character user) {

        ArrayList<Integer> damageTypes = new ArrayList<>();
        damageTypes.add(0);
        damageTypes.add(getPhisicalDamage() + user.getStrength()/10);
        if(getMagickWeapon()) {
            damageTypes.add(1);
            damageTypes.add(getMagicDamage() + user.getIntelignece());
        }
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
}
