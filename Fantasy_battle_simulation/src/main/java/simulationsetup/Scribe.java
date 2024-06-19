package simulationsetup;

import java.io.*;
import java.util.Scanner;

/**
 * This class writes down every thing, that happens in the simulation to a .txt file
 */
public class Scribe {

    public static FileWriter myWrite;
    private static String filename;

    /**
     *
     * @param filename
     */
    public Scribe(String filename){
        this.filename = filename;
    }

    /**
     * Adds log to a txt file
     * @param message
     */
    public static void addLog(String message){
            try (FileWriter fw = new FileWriter(filename, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
