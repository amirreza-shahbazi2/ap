package exercises.EX3;
import java.io.*;
public class Main_EX3_LM_1_2_C {
    public static void saveBooks(Book[] books, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveStudents(Student[] students, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book[] loadBooks(String filename) {
        Book[] books = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            books = (Book[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
    public static Student[] loadStudents(String filename) {
        Student[] students = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            students = (Student[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        Book[] books = new Book[4];
        saveBooks(books, "books.dat");
        Student[] students = new Student[3];
        saveStudents(students, "students.dat");

        Book[] loadedBooks = loadBooks("books.dat");
        Student[] loadedStudents = loadStudents("students.dat");
    }
}
