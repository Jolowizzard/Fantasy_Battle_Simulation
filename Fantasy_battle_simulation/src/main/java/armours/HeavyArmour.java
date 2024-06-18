package armours;

/**
 * armour type heavyarmour
 */
public class HeavyArmour extends Armour{
    public HeavyArmour(int NameId, int physicalProtection, int magicalProtection, int MSReduction) {
        super(NameId, physicalProtection, magicalProtection, MSReduction);
    }


    public HeavyArmour(int NameId){
        super(NameId,9,6,2);
    }

    /**
     * default constructor of heavy armour
     */
    public HeavyArmour(){
        setMSReduction(3);
        setPhysicalProtection(9);
        setMagicalProtection(6);
    }
}
