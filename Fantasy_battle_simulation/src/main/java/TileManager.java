import com.sun.tools.javac.Main;
import map.Tile2;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    
    GamePanel gp;
    Tile2[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile2[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        lodaMap();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile2();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_0.png")));
            //tile[0].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_0.png")));

            tile[1] = new Tile2();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_1.png")));
            //tile[1].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_1.png")));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void lodaMap(){
        try{
            //Wybór mapy - - - - - - - - - - -- - - -- - -- - - --  -- - -- - -- - - -- - - -- - -- - - - 
<<<<<<< HEAD
            InputStream is = getClass().getResourceAsStream("map_1.txt");
=======
            InputStream is = getClass().getResourceAsStream("map_3.txt");
>>>>>>> 07310c73ed164e7ac07ddd0e0d9dac919d47d279
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow){

                String line = br.readLine();

                while(col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
