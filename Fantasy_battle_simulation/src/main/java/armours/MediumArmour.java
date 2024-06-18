package armours;

import armours.Armour;

import java.util.ArrayList;

/**
 * armour type medium armour
 */

public class MediumArmour extends Armour {
    public MediumArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    public MediumArmour(int NameId){
        super(NameId,6,3,1);
    }

    /**
     * default constructor of medium armour
     */
    public MediumArmour(){
        setPhysicalProtection(6);
        setMagicalProtection(3);
        setMSReduction(1);
    }
}
