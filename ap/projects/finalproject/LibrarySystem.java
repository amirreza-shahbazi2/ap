package ap.projects.finalproject;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class LibrarySystem implements Serializable {
    Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private Manager manager;
    LibraryPersistence libraryPersistence = new LibraryPersistence();

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student newStudent = new Student(name, studentId, username, password);
        students.add(newStudent);
        System.out.println("Student registration completed successfully.");
        libraryPersistence.saveStudents(students);
    }

    public Student authenticateStudent(String username, String password) {
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

        for (Student student : students) {
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
        for (Book b : books) {
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

    public Student searchStudentbyID(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void requestLoan(Student student) {
        if (!student.isActive()) {
            System.out.println("This student is not active");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getName());
        }
        System.out.println("Enter number of the book you want to request loan : ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice < 0 || choice >= books.size()) {
            System.out.println("Invalid number .");
            return;
        }

        Book thebook = books.get(choice);
        if (!thebook.isAvailable()) {
            System.out.println("book is not available ");
            return;
        }
        LocalDate today = LocalDate.now();
        System.out.println("today id: " + today);

        System.out.println("Enter start date (YYYY-MM-DD) : ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter end date (YYYY-MM-DD) : ");
        LocalDate end = LocalDate.parse(scanner.nextLine());

        Loan request = new Loan(thebook, student, start, end);
        loans.add(request);
        System.out.println("Your request has been registered and is under rewie .");
        libraryPersistence.saveLoans(loans);

    }

    public List<Loan> getLoansRequest() {
        return loans;
    }

    public void searchBookwithtitle() {
        System.out.println("enter the title of the book");
        String title = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
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
            List<Loan> activloans = new ArrayList<>();
            for (Loan loan : loans) {
                if (loan.isApproved() && loan.getReturnDate() == null) {
                    activloans.add(loan);
                }
            }
            System.out.println("count of books which borrowed: " + activloans.size());
            for (Loan l : activloans) {
                System.out.println("book name: " + l.getBook1().getName() + " (student: " + l.getStudent1().getName() + ")");

            }
        }
    }

    public Librarian loginLibrarian() {
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        for (Librarian l : librarians) {
            if (l.getUsername().equals(username) && l.getPassword().equals(password)) {
                System.out.println(" librarian" + l.getUsername() + "entered in successfully ");
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
        for (Librarian l : librarians) {
            if (l.getPassword().equals(password)) {
                l.setPassword(newPassword);
                found = true;
                System.out.println("your password has been changed ");

                libraryPersistence.saveLibrarianToFile(librarians);
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
        for (Book b : books) {
            if (b.getName().equals(name) && b.getAuthor().equals(author)) {
                System.out.println("book already exists");
                return;
            }
        }
        System.out.println("Enter the year of publication of the book: ");
        int year = Integer.parseInt(scanner.nextLine());
        Book newbook = new Book(name, author, year, loginLibrarian().getUsername());
        books.add(newbook);
        System.out.println("book added successfully");

        libraryPersistence.saveBooks(books);
    }

    public void searchandEditbookInfo() {
        System.out.println("enter the name of the book: ");
        String name = scanner.nextLine();
        Book theboook = null;
        boolean found = false;
        for (Book b : books) {
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
        libraryPersistence.saveBooks(books);

        System.out.println("book edited successfully");

    }

    public void approveLoan() {
        LocalDate today = LocalDate.now();
        List<Loan> result = new ArrayList<>();

        for (Loan l : loans) {
            if (!l.isApproved() && l.getReturnDate() == null) {
                if (l.getStartDate().equals(today) || l.getStartDate().equals(today.minusDays(1))) {
                    result.add(l);
                }

            }
        }
        if (result.isEmpty()) {
            System.out.println("No book request loan.");
        }
        for (Loan l : result) {
            l.setApproved(true);
            l.getBook1().setAvailable(false);
            System.out.println("approved " + l.toString());
            l.setApprovedByLibrarian(loginLibrarian().getUsername());

        }
        System.out.println("all loan requests approved ");
        setLoans(loans);

    }

    public void studentLoanHistory() {
        System.out.println("enter the username of the student: ");
        String username = scanner.nextLine();
        List<Loan> result = new ArrayList<>();

        for (Loan s : loans) {
            if (s.getStudent1().getUsername().equals(username)) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No history found");
            return;
        }
        int total = result.size();
        int delayed = 0;
        int notReturned = 0;
        System.out.println("*** Student loan History : " + username + " ***");

        for (Loan l : result) {
            System.out.println(l.toString());
            if (l.isApproved() && l.getReturnDate() == null) {
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

    public void toggleStudentStatus() {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(i + 1 + ". " + s.getUsername() + " | is active: " + s.isActive());

        }
        System.out.println("enter the number of option you want to toggle (0 to exit): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 0) {
            return;
        }
        if (choice < 1 || choice > students.size()) {
            System.out.println("Invalid choice . ");
            return;
        }
        Student student = students.get(choice - 1);
        student.setActive(!student.isActive());

        libraryPersistence.saveStudents(students);
        System.out.println("student status changed successfully ");


    }

    public void receiveReturnBook() {
        System.out.println("enter students username: ");
        String username = scanner.nextLine();
        System.out.println("enter title of book student want to return: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (Loan l : loans) {
            if (l.getStudent1().getUsername().equals(username)) {
                if (l.getBook1().getName().equals(title) && l.getReturnDate() == null && l.isApproved()) {
                    l.setReturnDate(LocalDate.now());
                    l.getBook1().setAvailable(true);
                    l.setReturnedByLibrarian(loginLibrarian().getUsername());

                    libraryPersistence.saveLoans(loans);

                    found = true;
                    System.out.println("student returned successfully");
                }
            }
        }
        if (!found) {
            System.out.println("no such a student or book found");
        }
    }

    public void addLibrarian() {

        System.out.println("enter librarian's username: ");
        String username = scanner.nextLine();
        System.out.println("enter librarian's password: ");
        String password = scanner.nextLine();

        for (Librarian l : librarians) {
            if (l.getUsername().equals(username) && l.getPassword().equals(password)) {
                System.out.println("librarian's  already exists");
                return;
            }
        }
        Librarian librarian = new Librarian(username, password);
        librarians.add(librarian);
        System.out.println("librarians added successfully");
        libraryPersistence.saveLibrarianToFile(librarians);
    }

    public void viewLibrarianStatus() {
        int added = 0;
        int returned = 0;
        int approved = 0;
        Librarian lib = null;
        System.out.println("enter librarian username: ");
        String username = scanner.nextLine();
        for (Librarian l : librarians) {
            if (l.getUsername().equals(username)) {
                lib = l;
            }
        }
        if (lib == null) {
            System.out.println("librarian user notfound");
            return;
        }
        for (Book b : books) {
            if (b.getAddedByLibrarian() != null && b.getAddedByLibrarian().equals(username)) {
                added++;
            }
        }
        for (Loan l : loans) {
            if (l.getApprovedByLibrarian() != null && l.getApprovedByLibrarian().equals(username)) {
                approved++;
            }
            if (l.getReturnedByLibrarian() != null && l.getReturnedByLibrarian().equals(username)) {
                returned++;
            }
        }
        System.out.println("librarian  " + username + "  report: ");
        System.out.println("book added: " + added);
        System.out.println("approved loans: " + approved);
        System.out.println("returned loans: " + returned);

    }

    public void viewLoanStatistics() {
        int totalLoans = loans.size();
        int totalApproved = 0;
        int totalReturned = 0;
        long totalDays = 0;
        int d = 0;
        for (Loan l : loans) {
            if (l.isApproved() || l.getReturnDate() != null) {
                totalApproved++;
            }
            if (l.getReturnDate() != null) {
                totalReturned++;

                long diff = l.getReturnDate().getDayOfYear() - l.getStartDate().getDayOfYear();
                totalDays += diff;
            }
        }

        double avg = (totalReturned > 0) ? (double) totalDays / totalReturned : 0;
        System.out.println("total loans: " + totalLoans);
        System.out.println("total approved loans: " + totalApproved);
        System.out.printf(" \n Avg days of loan : %.2f%n", avg);

    }

    public void viewStudentStatics() {
        if (students == null) {
            System.out.println("no students found");
            return;
        }
        Map<Student, Long> delayedCountMap = new HashMap<>();

        for (Student s : students) {
            long totalloans = 0;
            for (Loan l : loans) {
                if (l.getStudent1().getUsername().equals(s.getUsername())) {
                    totalloans++;

                }
            }

            long totalnotreturned = loans.stream().filter(ab -> ab.getStudent1().getUsername()
                            .equals(s.getUsername()) && ab.isApproved() && ab.getReturnDate() == null)
                    .count();
            long tataldelayed = loans.stream().filter(ab -> ab.getStudent1().getUsername()
                            .equals(s.getUsername()) && ab.isApproved() && ab.getReturnDate() != null
                            && ab.getReturnDate().isAfter(ab.getEndDate()))
                    .count();
            delayedCountMap.put(s, tataldelayed);
            System.out.println("student: " + s.getUsername());

            System.out.println("total loans: " + totalloans);
            System.out.println("total not returned: " + totalnotreturned);
            System.out.println("total deleyed loans: " + tataldelayed);
            System.out.println("--------------------------------");

        }
        System.out.println("Top 10 Delayed Returns students ");
        delayedCountMap.entrySet().stream()
                .sorted(Map.Entry.<Student, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> {
                    Student st = entry.getKey();
                    long count = entry.getValue();
                    System.out.println("student: " + st.getUsername() + " (Delayed Returns : " + count + ")");
                });

    }
}