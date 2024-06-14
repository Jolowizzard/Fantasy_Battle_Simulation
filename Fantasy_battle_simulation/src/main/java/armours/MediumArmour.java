package armours;

import armours.Armour;

import java.util.ArrayList;

public class MediumArmour extends Armour {
    public MediumArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    public MediumArmour(int NameId){
        super(NameId,6,3,1);
    }
    public MediumArmour(){
        setPhysicalProtection(6);
        setMagicalProtection(3);
        setMSReduction(1);
    }
}
