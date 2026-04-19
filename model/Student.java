
package model;

public class Student {

    private int id;
    private String name;
    private String branch;
    private String year;
    private String email;

    public Student(int id, String name, String branch, String year, String email) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.year = year;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

}
