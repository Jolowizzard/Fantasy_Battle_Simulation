package simulationsetup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String filePath;
    private String delimiter;

    /**
     *
     * @param filePath
     */
    public CSVReader(String filePath) {
        this(filePath, ";");
    }

    /**
     *
     * @param filePath
     * @param delimiter
     */
    public CSVReader(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    /**
     * Method returns a hole file as list of table of strings
     * @return
     * @throws IOException
     */
    public List<String[]> readAll() throws IOException {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                records.add(values);
            }
        }
        return records;
    }

    /**
     *method returns one line as a table of Strings
     * @return
     * @throws IOException
     */
    public String [] readLineByLine() throws IOException {
            String[] values=null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null) {
                values = line.split(delimiter);
            }
        }
        return values;
    }
}
