package ap.projects.finalproject;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LibraryPersistence implements Persistence {
    private final String libaryansFile = "libraryans22.txt";
    private final String booksFile = "books22.txt";
    private final String studentsFile = "students22.txt";
    private final String loansFile = "loans22.txt";


    public void saveLibrarianToFile(List<Librarian> librarians) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(libaryansFile))) {
            for (Librarian l : librarians) {
                pw.println(l.getUsername() + "," + l.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Librarian> loadLibrariansFromFile() {
        List<Librarian> librarians = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(libaryansFile))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                librarians.add(new Librarian(data[0], data[1]));
            }
        } catch (IOException e) {
            System.out.println("no such file");
        }
        return librarians;
    }

    public  void saveBooks(List<Book> books) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(booksFile))) {
            for (Book b : books) {
                pw.println(b.getName() + ";" + b.getAuthor() + ";" + b.getPublicyear() + ";" + b.getAddedByLibrarian());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Book> loadBooks() {
        List<Book> bookmids = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(booksFile))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                bookmids.add(new Book(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            }
        } catch (IOException e) {
            System.out.println("no such file");
        }
        return bookmids;
    }

    public  void saveStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(studentsFile))) {
            for (Student s : students) {
                pw.println(s.getName() + ";" + s.getStudentId() + ";" + s.getUsername() + ";" + s.getPassword()+";"+s.isActive());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(studentsFile))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data.length >= 4) {
                    Student s = new Student(data[0], data[1], data[2], data[3]);
                    if (data.length >= 5) {
                        s.setActive(Boolean.parseBoolean(data[4]));
                    }

                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("no such file");
        }
        return students;
    }

    public void saveLoans(List<Loan> loans) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(loansFile))) {
            for (Loan l : loans) {
                pw.println(
                        l.getBook1().getName() + ";" + l.getBook1().getAuthor()
                                + ";" + l.getBook1().getPublicyear() + ";" + l.getBook1().getAddedByLibrarian() + ";" +
                                l.getStudent1().getName() + ";" + l.getStudent1().getStudentId() + ";" +
                                l.getStudent1().getUsername() + ";" + l.getStudent1().getPassword() + ";" +
                                l.getStartDate() + ";" + l.getEndDate()+";"+
                                (l.getReturnDate() != null ? l.getReturnDate() : "null") + ";" +
                                (l.getReturnedByLibrarian() != null ? l.getReturnedByLibrarian() : "null")+";"+
                                (l.getApprovedByLibrarian() != null? l.getApprovedByLibrarian() : "null")+";"+
                                (l.isApproved() ==true ?true:false)
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Loan> loadLoans() {
        List<Loan> loans = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(loansFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }{
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                Book b = new Book(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                Student s = new Student(data[4], data[5], data[6], data[7]);
                LocalDate sd = LocalDate.parse(data[8]);
                LocalDate ed = LocalDate.parse(data[9]);
                Loan l = new Loan(b, s, sd, ed);
//                loans.add(new Loan1(b, s, sd, ed));
                if (data.length>10 && !Objects.equals(data[10], "null")) {
                    l.setReturnDate(LocalDate.parse(data[10]));
                }
                if (data.length>11 && !Objects.equals(data[11], "null")) {
                    l.setReturnedByLibrarian(data[11]);
                }
                if (data.length>12 && !Objects.equals(data[12], "null")) {
                    l.setApprovedByLibrarian(data[12]);
                }
                if (data.length>13) {
                    l.setApproved(Boolean.parseBoolean(data[13]));
                }
                loans.add(l);}
        }return loans;
    }

}

