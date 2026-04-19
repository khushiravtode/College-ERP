package util;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    // Write data to file
    public static void writeToFile(String filename, ArrayList<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read data from file
    public static ArrayList<String> readFromFile(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            // File does not exist yet
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
