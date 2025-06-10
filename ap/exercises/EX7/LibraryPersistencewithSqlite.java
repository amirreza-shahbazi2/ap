package ap.exercises.EX7;
import ap.projects.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryPersistencewithSqlite {

    private static final String BOOKS_FILE = "jdbc:sqlite:booksSqlite.db";
    private static final String STUDENTS_FILE = "jdbc:sqlite:studentsSqlite.db";
    private static final String LIBRARIANS_FILE = "jdbc:sqlite:librariansSqlite.db";
    private static final String ADMIN_FILE = "jdbc:sqlite:adminSqlite.db";


    public void saveBooks(List<Book> books) {
        try (Connection connection = DriverManager.getConnection(BOOKS_FILE);
             Statement statement = connection.createStatement()) {
            statement.setQueryTimeout(30);


            for (Book b : books) {
                String query = "INSERT INTO books (name, author, pagecount, publicyear) VALUES ('" +
                        b.getName() + "', '" + b.getAuthor() + "', " + b.getPagecount() + ", " + b.getPublicyear() + ")";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(BOOKS_FILE);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM books")) {
            statement.setQueryTimeout(30);
            while (rs.next()) {
                books.add(new Book(rs.getString("name"), rs.getString("author"),
                        rs.getInt("pagecount"), rs.getInt("publicyear")));
            }
        } catch (SQLException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        return books;
    }

    public void saveStudents(List<Student> students) {
        try (Connection connection = DriverManager.getConnection(STUDENTS_FILE);
             Statement statement = connection.createStatement()) {
            statement.setQueryTimeout(30);

            for (Student s : students) {
                String query = "INSERT INTO students (firstname, lastname, studentid, major, joindate) VALUES ('" +
                        s.getFirstname() + "', '" + s.getLastname() + "', '" + s.getStudentid() + "', '" +
                        s.getMajor() + "', '" + s.getJoindate() + "')";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(STUDENTS_FILE);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM students")) {
            statement.setQueryTimeout(30);
            while (rs.next()) {
                Student s = new Student(rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("studentid"), rs.getString("major"));
                s.setJoindate(LocalDate.parse(rs.getString("joindate")));
                students.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return students;
    }

    public void saveLibrarians(List<Librarian> librarians) {
        try (Connection connection = DriverManager.getConnection(LIBRARIANS_FILE);
             Statement statement = connection.createStatement()) {
            statement.setQueryTimeout(30);

            for (Librarian l : librarians) {
                String query = "INSERT INTO librarians (firstname, lastname, employeeid) VALUES ('" +
                        l.getFirstname() + "', '" + l.getLastname() + "', '" + l.getEmployeeID() + "')";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public List<Librarian> loadLibrarians() {
        List<Librarian> librarians = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(LIBRARIANS_FILE);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM librarians")) {
            statement.setQueryTimeout(30);
            while (rs.next()) {
                librarians.add(new Librarian(rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("employeeid")));
            }
        } catch (SQLException e) {
            System.out.println("Error loading librarians: " + e.getMessage());
        }
        return librarians;
    }

    public void saveAdmin(Manager manager) {
        try (Connection connection = DriverManager.getConnection(ADMIN_FILE);
             Statement statement = connection.createStatement()) {
            statement.setQueryTimeout(30);

            String query = "INSERT INTO admin (firstname, lastname, educational_level) VALUES ('" +
                    manager.getFirstname() + "', '" + manager.getLastname() + "', '" +
                    manager.getEducational_level() + "')";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public Manager loadAdmin() {
        try (Connection connection = DriverManager.getConnection(ADMIN_FILE);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM admin")) {
            statement.setQueryTimeout(30);
            if (rs.next()) {
                return new Manager(rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("educational_level"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading admin: " + e.getMessage());
        }
        return null;
    }
}





