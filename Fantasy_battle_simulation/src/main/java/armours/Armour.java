package armours;

import java.util.ArrayList;

public abstract class Armour {
    private int NameId  ;
    private int physicalProtection;
    private int magicalProtection;
    private int MSReduction;//Amount of MS reducted by wearing an armour

    public Armour(int NameId,int physicalProtection,int magicalProtection,int MSReduction){
        this.NameId=NameId;
        this.physicalProtection=physicalProtection;
        this.physicalProtection=magicalProtection;
        this.MSReduction=MSReduction;
    }
    public Armour(int NameId){
        this.NameId = NameId;
    }
    public Armour(){}
    public int getMagicalProtection() {
        return magicalProtection;
    }

    public int getMSReduction() {
        return MSReduction;
    }

    public int getNameId() {
        return NameId;
    }

    public int getPhysicalProtection() {
        return physicalProtection;
    }

    public void setMagicalProtection(int magicalProtection) {
        this.magicalProtection = magicalProtection;
    }

    public void setMSReduction(int MSReduction) {
        this.MSReduction = MSReduction;
    }

    public void setNameId(int nameId) {
        NameId = nameId;
    }

    public void setPhysicalProtection(int physicalProtection) {
        this.physicalProtection = physicalProtection;
    }
    //this method returns type and amount of damage dealt by this type
    // 0 - physical
    // 1 - magical
    // To be continued . . .
    public ArrayList<Integer> blockDamage(){
        ArrayList<Integer> blockTypes = new ArrayList<>();
        blockTypes.add(0);
        blockTypes.add(getPhysicalProtection());
        blockTypes.add(1);
        blockTypes.add(getMagicalProtection());
        return blockTypes;
    }

}
