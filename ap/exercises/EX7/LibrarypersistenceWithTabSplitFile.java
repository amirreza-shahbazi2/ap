package ap.exercises.EX7;

import ap.projects.*;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class LibrarypersistenceWithTabSplitFile {

    private static final String BOOKS_FILE = "books.txt";
    private static final String STUDENTS_FILE = "students.txt";
    private static final String LIBRARIANS_FILE = "librarians.txt";
    private static final String ADMIN_FILE = "admin.txt";

    public static List<Book> loadBooks() throws IOException {
        return Files.lines(Paths.get(BOOKS_FILE))
                .map(line -> line.split("\t"))
                .map(data -> new Book(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])))
                .toList();
    }

    public static void saveBooks(List<Book> books) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKS_FILE))) {
            for (Book b : books) {
                pw.println(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPagecount() + "\t" + b.getPublicyear());
            }
        }
    }

    public static List<Student> loadStudents() throws IOException {
        return Files.lines(Paths.get(STUDENTS_FILE))
                .map(line -> line.split("\t"))
                .map(data -> {
                    Student s = new Student(data[0], data[1], data[2], data[3]);
                    s.setJoindate(LocalDate.parse(data[4]));
                    return s;
                })
                .toList();
    }

    public static void saveStudents(List<Student> students) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENTS_FILE))) {
            for (Student s : students) {
                pw.println(s.getFirstname() + "\t" + s.getLastname() + "\t" + s.getStudentid()
                        + "\t" + s.getMajor() + "\t" + s.getJoindate());
            }
        }
    }

    public static List<Librarian> loadLibrarians() throws IOException {
        return Files.lines(Paths.get(LIBRARIANS_FILE))
                .map(line -> line.split("\t"))
                .map(data -> new Librarian(data[0], data[1], data[2]))
                .toList();
    }

    public static void saveLibrarians(List<Librarian> librarians) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(LIBRARIANS_FILE))) {
            for (Librarian l : librarians) {
                pw.println(l.getFirstname() + "\t" + l.getLastname() + "\t" + l.getEmployeeID());
            }
        }
    }

    public static Manager loadAdmin() throws IOException {
        return Files.lines(Paths.get(ADMIN_FILE))
                .findFirst()
                .map(line -> line.split("\t"))
                .map(data -> new Manager(data[0], data[1], data[2]))
                .orElse(null);
    }

    public static void saveAdmin(Manager manager) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ADMIN_FILE))) {
            pw.println(manager.getFirstname() + "\t" + manager.getLastname() + "\t" + manager.getEducational_level());
        }
    }
}
