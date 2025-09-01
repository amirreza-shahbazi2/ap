package ap.projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem implements Serializable {
    Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    private List<Book1> books = new ArrayList<>();
    private List<Student1> students = new ArrayList<>();
    private List<Librarian1> librarians = new ArrayList<>();
    private List<Loan1> loans = new ArrayList<>();
    private Manager1 manager1;

//
//    public void registerbook(String name, String author, int year) {
//        books.add(new Book1(name, author, year));
//    }

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
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password)
                        && s.isActive())
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

    public void searchBook() {
        System.out.println("if you want leave a field empty books wont be filtered with that field.");
        System.out.println("Enter the title of book (or press Enter to skip) ");
        String title = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter author name (or press Enter to skip) : ");
        String author = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter year of publication (or press Enter to skip) : ");
        String Publicyear = scanner.nextLine().trim();

        boolean found = false;
        for (Book1 b : books) {
            boolean synk = false;
            if (!title.isEmpty() && b.getName().toLowerCase().contains(title)) {
                synk = true;
            }
            if (!author.isEmpty() && b.getAuthor().toLowerCase().contains(author)) {
                synk = true;
            }
            if (!Publicyear.isEmpty()) {
                int year = Integer.parseInt(Publicyear);
                if (b.getPublicyear() == year) {
                    synk = true;
                }
            }
            if (synk) {
                System.out.println(b.toString());
                found = true;

            }

        }
        if (!found) {
            System.out.println("No such book found.");
        }
    }

    public Student1 searchStudentbyID(String studentId) {
        for (Student1 student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void requestLoan(Student1 student) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getName());
        }
        System.out.println("Enter number of the book you want to request loan : ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice < 0 || choice >= books.size()) {
            System.out.println("Invalid number .");
            return;
        }

        Book1 thebook = books.get(choice);
        if (!thebook.isAvailable()) {
            System.out.println("book is not available ");
            return;
        }

        System.out.println("Enter start date (YYYY-MM-DD) : ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter end date (YYYY-MM-DD) : ");
        LocalDate end = LocalDate.parse(scanner.nextLine());

        Loan1 request = new Loan1(thebook, student, start, end);
        loans.add(request);
        System.out.println("Your request has been registered and is under rewie .");

    }
    public List<Loan1> getLoansRequest() {
        return loans;
    }

    public void searchBookwithtitle() {
        System.out.println("enter the title of the book");
        String title = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book1 b : books) {
            if (b.getName().toLowerCase().equals(title)) {
                System.out.println(b.toStringGuest());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No such book found.");
        }
    }

    public void wiewStatisticalInfo() {
        System.out.println("count of all students: " + students.size());
        System.out.println("count of all books: " + books.size());
        System.out.println("count of all loans: " + loans.size());
        if (loans.isEmpty()) {
            System.out.println("No book borrowed.");
        } else {
            List<Loan1> activloans = new ArrayList<>();
            for (Loan1 loan : loans) {
                if (loan.isApproved() && loan.getReturnDate() == null) {
                    activloans.add(loan);
                }
            }
            System.out.println("count of books which borrowed: " + activloans.size());
            for (Loan1 l : activloans) {
                System.out.println(l.getBook1().getName() + "( student: " + l.getStudent1().getName());

            }
        }
    }

    public Librarian1 loginLibrarian() {
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        for (Librarian1 l : librarians) {
            if (l.getUsername().equals(username) && l.getPassword().equals(password)) {
                System.out.println(" librarian" + l.getNameLibrarian() + "entered in successfully ");
                return l;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public void changePassword() {
        System.out.println("enter your current password: ");
        String password = scanner.nextLine();
        System.out.println("Enter new password : ");
        String newPassword = scanner.nextLine();
        boolean found = false;
        for (Librarian1 l : librarians) {
            if (l.getPassword().equals(password)) {
                l.setPassword(newPassword);
                found = true;
                System.out.println("your password has been changed ");
                savelibrarian();
            }
        }
        if (!found) {
            System.out.println("your current password does not match ");
        }
    }

    public void addanewabook() {
        System.out.println("enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.println("enter the author of the book: ");
        String author = scanner.nextLine();
       for (Book1 b : books) {
           if (b.getName().equals(name)&& b.getAuthor().equals(author)) {
               System.out.println("book already exists");
               return;
           }
       }
        System.out.println("Enter the year of publication of the book: ");
        int year = Integer.parseInt(scanner.nextLine());
        Book1 newbook = new Book1(name, author, year);
        books.add(newbook);
        System.out.println("book added successfully");
        savebook();
    }

    public void searchandEditbookInfo() {
        System.out.println("enter the name of the book: ");
        String name = scanner.nextLine();
        Book1 theboook = null;
        boolean found = false;
        for (Book1 b : books) {
            if (b.getName().equals(name)) {
                theboook = b;
                System.out.println(b.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found");
            return;
        }
        System.out.println("enter the number of option you want to edit: ");
        System.out.println("1. book name");
        System.out.println("2. book author");
        System.out.println("3. book year");
        System.out.println("4.return");
        int opt = Integer.parseInt(scanner.nextLine());
        switch (opt) {
            case 1:
                System.out.println("enter new name of the book: ");
                String newName = scanner.nextLine();
                theboook.setName(newName);
                break;
            case 2:
                System.out.println("enter new author of the book: ");
                String newAuthor = scanner.nextLine();
                theboook.setAuthor(newAuthor);
                break;
            case 3:
                System.out.println("enter new year of publication of the book: ");
                int newYear = Integer.parseInt(scanner.nextLine());
                theboook.setPublicyear(newYear);
                break;
            case 4:

                return;
            default:
                System.out.println("Invalid option");
                break;
        }
        savebook();
        System.out.println("book edited successfully");

    }

    public void approveLoan() {
         LocalDate today = LocalDate.now();
         List<Loan1> result = new ArrayList<>();

         for (Loan1 l : loans) {
             if (!l.isApproved() && l.getReturnDate() == null) {
                 if (l.getStartDate().equals(today)&&l.getStartDate().equals(today.minusDays(1))) {
                  result.add(l);
                 }

             }
         }
         if (loans.isEmpty()) {
             System.out.println("No book request loan.");
         }
         for (Loan1 l : result) {
             l.setApprovedtrue();
             System.out.println(l.toString());
             l.getBook1().setAvailable(false);

         }
        System.out.println("all loan requests approved ");
         saveloans();
    }

    public void studentLoanHistory() {
        System.out.println("enter the username of the student: ");
        String username = scanner.nextLine();
        List<Loan1> result = new ArrayList<>();

        for (Student1 s : students) {
            if (s.getUsername().equals(username)) {
                result = s.getLoan1s();
            }
        }
        if(result.isEmpty()) {
            System.out.println("No history found");
            return;
        }
        int total=result.size();
        int delayed=0;
        int notReturned=0;
        System.out.println("*** Student loan History : " + username + " ***");

        for (Loan1 l : result) {
            System.out.println(l.toString());
            if (l.isApproved()&& l.getReturnDate() == null) {
                notReturned++;
            }
            if (l.getReturnDate() != null && l.getReturnDate().isAfter(l.getEndDate())) {
                delayed++;
            }
        }
        System.out.println("total loans : " + total);
        System.out.println("total delayed loans : " + delayed);
        System.out.println("total notReturned loans : " + notReturned);
    }
}


