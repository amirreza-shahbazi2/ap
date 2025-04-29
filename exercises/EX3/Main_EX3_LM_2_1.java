package exercises.EX3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_EX3_LM_2_1 {
    public static class BookLoan {
        private Book book;
        private Student student;
        private String loandate;
        private String returndate;

        public BookLoan(Book book, Student student, String loanDate, String returnDate) {
            this.book = book;
            this.student = student;
            this.loandate = loanDate;
            this.returndate = returnDate;
        }
        public String toCSV() {
            return String.join(",",
                    book.getName(),
                    book.getAuthor(),
                    String.valueOf(book.getPagecount()),
                    String.valueOf(book.getPublicyear()),
                    student.getFirstname(),
                    student.getLastname(),
                    student.getStudentid(),
                    student.getMajor(),
                    loandate,
                    returndate);
        }

        public static BookLoan fromCSV(String csvLine) {
            String[] parts = csvLine.split(",");
            Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            Student student = new Student(parts[4], parts[5], parts[6], parts[7]);
            return new BookLoan(book, student, parts[8], parts[9]);
        }

        @Override
        public String toString() {
            return student.getFirstname() + " " + student.getLastname() +
                    "bok: " + book.getName() +
                    "  loandate: " + loandate +
                    " returndate: " + returndate;
        }
    }

   public class LoanManager {

       public static void saveLoans(List<BookLoan> loans, String filename) {
           try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
               for (BookLoan loan : loans) {
                   writer.println(loan.toCSV());
               }
               System.out.println("saved successfully");
           } catch (IOException e) {
               System.err.println("eror");
           }
       }

       public static List<BookLoan> loadLoans(String filename) {
           List<BookLoan> loans = new ArrayList<>();
           try (Scanner scanner = new Scanner(new File(filename))) {
               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   loans.add(BookLoan.fromCSV(line));
               }
               System.out.println("loan loaded successfully");
           } catch (FileNotFoundException e) {
               System.err.println("eror ");
           }
           return loans;
       }

       public static void main(String[] args) {
           Book book1 = new Book("big java", "cay S.Horstmann", 1040, 2015);
           Book book2 = new Book("java programming", "john doe", 350, 2020);

           Student student1 = new Student("reza", "rezaei", "967543761", "computer science");
           Student student2 = new Student("ali", "shahbazi", "254859714", "electrical engineering");


           List<test.BookLoan> loans = new ArrayList<>();

           loans.add(new BookLoan(book1, student1, "1402/01/15", "1402/02/15"));
           loans.add(new BookLoan(book2, student2, "1402/01/20", "1402/02/20"));

           saveLoansToFile(loans, "loans.csv");

           List<bookLoan> loadedLoans = loadLoansFromFile("loans.csv");


           System.out.println("\nloan list");
           for (BookLoan loan : loadedLoans) {
               System.out.println(loan);
           }
       }
   }
}
