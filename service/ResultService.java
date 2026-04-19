package service;

import java.util.ArrayList;
import model.Result;
import util.FileHandler;

public class ResultService {

    ArrayList<Result> resultList = new ArrayList<>();
    String fileName = "result.txt"; // file to store results
    // Add result

    public void addResult(Result r) {
        resultList.add(r);
        saveToFile();
    }

    // Get all results
    public ArrayList<Result> getAllResults() {
        loadFromFile();
        return resultList;
    }

    // SAVE result list to file
    private void saveToFile() {
        ArrayList<String> lines = new ArrayList<>();
        for (Result r : resultList) {
            // Comma separated: studentId,subject,marks,grade
            lines.add(r.getStudentId() + "," + r.getSubject() + "," + r.getMarks() + "," + r.getGrade());
        }
        FileHandler.writeToFile(fileName, lines);
    }

    // LOAD result list from file
    private void loadFromFile() {
        resultList.clear();
        ArrayList<String> lines = FileHandler.readFromFile(fileName);
        for (String line : lines) {
            String[] parts = line.split(",");
            int studentId = Integer.parseInt(parts[0]);
            String subject = parts[1];
            int marks = Integer.parseInt(parts[2]);
            String grade = parts[3];

            resultList.add(new Result(studentId, subject, marks, grade));
        }
    }
}
