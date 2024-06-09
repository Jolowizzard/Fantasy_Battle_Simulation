public class Sword extends Weapon {
    Sword(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }
    public void SetValues() {

    }
    @Override
    public void attack(Character attacker,Character defender){
            Combat combat = new Combat();
            combat.DealDamage(defender, getPhisicalDamage() * attacker.getStrength());
    }
    @Override
    public boolean canAttack(Character character,Character target){
        double distance;
        //calculating euclidean distance between to characters
        distance = Math.sqrt(Math.pow(character.getPosition().col-target.getPosition().col,2)+Math.pow(character.getPosition().row-target.getPosition().row,2));
        if(distance<=character.getInventory().getCurrentWeapon().getRange())
            return true;
        return false;
    }
}
