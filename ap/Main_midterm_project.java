package ap;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main_midterm_project {
    public static class Book {
        private String name;
        private String author;
        private int pagecount;
        private int publicyear;
        private int borrowcount = 0;

        public Book(String name, String author, int pagecount, int publicyear) {
            this.name = name;
            this.author = author;
            this.pagecount = pagecount;
            this.publicyear = publicyear;

        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public int getPagecount() {
            return pagecount;
        }

        public int getPublicyear() {
            return publicyear;
        }

        public void increaseborrowcount() {
            borrowcount++;
        }

        public String toString() {
            return "name of the book:" + getName() + " | author of the book:" + getAuthor() +
                    " | page of book:" + getPagecount() + " | publication year:" + getPublicyear();
        }
    }

    public static class Student {
        private String firstname;
        private String lastname;
        private String studentid;
        private String major;
        private LocalDate joindate;
        private List<Loan> activeloans = new ArrayList<>();

        public Student(String firstname, String lastname, String studentid, String major) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.studentid = studentid;
            this.major = major;
            this.joindate = LocalDate.now();
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getStudentid() {
            return studentid;
        }

        public String getMajor() {
            return major;
        }

        public LocalDate getJoindate() {
            return joindate;
        }

        public void addLoan(Loan loan) {
            activeloans.add(loan);
        }

        public List<Loan> getActiveloansLoans() {
            return activeloans;
        }

        public void setJoindate(LocalDate joindate) {
            this.joindate = joindate;
        }

        public String toString() {
            return "first name of student:" + getFirstname() + " | lastname of student:" + getLastname() +
                    " | studentid of student:" + getStudentid() + " | major of student:" + getMajor() +
                    " | joindate of student:" + getJoindate();
        }
    }

    public static class Librarian {
        private String firstname;
        private String lastname;
        private String employeeID;

        public Librarian(String firstname, String lastname, String employeeID) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.employeeID = employeeID;
        }

        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmployeeID() {
            return employeeID;
        }

        public String toString() {
            return "librarian name:" + getFirstname() + " | librarian last name:" + getLastname() + " | employee ID:"
                    + getEmployeeID();
        }
    }

    public static class Loan {
        private Book book1;
        private Student student1;
        private Librarian loanlibrarian;
        private Librarian returnlibrarian;
        private LocalDate loan_Date;
        private LocalDate recivedate;
        private LocalDate actual_returndate;

        public Loan(Book book1, Student student1, Librarian loanlibrarian) {
            this.book1 = book1;
            this.student1 = student1;
            this.loanlibrarian = loanlibrarian;
            this.returnlibrarian = null;
            this.loan_Date = LocalDate.now();
            this.recivedate = loan_Date.plusDays(1);
            this.actual_returndate = null;
        }

        public void actualreturnbook(Librarian returnlibrarian) {
            this.actual_returndate = LocalDate.now();
            this.returnlibrarian = returnlibrarian;
        }

        public boolean isreturned() {
            return returnlibrarian != null;
        }

        public boolean islate() {
            return isreturned() && actual_returndate.isAfter(recivedate);
        }

        public Book getBook1() {
            return book1;
        }

        public Student getStudent1() {
            return student1;
        }

        public Librarian getLoanlibrarian() {
            return loanlibrarian;
        }

        public Librarian getReturnlibrarian() {
            return returnlibrarian;
        }

        public void setReturnlibrarian(Librarian returnlibrarian) {
            this.returnlibrarian = returnlibrarian;

        }

        public LocalDate getLoan_Date() {
            return loan_Date;
        }


        public LocalDate getRecivedate() {
            return recivedate;
        }

        public LocalDate getActual_returndate() {
            return actual_returndate;
        }

        public void setActual_returndate(LocalDate actual_returndate) {
            this.actual_returndate = actual_returndate;

        }


        public String toString() {
            return "name of book: " + book1.getName() + " student ID: " + student1.getStudentid() + " date of loan: " + getLoan_Date() +
                    " date of return; " + getRecivedate() + (isreturned() ? " actual date of return" + getActual_returndate()
                    : "have not returned yet");
        }
    }

    public static class Manager {
        private String firstname;
        private String lastname;
        private String educational_level;

        public Manager(String firstname, String lastname, String educational_level) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.educational_level = educational_level;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getEducational_level() {
            return educational_level;
        }

        public String toString() {
            return "name of Manager:" + getFirstname() + " | lastname of Manager:" + getLastname()
                    + " | educational_level of Manager:" + getEducational_level();
        }
    }

    public static class Library {
        private String libraryname;
        private List<Book> books1;
        private List<Student> students1;
        private List<Librarian> librarians1;
        private List<Loan> loans1;
        private Manager manager1;

        public Library(String libraryname) {
            this.libraryname = libraryname;

            this.books1 = new ArrayList<>();
            this.students1 = new ArrayList<>();
            this.librarians1 = new ArrayList<>();
            this.loans1 = new ArrayList<>();
        }

        public void setManager1(Manager manager1) {
            this.manager1 = manager1;
        }

        private Librarian getRandomLibrarian() {
            Random random = new Random();
            return librarians1.get(random.nextInt(librarians1.size()));
        }

        public void addBook(Book book) {
            books1.add(book);
        }

        public void addStudent(Student student) {
            students1.add(student);
        }

        public void addLibrarian(Librarian librarian) {
            librarians1.add(librarian);
        }

        public void addLoan(Loan loan) {
            loans1.add(loan);
        }

        public List<Book> searchbytitle(String title) {
            List<Book> result = new ArrayList<>();
            for (Book book : books1) {
                if (book.getName().toLowerCase().contains(title.toLowerCase())) {
                    result.add(book);
                }
            }
            return result;
        }

        public Student findStudent(String id) {
            for (Student student : students1) {
                if (student.getStudentid().equals(id)) {
                    return student;
                }
            }
            return null;
        }

        public Loan borrwbook(Book book, Student student) {
            Librarian librarian = getRandomLibrarian();
            Loan loan = new Loan(book, student, librarian);
            loans1.add(loan);
            student.addLoan(loan);
            return loan;

        }

        public void returnBook(Loan loan) {
            Librarian librarian = getRandomLibrarian();
            loan.actualreturnbook(librarian);
        }


        public List<Book> getBooks1() {
            return books1;
        }

        public void setBooks1(List<Book> books1) {
            this.books1 = books1;
        }

        public List<Student> getStudents1() {
            return students1;
        }

        public void setStudents1(List<Student> students1) {
            this.students1 = students1;
        }

        public List<Librarian> getLibrarians1() {
            return librarians1;
        }

        public void setLibrarians1(List<Librarian> librarians1) {
            this.librarians1 = librarians1;
        }

        public List<Loan> getLoans1() {
            return loans1;
        }

        public void setLoans1(List<Loan> loans1) {
            this.loans1 = loans1;
        }

        public Manager getManager1() {
            return manager1;
        }

        public void setmanager(Manager manager1) {
            this.manager1 = manager1;
        }

        public List<Loan> getlateloans() {
            List<Loan> result = new ArrayList<>();
            for (Loan loan : loans1) {
                if (loan.isreturned() && loan.getActual_returndate().isAfter(loan.getRecivedate())) {
                    result.add(loan);
                }
            }
            return result;
        }

        public void loanperlibrarian() {
            for (Librarian librarian : librarians1) {

                int lendcount = 0;
                int receivedcount = 0;
                for (Loan loan : loans1) {
                    if (loan.getLoanlibrarian() != null && loan.getLoanlibrarian().getEmployeeID().equals(librarian.getEmployeeID())) {
                        lendcount++;
                    }
                    if (loan.getReturnlibrarian() != null && loan.getReturnlibrarian().getEmployeeID().equals(librarian.getEmployeeID())) {
                        receivedcount++;
                    }

                    System.out.println("linrarian name: " + librarian.getFirstname() + " " + librarian.getLastname() + " |lend count" + lendcount +
                            " |received count" + receivedcount);
                }

            }
        }

        public List<Book> gettop10borrowedbooks() {
            List<Book> result = new ArrayList<>();
            List<Book> allbooks = getBooks1();
            List<Loan> loans = getLoans1();
            class bookcount {
                Book book;
                int count;

                public bookcount(Book book, int count) {
                    this.book = book;
                    this.count = count;
                }
            }
            List<bookcount> bookcounts = new ArrayList<>();
            for (Book book : allbooks) {
                int c = 0;
                for (Loan loan : loans) {
                    if (loan.getBook1().equals(book) && loan.getLoan_Date()
                            .isAfter(LocalDate.now().minusYears(1))) {
                        c++;
                    }

                }
                if (c > 0) {
                    bookcounts.add(new bookcount(book, c));
                }
            }
            for (int i = 0; i < bookcounts.size(); i++) {
                for (int j = i + 1; j < bookcounts.size(); j++) {
                    if (bookcounts.get(j).count > bookcounts.get(i).count) {
                        bookcount temp = bookcounts.get(i);
                        bookcounts.set(i, bookcounts.get(j));
                        bookcounts.set(j, temp);
                    }
                }
            }
            for (int i = 0; i < Math.min(10, bookcounts.size()); i++) {
                result.add(bookcounts.get(i).book);
            }

            return result;
        }

    }

    public static class LibraryPersistence {


        private static final String BOOKS_FILE = "books.txt";
        private static final String STUDENTS_FILE = "students.txt";
        private static final String LIBRARIANS_FILE = "librarians.txt";
        private static final String LOANS_FILE = "loans.txt";
        private static final String ADMIN_FILE = "admin.txt";

        public static void saveBooks(List<Book> books) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKS_FILE))) {
                for (Book b : books) {
                    pw.println(b.getName() + ";" + b.getAuthor() + ";" + b.getPagecount() + ";" + b.getPublicyear());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Book> loadBooks() {
            List<Book> books = new ArrayList<>();
            try (Scanner scanner = new Scanner(new FileReader(BOOKS_FILE))) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");
                    books.add(new Book(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                }
            } catch (IOException e) {
                System.out.println("no such file");
            }
            return books;
        }

        public static void saveStudents(List<Student> students) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENTS_FILE))) {
                for (Student s : students) {
                    pw.println(s.getFirstname() + ";" + s.getLastname() + ";" + s.getStudentid() + ";" + s.getMajor() + ";" + s.getJoindate());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Student> loadStudents() {
            List<Student> students = new ArrayList<>();
            try (Scanner scanner = new Scanner(new FileReader(STUDENTS_FILE))) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");
                    Student s = new Student(data[0], data[1], data[2], data[3]);
                    s.setJoindate(LocalDate.parse(data[4]));
                    students.add(s);
                }
            } catch (IOException e) {
                System.out.println("no such file");
            }
            return students;
        }

        public static void saveLibrarians(List<Librarian> librarians) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(LIBRARIANS_FILE))) {
                for (Librarian l : librarians) {
                    pw.println(l.getFirstname() + ";" + l.getLastname() + ";" + l.getEmployeeID());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Librarian> loadLibrarians() {
            List<Librarian> librarians = new ArrayList<>();
            try (Scanner scanner = new Scanner(new FileReader(LIBRARIANS_FILE))) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");
                    librarians.add(new Librarian(data[0], data[1], data[2]));
                }
            } catch (IOException e) {
                System.out.println("no such file");
            }
            return librarians;
        }

        public static void saveAdmin(Manager manager) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(ADMIN_FILE))) {
                pw.println(manager.getFirstname() + ";" + manager.getLastname() + ";" + manager.getEducational_level());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Manager loadAdmin() {
            try (Scanner scanner = new Scanner(new FileReader(ADMIN_FILE))) {
                if (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");
                    return new Manager(data[0], data[1], data[2]);
                }
            } catch (IOException e) {
                System.out.println("no such file");
            }
            return null;
        }

        public static void saveLoans(List<Loan> loans) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(LOANS_FILE))) {
                for (Loan l : loans) {
                    pw.println(
                            l.getBook1().getName() + ";" +
                                    l.getStudent1().getStudentid() + ";" +
                                    l.getLoanlibrarian().getEmployeeID() + ";" +
                                    l.getLoan_Date() + ";" +
                                    l.getRecivedate() + ";" +
                                    (l.getActual_returndate() != null ? l.getActual_returndate() : "null") + ";" +
                                    (l.getReturnlibrarian() != null ? l.getReturnlibrarian().getEmployeeID() : "null")
                    );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Loan> loadLoans(List<Book> books, List<Student> students, List<Librarian> librarians) {
            List<Loan> loans = new ArrayList<>();
            try (Scanner scanner = new Scanner(new FileReader(LOANS_FILE))) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");

                    Book book = findBookByTitle(books, data[0]);
                    Student student = findStudentById(students, data[1]);
                    Librarian loaner = findLibrarianById(librarians, data[2]);

                    LocalDate loanDate = LocalDate.parse(data[3]);
                    LocalDate dueDate = LocalDate.parse(data[4]);
                    LocalDate returnDate = data[5].equals("null") ? null : LocalDate.parse(data[5]);
                    Librarian receiver = data[6].equals("null") ? null : findLibrarianById(librarians, data[6]);

                    if (book != null && student != null && loaner != null) {
                        Loan loan = new Loan(book, student, loaner);
                        loan.setActual_returndate(returnDate);
                        loan.setReturnlibrarian(receiver);
                        loans.add(loan);
                    }
                }
            } catch (IOException e) {

            }
            return loans;
        }
        private static Book findBookByTitle(List<Book> books, String title) {
            for (Book b : books) {
                if (b.getName().equals(title)) return b;
            }
            return null;
        }

        private static Student findStudentById(List<Student> students, String id) {
            for (Student s : students) {
                if (s.getStudentid().equals(id)) return s;
            }
            return null;
        }

        private static Librarian findLibrarianById(List<Librarian> librarians, String id) {
            for (Librarian l : librarians) {
                if (l.getEmployeeID().equals(id)) return l;
            }
            return null;
        }
    }


    public static class Menu {

        public static void studentmenu(Library library, Scanner scanner) {
            System.out.println("enter student ID");
            String ID = scanner.nextLine();

            Student student = library.findStudent(ID);

            if (student == null) {
                System.out.println("student not found. do you want to register student? (yes/no) ");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("enter first name");
                    String firstname = scanner.nextLine();
                    System.out.println("enter last name");
                    String lastname = scanner.nextLine();
                    System.out.println("enter student ID");
                    String studentID = scanner.nextLine();
                    System.out.println("enter major");
                    String major = scanner.nextLine();
                    student = new Student(firstname, lastname, studentID, major);
                    library.addStudent(student);
                    System.out.println("student added");

                } else return;
            }
            while (true) {
                System.out.println("1 search book by title ");
                System.out.println("2 loan book request ");
                System.out.println("3 return book ");
                System.out.println("4 boooks that you loan and havenot return");
                System.out.println("5 exit");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        InputProcessor.searchBook(library);
                        break;
                    case "2":
                        InputProcessor.borrowBook(library, student);
                        break;
                    case "3":
                        InputProcessor.returnBook(library, student);
                        break;
                    case "4":
                        InputProcessor.showUnreturnedBooks(student);
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("invalid choice");
                }


            }
        }

        public static void librarianmenu(Library library, Scanner scanner) {
            System.out.println("enter employee ID");
            String ID = scanner.nextLine();
            Librarian librarian = null;
            for (Librarian l : library.getLibrarians1()) {
                if (l.getEmployeeID().equals(ID)) {
                    librarian = l;
                    break;
                }
            }
            if (librarian == null) {
                System.out.println("librarian not found.");
                return;
            }

            while (true) {
                System.out.println("1 add new book ");
                System.out.println("2 edit personal info");
                System.out.println("3 final approval of book request");
                System.out.println("4 confirm return of book");
                System.out.println("5 exit");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        InputProcessor.addBook(library);
                        break;
                    case "2":
                        InputProcessor.updatePersonalInfo(librarian);
                        break;
                    case "3":
                        InputProcessor.approveLoan();
                        break;
                    case "4":
                        InputProcessor.approveReturn();
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("invalid choice");

                }
            }
        }

        public static void managernmenu(Library library, Scanner scanner) {
            Manager manager = library.getManager1();
            System.out.println(manager.toString());
            System.out.println("manager menu ");
            System.out.println("1 adding new librarian ");
            System.out.println("2 view list of books that borrowed and returned later than due date ");
            System.out.println("3 view number of book check-outs and returns by each librarian ");
            System.out.println("4 top 10 most borrowed boooks");
            System.out.println("5 exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    InputProcessor.addLibrarian(library);
                    break;
                case "2":
                    InputProcessor.showLateBooks(library);
                    break;
                case "3":
                    InputProcessor.showLoanStats(library);
                    break;
                case "4":
                    InputProcessor.showTop10Books(library);
                    break;
                case "5":
                    return;
                default:
            }
        }
    }

    public class InputProcessor {
        private static Scanner scanner = new Scanner(System.in);

        private static void searchBook(Library library) {
            System.out.print("title: ");
            String query = scanner.next();

            List<Book> books = library.getBooks1();
            boolean found = false;
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (b.getName().contains(query) || b.getAuthor().contains(query)) {
                    System.out.println(b);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("book not found.");
            }
        }

        private static void borrowBook(Library library, Student student) {
            System.out.print("title: ");
            String title = scanner.next();

            List<Book> books = library.getBooks1();
            Book targetBook = null;
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getName().equalsIgnoreCase(title)) {
                    targetBook = books.get(i);
                    break;
                }
            }

            if (targetBook == null) {
                System.out.println("book not found.");
                return;
            }

            Loan loan = library.borrwbook(targetBook, student);
            if (loan != null) {
                System.out.println("book borrowed .");
            } else {
                System.out.println("it is not possible to borrow book.");
            }
        }

        private static void showUnreturnedBooks(Student student) {
            List<Loan> loans = student.getActiveloansLoans();
            boolean any = false;
            for (int i = 0; i < loans.size(); i++) {
                if (!loans.get(i).isreturned()) {
                    System.out.println(loans.get(i));
                    any = true;
                }
            }
            if (!any) {
                System.out.println("you dont have unreturned books.");
            }
        }

        private static void returnBook(Library library, Student student) {
            System.out.print("title: ");
            String title = scanner.next();

            List<Loan> loans = student.getActiveloansLoans();
            Loan loanToReturn = null;

            for (int i = 0; i < loans.size(); i++) {
                Loan l = loans.get(i);
                if (l.getBook1().getName().equalsIgnoreCase(title) && !l.isreturned()) {
                    loanToReturn = l;
                    break;
                }
            }

            if (loanToReturn != null) {
                library.returnBook(loanToReturn);
                System.out.println("book returned.");
            } else {
                System.out.println("the book does not exist.");
            }
        }

        private static void updatePersonalInfo(Librarian librarian) {
            System.out.print("new first name: ");
            String firstName = scanner.next();
            librarian.setFirstname(firstName);
            System.out.print("new last name: ");
            String lastName = scanner.next();
            librarian.setLastname(lastName);
            librarian.lastname = scanner.next();

            System.out.println("personal info edited.");
        }

        private static void addBook(Library library) {
            System.out.print("title: ");
            String title = scanner.next();
            System.out.print("author: ");
            String author = scanner.next();
            System.out.print("publish year: ");
            int year = scanner.nextInt();
            System.out.print("pages: ");
            int pages = scanner.nextInt();

            Book book = new Book(title, author, year, pages);
            library.addBook(book);
            System.out.println("book added.");
        }

        private static void approveLoan() {
            System.out.println("loan approved");
        }

        private static void approveReturn() {
            System.out.println("return approved.");
        }

        private static void addLibrarian(Library library) {
            System.out.print("first name ");
            String first = scanner.next();
            System.out.print("last name ");
            String last = scanner.next();
            System.out.print("id: ");
            String id = scanner.next();

            Librarian l = new Librarian(first, last, id);
            library.addLibrarian(l);
            System.out.println("librarian aded");
        }

        private static void showLateBooks(Library library) {
            List<Loan> lateLoans = library.getlateloans();
            for (int i = 0; i < lateLoans.size(); i++) {
                System.out.println(lateLoans.get(i));
            }
        }

        private static void showLoanStats(Library library) {
            System.out.println("loan stats per librarian:");
            library.loanperlibrarian();
        }

        private static void showTop10Books(Library library) {
            List<Book> topBooks = library.gettop10borrowedbooks();
            for (int i = 0; i < topBooks.size(); i++) {
                System.out.println(topBooks.get(i));
            }
        }
    }


    public static void main(String[] args) {
        Library library = new Library("university library");
        Scanner sc = new Scanner(System.in);
        List<Book> books = LibraryPersistence.loadBooks();
        List<Student> students = LibraryPersistence.loadStudents();
        List<Librarian> librarians = LibraryPersistence.loadLibrarians();
        List<Loan> loans = LibraryPersistence.loadLoans(books, students, librarians);
        Manager admin = LibraryPersistence.loadAdmin();

        library.setBooks1(books);
        library.setStudents1(students);
        library.setLibrarians1(librarians);
        library.setLoans1(loans);
        library.setManager1(admin);

        if (admin == null) {
            admin = new Manager("reza", "amiri", " masters");
            library.setManager1(admin);
        }

        if (librarians.isEmpty()) {
            Librarian l1 = new Librarian("ali", "rad", "ww");
            Librarian l2 = new Librarian("amir", "radan", "qq");
            library.getLibrarians1().add(l1);
            library.getLibrarians1().add(l2);
        }
        while (true) {
            System.out.println("1.student 2.librarian 3.manager 4.exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Menu.studentmenu(library, sc);
                    break;
                case 2:
                    Menu.librarianmenu(library, sc);
                    break;
                case 3:
                    Menu.managernmenu(library, sc);
                    break;
                case 4:
                    LibraryPersistence.saveBooks(library.getBooks1());
                    LibraryPersistence.saveStudents(library.getStudents1());
                    LibraryPersistence.saveLibrarians(library.getLibrarians1());
                    LibraryPersistence.saveLoans(library.getLoans1());
                    LibraryPersistence.saveAdmin(library.getManager1());

                    System.out.println("loaded sucsesfuly.");
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("wrong choice");
            }
        }

    }
}