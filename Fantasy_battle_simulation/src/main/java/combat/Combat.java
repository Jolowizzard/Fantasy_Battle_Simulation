package combat;

import characters.Character;
import characters.mage.Mage;
import characters.shooter.Shooter;
import characters.warriors.Warrior;
import armours.*;
import simulationsetup.Scribe;

import java.util.ArrayList;
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
        Scribe.addLog("Combat started:");
        try {
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }

        Scribe.addLog(attacker.getName() + " attacked " + defender.getName());

        try {
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void BeginCombat(){
        //checking dodge
        if(CheckDodge(defender)) {
            Scribe.addLog(defender.getName() + " dodged");
            try {
                Thread.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }

            return;
        }
        if(defender.getInventory().getCurrentItem()!=null){
            try {
                Thread.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }

            if(defender.getInventory().getCurrentItem().use(defender)) {//if shield worked end combat
                Scribe.addLog(defender.getName() + " used Shield");
                try {
                    Thread.sleep(20);
                }catch (Exception e){
                    e.printStackTrace();
                }

                return;

            }
        }
        ArrayList<Integer> damageTypes = attacker.getInventory().getCurrentWeapon().attack(attacker);
        ArrayList<Integer> armourTypes = resolveArmour();
        int currentDamage;
        int damageSum;
        //Dealing damage here also we have wiggle room for printing amounts of specific types of damage
        Scribe.addLog(attacker.getName() + " used " + attacker.getInventory().getCurrentWeapon().getName());
        int additionalDamage=0;
        for(int i=0 ;i <damageTypes.size();i+=2){
            additionalDamage=0;
            switch (damageTypes.get(i)){
                case 0:
                    additionalDamage=ApplyBuffsOnAttack();
                    break;
                case 1:
                    additionalDamage=ApplyBuffsOnAttack();
                    break;
                case 2:
                    if(damageTypes.get(i+1)>0){
                        defender.setSpecificStatusEffect(0,damageTypes.get(i+1)); // setting new value for bleeding status effect
                    }
            }
            if(i>armourTypes.size())
                damageTypes.set(i+1,damageTypes.get(i+1)-armourTypes.get(i+1)+additionalDamage);
            else
                damageTypes.set(i+1,damageTypes.get(i+1)+additionalDamage);
        }
        // here damage Types goes to class, that prints logs to txt or csv file

        //Adding damageBlocked
        if(defender.getDamageTypesBlocked()==null){
            defender.setDamageTypesBlocked(armourTypes);
        }else{
            defender.addDamageTypesBlocked(armourTypes);
        }
        //Adding damageDealt
        if(attacker.getDamageTypesDealt()==null){
            attacker.setDamageTypesDealt(damageTypes);
        }else{
            attacker.addDamageTypesDealt(damageTypes);
        }

        DealDamageToDefender(damageTypes);
        //cleaning after combat
        defender.setTemporalArmour(0);
    }
    public void DealDamageToDefender(ArrayList<Integer> damageTypes){
        for(int i = 1 ; i<damageTypes.size();i+=2) {
            if (damageTypes.get(i) > 0) {
                defender.getIntType().setInjured(true);
                if (damageTypes.get(i) >= defender.getCurrentHp()) {
                    defender.takeDamage(defender.getCurrentHp());
                    defender.kill();
                } else {
                    defender.takeDamage(damageTypes.get(i));
                }
            }
        }
    }
    private ArrayList<Integer> resolveArmour(){
        ArrayList<Integer> armorTypes = new ArrayList<>(defender.getInventory().getCurrentArmour().blockDamage());
        //setting temporal armour on every character that is warrior type and takes damage in this combat
        if(defender.getMainClass().equals("Warrior")){
            Warrior warrior = (Warrior) defender;
            armorTypes.set(0,armorTypes.get(0)+ warrior.passiveBlock());
        }
        return armorTypes;
    }
    private int ApplyBuffsOnAttack(){
        if(attacker.getMainClass().equals("Mage")){
            Mage mage = (Mage) attacker;
            return mage.passiveMagicCrit();
        }
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
