package armours;

/**
 * armour types light armout
 */
public class LightArmour extends Armour {
    public LightArmour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        super(NameId,physicalProtection,magicalProtection,MSReduction);
    }
    public LightArmour(int NameId){
        super(NameId,3,1,0);
    }

    /**
     * default constructor of light armour
     */
    public LightArmour(){
        setPhysicalProtection(3);
        setMagicalProtection(1);
        setMSReduction(0);
    }
}
