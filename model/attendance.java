/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Attendance {

    int studentId;
    String subject;
    Date date;
    String status; // "Present" or "Absent"

    public Attendance(int studentId, String subject, Date date, String status) {
        this.studentId = studentId;
        this.subject = subject;
        this.date = date;
        this.status = status;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
