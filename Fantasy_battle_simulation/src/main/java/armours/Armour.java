package armours;

public abstract class Armour {
    private int NameId;
    private int PhisicalProtection;
    private int MagickProtection;
    private int MSReduction;//Amount of MS reducted by wearing an armour

    Armour(int NameId,int PhisicalProtection,int MagickaProtection,int MSReduction){
        this.NameId=NameId;
        this.PhisicalProtection=PhisicalProtection;
        this.MagickProtection=MagickaProtection;
        this.MSReduction=MSReduction;
    }
    public abstract void BlockDamage();

}
