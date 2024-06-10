package armours;

import armours.Armour;

public class MediumArmour extends Armour {
    MediumArmour(int NameId,int PhisicalProtection,int MagickaProtection,int MSReduction){
        super(NameId,PhisicalProtection,MagickaProtection,MSReduction);
    }
    @Override
    public void BlockDamage(){};
}
