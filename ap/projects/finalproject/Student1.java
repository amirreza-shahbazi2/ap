package ap.projects.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Student1 extends User {
    String name;
    String studentId;

    private List<Loan1> loan1s =new ArrayList<Loan1>();


    public Student1(String name, String studentId, String username, String password) {
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
    public List<Loan1> getLoan1s() {
        return loan1s;
    }

    public String toString() {
        return "Name: " + this.getName() +
                " | Student ID: " + this.getStudentId() +
                " | Username: " + this.getUsername()+
                " | active: "+ this.isActive();
    }
}
