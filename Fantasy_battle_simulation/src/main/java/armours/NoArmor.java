package armours;

public class NoArmor extends Armour{
    NoArmor(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    NoArmor(int NameId){
        super(NameId,0,0,0);
    }
    NoArmor(){
        setPhysicalProtection(0);
        setMagicalProtection(0);
        setMSReduction(0);
    }
}
