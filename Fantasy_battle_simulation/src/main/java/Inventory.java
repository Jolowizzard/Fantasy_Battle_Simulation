import java.util.ArrayList;

public class Inventory {
    private Weapon CurrentWeapon;
    private Armour CurrentArmour;
    private ArrayList<Weapon> Weapons;
    private ArrayList<Armour> Armours;
    Inventory(){
        Weapons = new ArrayList<>();
        Armours = new ArrayList<>();
    }
    Inventory(ArrayList<Weapon> Weapons,ArrayList<Armour> Armours){
       this.Weapons=Weapons;
       this.Armours=Armours;
    }
    Inventory(ArrayList<Weapon> Weapons){
        this.Weapons=Weapons;
        Armours = new ArrayList<>();
    }
    public ArrayList<Weapon> getWeapons(){
        return Weapons;
    }
    public ArrayList<Armour> getArmours(){
        return Armours;
    }
    public Weapon getCurrentWeapon(){
        return CurrentWeapon;
    }
    public Armour getCurrentArmour(){
        return CurrentArmour;
    }
    public void setCurrentWeapon(Weapon currentWeapon){
        this.CurrentWeapon = currentWeapon;
    }
    public void setCurrentArmour(Armour currentArmour){
        this.CurrentArmour = currentArmour;
    }
}