package service;

import java.util.ArrayList;
import model.Faculty;
import util.FileHandler;

public class FacultyService {

    private ArrayList<Faculty> facultyList = new ArrayList<>();
    String fileName = "faculty.txt";

    // ADD
    public void addFaculty(Faculty f) {
        loadFromFile();
        facultyList.add(f);
        saveToFile();
    }

    // UPDATE
    public void updateFaculty(Faculty f) {
        loadFromFile();
        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getId() == f.getId()) {
                facultyList.set(i, f);
                break;
            }
        }
        saveToFile();
    }

    // DELETE
    public void deleteFaculty(int id) {
        loadFromFile();

        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getId() == id) {
                facultyList.remove(i);
                break;
            }

        }
        saveToFile();
    }

    // DISPLAY
    public ArrayList<Faculty> getAllFaculty() {

        loadFromFile();
        return facultyList;
    }
    // SAVE Faculty list to file

    private void saveToFile() {
        ArrayList<String> lines = new ArrayList<>();
        for (Faculty f : facultyList) {
            // Comma separated values
            lines.add(f.getId() + "," + f.getName() + "," + f.getDepartment() + "," + f.getSubject() + "," + f.getEmail());
        }
        FileHandler.writeToFile(fileName, lines);
    }

    // LOAD Faculty list from file
    private void loadFromFile() {
        facultyList.clear();
        ArrayList<String> lines = FileHandler.readFromFile(fileName);
        for (String line : lines) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String department = parts[2];
            String subject = parts[3];
            String email = parts[4];

            facultyList.add(new Faculty(id, name, department, subject, email));
        }
    }

}
