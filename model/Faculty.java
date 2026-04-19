/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Faculty {

    private int id;
    private String name;
    private String department;
    private String subject;
    private String email;

    public Faculty(int id, String name, String department, String subject, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.subject = subject;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }
}
