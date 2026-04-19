
package model;

public class Result {

    private int studentId;
    private String subject;
    private int marks;
    private String grade;

    public Result(int studentId, String subject, int marks, String grade) {
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

}
