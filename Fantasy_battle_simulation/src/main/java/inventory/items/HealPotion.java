package inventory.items;

import characters.Character;

public class HealPotion extends Item{
    private int healthPercentageValue;//describes healing power a potion
    private boolean full;// true if is full otherwise false
    public HealPotion(String name) {
        super(name);
        healthPercentageValue = 50;
        full = true;
    }

    public int getHealthPercentageValue() {
        return healthPercentageValue;
    }
    public void setHealthPercentageValue(int healthPercentageValue) {this.healthPercentageValue = healthPercentageValue;}
    public boolean isFull() {return full;}
    public void setFull(boolean full) {this.full = full;}

    @Override
    public void use(Character character){
        if(isFull()) {
            System.out.println("used healing potion and healed for : "+ (int)((float)character.getMaxHp() *( (float)healthPercentageValue / 100.0)));
            character.setCurrentHp(character.getCurrentHp() + (int)((float)character.getMaxHp() *( (float)healthPercentageValue / 100.0)));//Adding percentage value of hp to characters current hp
        }
    }
}
