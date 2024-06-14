package armours;

public class LightArmour extends Armour {
    LightArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    LightArmour(int NameId){
        super(NameId,3,1,1);
    }
    LightArmour(){
        setPhysicalProtection(3);
        setMagicalProtection(1);
        setMSReduction(1);
    }
}
