package armours;

public class HeavyArmour extends Armour{
    HeavyArmour(int NameId, int physicalProtection, int magicalProtection, int MSReduction) {
        super(NameId, physicalProtection, magicalProtection, MSReduction);
    }
    HeavyArmour(int NameId){
        super(NameId,9,6,2);
    }
    HeavyArmour(){
        setMSReduction(3);
        setPhysicalProtection(9);
        setMagicalProtection(6);
    }
}
