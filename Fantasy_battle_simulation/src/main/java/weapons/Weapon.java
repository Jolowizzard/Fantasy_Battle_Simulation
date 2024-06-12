package weapons;
import map.Tile;
import characters.Character;
public abstract class Weapon {
    private String Name;
    private int PhisicalDamage;
    private int MagicDamage;
    private int Range;
    private int Accuracy;
    private boolean MagickWeapon; // 1 - weapon is magical and deals magic damage ; 0 - weapon isnt magical and deals physical damage
    private boolean Hands;// 0 equals 1 handed weapon and 1 equals 2 handed weapon
    Weapon(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands,boolean MagickWeapon){
        this.Name=Name;
        this.PhisicalDamage=PhisicalDamage;
        this.MagicDamage=MagicDamage;
        this.Range=Range;
        this.Accuracy=Accuracy;
        this.Hands=Hands;
        this.MagickWeapon=MagickWeapon;
    }
    Weapon(){}
    public void setName(String name){this.Name = name;}

    public void setHands(boolean hands) {
        Hands = hands;
    }

    public void setMagickWeapon(boolean magickWeapon) {
        MagickWeapon = magickWeapon;
    }

    public void setPhisicalDamage(int phisicalDamage) {
        PhisicalDamage = phisicalDamage;
    }

    public void setAccuracy(int accuracy) {
        Accuracy = accuracy;
    }

    public void setRange(int range) {
        Range = range;
    }

    public void setMagicDamage(int magicDamage) {
        MagicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return MagicDamage;
    }

    public int getPhisicalDamage() {
        return PhisicalDamage;
    }

    public int getRange() {
        return Range;
    }

    public String getName() {
        return Name;
    }

    public int getAccuracy() {
        return Accuracy;
    }

    public abstract int attack(Character user);
    public abstract boolean canAttack(Character character, Character target);

}
