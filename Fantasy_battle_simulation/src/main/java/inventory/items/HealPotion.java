package inventory.items;

import characters.Character;

/**
 * Heal potion extends Item class. Distinguish two states, Full and empty. Restores 50% of characters MaxHp value on use.
 */
public class HealPotion extends Item{
    private int healthPercentageValue;//describes healing power a potion
    private boolean full;// true if is full otherwise false

    /**
     *
     * @param name
     */
    public HealPotion(String name) {
        super(name);
        healthPercentageValue = 50;
        full = true;
    }

    /**
     * Constructor with some preset values
     */
    public HealPotion() {
        setName("HealPotion");
        healthPercentageValue = 50;
        full = true;
    }
    public int getHealthPercentageValue() {
        return healthPercentageValue;
    }
    public void setHealthPercentageValue(int healthPercentageValue) {this.healthPercentageValue = healthPercentageValue;}
    public boolean isFull() {return full;}
    public void setFull(boolean full) {this.full = full;}

    /**
     * Use of Health potion - resotres healthPrecentageValue of maxHp
     * @param character
     * @return
     */
    @Override
    public boolean use(Character character){
        if(isFull()) {
            character.getIntType().getGamePanel().logEvent("Used Healing potion and healed for :" + (int)((float)character.getMaxHp() *( (float)healthPercentageValue / 100.0)));
            System.out.println("used healing potion and healed for : "+ (int)((float)character.getMaxHp() *( (float)healthPercentageValue / 100.0)));
            character.setCurrentHp(character.getCurrentHp() + (int)((float)character.getMaxHp() *( (float)healthPercentageValue / 100.0)));//Adding percentage value of hp to characters current hp
            setFull(false);
            return true;
        }
        return false;
    }
}
