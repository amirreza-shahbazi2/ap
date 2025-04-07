package exercises.EX3;
import java.io.*;

public class Main_EX3_LM_1_2_B {
    public static void main(String[] args) {
        Book[] books = null;
        Student[] students = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("books.dat"))) {
            books = (Book[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (Student[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (books != null) {
            System.out.println("books loaded:");
            for (Book book : books) {
                System.out.println(book.getName() + " by " + book.getAuthor());
            }
        }

        if (students != null) {
            System.out.println("students loaded:");
            for (Student student : students) {
                System.out.println(student.getFirstname() + " " + student.getLastname());
            }
        }
    }
}