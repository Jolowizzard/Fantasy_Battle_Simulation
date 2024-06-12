package combat;

import characters.Character;
import characters.shooter.Shooter;
import characters.warriors.Warrior;
import java.sql.DatabaseMetaData;
import java.lang.Math;
import characters.Character;
public class Combat {
    //This class will be used to performe various combat action
/*    public boolean CheckIfHitConnects(characters.Character char1,characters.Character char2){
        if(CurrentLocation(char1))
    }*/
    private Character attacker;
    private Character defender;
    public Combat (Character attacker, Character defender){
        this.attacker=attacker;
        this.defender=defender;
    }
    public void BeginCombat(){
        //checking dodge
        if(CheckDodge(defender))
            return;
        int Damage = defender.getInventory().getCurrentWeapon().attack(attacker);
        int tempArmour = resolveArmour();

        Damage += AplayBuffsOnAttack();
        Damage -= tempArmour;
        DealDamageToDefender(Damage);
        //cleaning after combat
        defender.setTemporalArmour(0);
    }
    public void DealDamageToDefender(int Damage){
        if(Damage>0) {
            if (Damage >= defender.getCurrentHp()) {
                defender.takeDamage(defender.getCurrentHp());
                defender.kill();
            } else {
                defender.takeDamage(Damage);
            }
        }
    }
    private int resolveArmour(){
        int tempArmour = 0;
        //setting temporal armour on every character that is warrior type and takes damage in this combat
        if(defender.getMainClass().equals("Warrior")){
            Warrior warrior = (Warrior) defender;
            tempArmour = warrior.passiveBlock();
        }
        return tempArmour;
    }
    private int AplayBuffsOnAttack(){
        if(attacker.getMainClass().equals("Shooter")){
            Shooter shooter = (Shooter) attacker;
            return shooter.passiveCrit();
        }
        return 0;
    }

    //public void PerformAttack()
    /*public float CalculateDamage(characters.Character char1){
        inventory.Inventory inventory = new inventory.Inventory();
        inventory = char1.getInventory();
        inventory.getCurrentWeapon();
    }*/
    public boolean CheckDodge(Character char1)
    {
        boolean DodgeResult = false;
        if (Math.random() < (char1.getDodgeChance())/100) DodgeResult = true;
        return DodgeResult;
    }
}
