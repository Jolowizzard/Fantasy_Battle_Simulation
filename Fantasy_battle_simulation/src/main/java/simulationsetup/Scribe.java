package simulationsetup;

import java.io.*;
import java.util.Scanner;

public class Scribe {
    //This class writes down every thing, that happens in the simulation
    private FileWriter myWrite;
    private String filename;
    Scanner sc;
    public Scribe(String filename) throws FileNotFoundException {
        try {
            myWrite = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
    public void addLog(String text) throws IOException {
        myWrite.write(text);
        myWrite.close();
    }
}
