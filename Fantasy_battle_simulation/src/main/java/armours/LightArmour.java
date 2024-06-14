package armours;

public class LightArmour extends Armour {
    public LightArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    public LightArmour(int NameId){
        super(NameId,3,1,1);
    }
    public LightArmour(){
        setPhysicalProtection(3);
        setMagicalProtection(1);
        setMSReduction(1);
    }
}
