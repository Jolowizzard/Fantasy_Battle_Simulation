package weapons;
import combat.Combat;
import map.Tile;
import weapons.Weapon;
import characters.Character;

import java.util.ArrayList;

public class Sword extends Weapon {
    public Sword(String Name, int PhisicalDamage, int MagicDamage, int Range, int Accuracy, boolean Hands,boolean magickDamage){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands,magickDamage);
    }
    public Sword(){
        setAccuracy(100);
        setHands(false);
        setName("Sword");
        setMagicDamage(0);
        setRange(1);
        setMagickWeapon(false);
        setPhisicalDamage(10);

    }
    public void SetValues() {
    }
    @Override
    public ArrayList<Integer> attack(Character user) {
        ArrayList<Integer> damageTypes = new ArrayList<>();
        //Now we use only two damage types - magical and physical
        damageTypes.add(0);
        damageTypes.add(getPhisicalDamage() + user.getStrength()/5);
        if(getMagickWeapon()) {
            damageTypes.add(1);
            damageTypes.add(getMagicDamage() + user.getIntelignece());
        }
        return damageTypes;
    }
    @Override
    public boolean canAttack(Character character, Character target){
        double distance;
        //calculating euclidean distance between to characters
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }
}
