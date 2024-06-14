public class Bow extends Weapon{
    public Bow(String Name,int PhisicalDamage,int MagicDamage,int Range,int Accuracy,boolean Hands) {
        super(Name,PhisicalDamage,MagicDamage,Range,Accuracy,Hands);
    }

    @Override
    public void attack(Character attacker, Character defender) {
    }

    private boolean projectileColision(Tile startTile, Tile endTile) {
        double xVector = Math.abs(startTile.col - endTile.col);
        double yVector = Math.abs(startTile.row - endTile.row);
        double CurrentY = endTile.row;
        if (xVector == 0) {
            yVector = 1;
            for (int i = startTile.row; i <= endTile.row; i++) {
                CurrentY = CurrentY + yVector;
                if (MAPtable.Map[startTile.col][(int) CurrentY].solid)
                    return true;
            }
        } else {
            if (startTile.col > endTile.col) {
                yVector = yVector / xVector;
                for (int i = endTile.col; i <= startTile.col; i++) {
                    CurrentY = Math.floor(CurrentY + yVector);
                    if (MAPtable.Map[i][(int) CurrentY].solid)
                        return true;
                }
            } else {
                yVector = yVector / xVector;
                for (int i = startTile.col; i <= endTile.col; i++) {
                    CurrentY = Math.floor(CurrentY - yVector);
                    if (MAPtable.Map[i][(int) CurrentY].solid)
                        return true;
                }
            }
        }
        return false;
    }
}
