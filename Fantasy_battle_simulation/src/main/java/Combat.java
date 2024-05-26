public class Combat {
    //This class will be used to performe various combat action
/*    public boolean CheckIfHitConnects(Character char1,Character char2){
        if(CurrentLocation(char1))
    }*/
    public void DealDamage(Character char1,int Damage){
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
    /*public float CalculateDamage(Character char1){
        Inventory inventory = new Inventory();
        inventory = char1.getInventory();
        inventory.getCurrentWeapon();
    }*/
}
