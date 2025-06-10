package ap.exercises.EX7;
import ap.projects.*;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryPersistencewithJson {

    private static final String BOOKS_FILE = "books.json";
    private static final String STUDENTS_FILE = "students.json";
    private static final String LIBRARIANS_FILE = "librarians.json";
    private static final String ADMIN_FILE = "admin.json";

    private static final Gson gson = new Gson();

    public void saveBook(Book book) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(BOOKS_FILE, true))) {
            pw.println(gson.toJson(book));
        }
    }

    public List<Book> loadBooks() throws IOException {
        List<Book> books = new ArrayList<>();
        Files.lines(Paths.get(BOOKS_FILE))
                .map(line -> gson.fromJson(line, Book.class))
                .forEach(books::add);
        return books;
    }

    public void saveStudent(Student student) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(STUDENTS_FILE, true))) {
            pw.println(gson.toJson(student));
        }
    }

    public List<Student> loadStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        Files.lines(Paths.get(STUDENTS_FILE))
                .map(line -> gson.fromJson(line, Student.class))
                .forEach(students::add);
        return students;
    }

    public void saveLibrarian(Librarian librarian) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(LIBRARIANS_FILE, true))) {
            pw.println(gson.toJson(librarian));
        }
    }

    public List<Librarian> loadLibrarians() throws IOException {
        List<Librarian> librarians = new ArrayList<>();
        Files.lines(Paths.get(LIBRARIANS_FILE))
                .map(line -> gson.fromJson(line, Librarian.class))
                .forEach(librarians::add);
        return librarians;
    }

    public void saveAdmin(Manager manager) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ADMIN_FILE))) {
            pw.println(gson.toJson(manager));
        }
    }

    public Manager loadAdmin(String adminFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line = br.readLine();
            if (line != null) {
                return gson.fromJson(line, Manager.class);
            }
        }
        return null;
    }

}
