package weapons;

import combat.Combat;
import map.Tile;
import weapons.Weapon;
import characters.Character;
public class Sword extends Weapon {
    public Sword(String Name, int PhisicalDamage, int MagicDamage, int Range, int Accuracy, boolean Hands){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }
    public void SetValues() {

    }
    @Override
    public int attack(){
            return getPhisicalDamage();
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
