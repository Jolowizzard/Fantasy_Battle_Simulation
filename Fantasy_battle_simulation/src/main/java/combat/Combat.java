package combat;
import java.lang.Math;
import characters.Character;
public class Combat {
    //This class will be used to performe various combat action
/*    public boolean CheckIfHitConnects(characters.Character char1,characters.Character char2){
        if(CurrentLocation(char1))
    }*/
    public void DealDamage(characters.Character char1, int Damage){
        if(Damage>char1.getCurrentHp())
        {
            char1.takeDamage(char1.getCurrentHp());
            char1.kill();

        }
        else {
            char1.takeDamage(Damage);
        }





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
