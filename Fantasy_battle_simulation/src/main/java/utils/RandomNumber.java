package utils;
import java.util.Random;


/**
 * generates random number
 */
public class RandomNumber {
    public int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(100)+1;//range from 1 to 100
    }
}
