public class Sword extends Weapon {
    Sword(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands){
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }
    public void SetValues() {

    }
    @Override
    public void attack(Character attacker,Character defender){
        Combat combat = new Combat();
        combat.DealDamage(defender,getPhisicalDamage() * attacker.getStrength());
    }
}