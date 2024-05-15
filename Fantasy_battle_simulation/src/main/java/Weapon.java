public abstract class Weapon {
    private String Name;
    private int PhisicalDamage;
    private int MagicDamage;
    private int Range;
    private int Accuracy;
    private boolean Hands;// 0 equals 1 handed weapon and 1 equals 2 handed weapon
    Weapon(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands){
        this.Name=Name;
        this.PhisicalDamage=PhisicalDamage;
        this.MagicDamage=MagicDamage;
        this.Range=Range;
        this.Accuracy=Accuracy;
        this.Hands=Hands;
    }
    public abstract void attack();
}
