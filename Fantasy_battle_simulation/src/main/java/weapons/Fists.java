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
        setPhisicalDamage(20);
        setRange(1);
    }

    @Override
    public ArrayList<Integer> attack(Character user) {

        ArrayList<Integer> damageTypes = new ArrayList<>();
        damageTypes.add(0);
        damageTypes.add(getPhisicalDamage() + user.getStrength()/10);

        return damageTypes;
    }

    @Override
    public boolean canAttack(Character character, Character target) {
        return false;
    }
}
