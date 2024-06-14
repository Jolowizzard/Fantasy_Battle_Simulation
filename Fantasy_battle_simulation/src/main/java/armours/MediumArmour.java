package armours;

import armours.Armour;

import java.util.ArrayList;

public class MediumArmour extends Armour {
    MediumArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    MediumArmour(int NameId){
        super(NameId,6,3,1);
    }
}
