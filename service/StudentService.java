package service;

import java.util.ArrayList;
import model.Student;
import util.FileHandler;

public class StudentService {

    ArrayList<Student> studentList = new ArrayList<>();
    String fileName = "students.txt";

    public ArrayList<Student> getAllStudents() {
        loadFromFile();
        return studentList;
    }

    private void saveToFile() {
        ArrayList<String> lines = new ArrayList<>();
        for (Student s : studentList) {
            lines.add(s.getId() + "," + s.getName() + "," + s.getBranch() + "," + s.getYear() + "," + s.getEmail());
        }
        FileHandler.writeToFile(fileName, lines);
    }

    private void loadFromFile() {
        studentList.clear();
        ArrayList<String> lines = FileHandler.readFromFile(fileName);
        for (String line : lines) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String branch = parts[2];
            String year = parts[3];
            String email = parts[4];

            studentList.add(new Student(id, name, branch, year, email));
        }
    }

    public void addStudent(Student s) {
        studentList.add(s);
        saveToFile();
    }

    // UPDATE
    public void updateStudent(Student s) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == s.getId()) {
                studentList.set(i, s);
                break;
            }
        }
        saveToFile();
    }

    // DELETE
    public void deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                break;
            }
        }
        saveToFile();
    }

    // SEARCH
    public Student searchStudent(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}
