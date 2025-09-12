package ap.projects.finalproject;

import java.io.Serializable;

public class Student extends User implements Serializable {
    String name;
    String studentId;

    public Student(String name, String studentId, String username, String password) {
        super(username, password);
        this.name = name;
        this.studentId = studentId;


    }
    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String toString() {
        return "Name: " + this.getName() +
                " | Student ID: " + this.getStudentId() +
                " | Username: " + this.getUsername()+
                " | active: "+ this.isActive();
    }
}
