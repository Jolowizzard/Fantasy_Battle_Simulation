package armours;

public class NoArmor extends Armour{
    public NoArmor(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    public NoArmor(int NameId){
        super(NameId,0,0,0);
    }
    public NoArmor(){
        setPhysicalProtection(0);
        setMagicalProtection(0);
        setMSReduction(0);
    }
}
