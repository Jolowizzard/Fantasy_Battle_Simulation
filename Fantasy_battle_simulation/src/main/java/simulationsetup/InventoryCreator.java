package simulationsetup;

public class InventoryCreator {
    //Weapons
    private boolean fists = false;
    private boolean sword = false;
    private boolean swordshield = false;
    private boolean bow = false;
    private boolean staff = false;
    private boolean daggers = false;

    public boolean getfists(){return fists;}
    public boolean getsword(){return sword;}
    public boolean getbow(){return bow;}
    public boolean getswordshield(){return swordshield;}
    public boolean getstaff(){return staff;}
    public boolean getdaggers(){return daggers;}

    public void setfists(boolean bool)
    {
        fists = bool;
    }

    public void setsword(boolean bool)
    {
        sword = bool;
    }
    public void setbow(boolean bool){bow = bool;}

    public void setswordshield(boolean bool)
    {
        swordshield = bool;
    }

    public void setstaff(boolean bool)
    {
        staff = bool;
    }

    public void setdaggers(boolean bool)
    {
        daggers = bool;
    }
    //Armor
    private boolean light =false;
    private boolean medium =false;
    private boolean heavy =false;

    public boolean getlight(){return light;}
    public boolean getmedium(){return medium;}
    public boolean getheavy(){return heavy;}

    public void setlight(boolean bool){light = bool;}
    public void setmedium(boolean bool){medium = bool;}
    public void setheavy(boolean bool){heavy = bool;}

    public void CreateInventory()
    {

    }


}
