package exercises.EX3;
import java.io.*;

public class Main_EX3_LM_1_2_A {
    public static void main(String[] args) {
        Book[] books = {
                new Book("book1", "author1", 100, 2001),
                new Book("book2", "author2", 200, 2002),
                new Book("book3", "author3", 300, 2003),
                new Book("book4", "author4", 400, 2004),
        };
        Student[] students = {
                new Student("firstname1", "lastname1", "123456783", "computer science"),
                new Student("firstname2", "lastname2", "123456782", "computer science"),
                new Student("firstname3", "lastname3", "123456785", "electrical engineering"),
                new Student("firstname4", "lastname4", "123456789", "electrical engineering"),
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

