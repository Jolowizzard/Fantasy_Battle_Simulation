package simulationsetup;

import java.io.*;
import java.util.Scanner;

public class Scribe {
    //This class writes down every thing, that happens in the simulation
    public static FileWriter myWrite;
    private static String filename;
    public Scribe(String filename){
        this.filename = filename;
    }
/*    public void createFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }*/
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
