
import map.Tile2;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*; 

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

            tile[2] = new Tile2();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_2.png")));
            //tile[2].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_2.png")));

            tile[3] = new Tile2();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_3.png")));
            //tile[3].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_3.png")));

            tile[4] = new Tile2();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_4.png")));
            //tile[4].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_4.png")));

            tile[5] = new Tile2();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_5.png")));
            //tile[5].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_5.png")));

            tile[6] = new Tile2();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_6.png")));
            //tile[6].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_6.png")));

            tile[7] = new Tile2();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_7.png")));
            //tile[7].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_7.png")));

            tile[8] = new Tile2();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_8.png")));
            //tile[8].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_8.png")));

            tile[9] = new Tile2();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Tile_9.png")));
            //tile[9].image = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("Tile_9.png")));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void lodaMap(){
        try{
            //Wybór mapy
            InputStream is = getClass().getResourceAsStream(gp.mapName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow){

                String line = br.readLine();

                while(col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    //generowanie losowych kafelków 0 (33% szans że 0, 8% szans na każdy z zakresu 2-9) 
                    if(num == 0){
                        Random rand = new Random();
                        num = rand.nextInt(12) + 1;
                        if(num == 1 || num > 9)
                            num = 0;
                    }

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
