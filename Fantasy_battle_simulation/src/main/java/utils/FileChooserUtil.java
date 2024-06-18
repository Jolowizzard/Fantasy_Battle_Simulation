package utils;
import javax.swing.*;
import java.io.File;

/**
 * used to get File path
 */
public class FileChooserUtil {


    /**
     * return File path
     * @return
     */
    public static String selectFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null); // Select file to open

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null; // Return null if no file was selected
    }
}
