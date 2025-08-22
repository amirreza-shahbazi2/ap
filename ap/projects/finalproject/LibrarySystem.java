package ap.projects.finalproject;

import ap.projects.*;
import ap.projects.Librarian;
import ap.projects.Loan;
import ap.projects.Manager;
import ap.projects.Student;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<User> users=new ArrayList<>();
    private List<Book1> books=new ArrayList<>();
    private List<Student1> students=new ArrayList<>();
    private List<Librarian1> librarians=new ArrayList<>();
    private List<Loan1> loans=new ArrayList<>();
    private Manager manager1;


    public void registerbook(String name,String author,int year){
        books.add(new Book1(name,author,year));
    }

//    public User login(String username,String password){
//        for(Student1 s:students){
//            if(s.getUsername().equals(username) && s.getPassword().equals(password)){
//                return s;
//            }
//        }
//        return null;
//    }
    public void registerStudent(String name, String studentId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student1 newStudent = new Student1(name, studentId, username, password);
        students.add(newStudent);
        System.out.println("Student registration completed successfully.");
    }

    public Student1 authenticateStudent(String username, String password) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void displayStudents() {
        System.out.println("\n--- List of Registered Students ---");

        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }

        for (Student1 student : students) {
            System.out.println(student.toString());
        }
    }


    private boolean isUsernameTaken(String username) {
        return students.stream().anyMatch(s -> s.getUsername().equals(username));
    }

    public int getStudentCount() {
        return students.size();
    }
}

