package service;

import model.Attendance;
import java.util.ArrayList;
import util.FileHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendanceService {

    ArrayList<Attendance> attendanceList = new ArrayList<>();
    String fileName = "attendance.txt"; // file to store attendance data

    // Add Attendance
    public void markAttendance(Attendance a) {
        attendanceList.add(a);
        saveToFile();
    }

    // Get all attendance records
    public ArrayList<Attendance> getAllAttendance() {
        loadFromFile();
        return attendanceList;
    }

    // SAVE attendance list to file
    private void saveToFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<String> lines = new ArrayList<>();
        for (Attendance a : attendanceList) {
            String dateStr = sdf.format(a.getDate());
            // Comma separated values: studentId,subject,date,status
            lines.add(a.getStudentId() + ","
                    + a.getSubject() + ","
                    + dateStr + ","
                    + a.getStatus());
        }
        FileHandler.writeToFile(fileName, lines);
    }

    // LOAD attendance list from file
    private void loadFromFile() {
        attendanceList.clear();
        ArrayList<String> lines = FileHandler.readFromFile(fileName);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (String line : lines) {
                String[] parts = line.split(",");

                int studentId = Integer.parseInt(parts[0]);
                String subject = parts[1];

                String dateStr = parts[2];          // ✔ correct variable
                Date date = sdf.parse(dateStr);     // ✔ convert String → Date

                String status = parts[3];

                attendanceList.add(
                        new Attendance(studentId, subject, date, status)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
