package exercises;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main_midterm_project {
    public static class Book {
        private String name;
        private String author;
        private int pagecount;
        private int publicyear;
//        private int borrowcount;

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

        public String getLastname() {
            return lastname;
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

        public Loan(Book book1, Student student1, Librarian loanlibrarian, int loandays) {
            this.book1 = book1;
            this.student1 = student1;
            this.loanlibrarian = loanlibrarian;
            this.returnlibrarian = null;
            this.loan_Date = LocalDate.now();
            this.recivedate = loan_Date.plusDays(20);
            this.actual_returndate = null;

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

        public LocalDate getLoan_Date() {
            return loan_Date;
        }

        public LocalDate getRecivedate() {
            return recivedate;
        }

        public LocalDate getActual_returndate() {
            return actual_returndate;
        }

        public String toString() {
            return "name of book: " + book1.getName() + "student ID: " + student1.getStudentid() + "date of loan: " + loan_Date +
                    "date of return; " + (recivedate != null ? recivedate : "have not returned yet");
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

        public void addlibrarian(Library library, Librarian librarian) {
            library.addLibrarian(librarian);

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

        public Library(String libraryname, Manager manager1) {
            this.libraryname = libraryname;
            this.manager1 = manager1;
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

        public Student findStudent(String id) {
            for (Student student : students1) {
                if (student.getStudentid().equals(id)) {
                    return student;
                }
            }
            return null;
        }

        public Book searchbytitle(String title) {
            for (Book book : books1) {
                if (book.getName().equalsIgnoreCase(title)) {
                    return book;

                }
            }
            return null;
        }

        public List<Book> getBooks1() {
            return books1;
        }

        public List<Student> getStudents1() {
            return students1;
        }

        public List<Librarian> getLibrarians1() {
            return librarians1;
        }

        public List<Loan> getLoans1() {
            return loans1;
        }

        public Manager getManager1() {
            return manager1;
        }


    }

    public static class libraryData {
        public static final String BOOK_FILE = "books.txt";
        public static final String STUDENT_FILE = "students.txt";
        public static final String LIBRARIAN_FILE = "librarians.txt";
        private static final String LOAN_FILE = "loans.txt";


        public static void saveBooks(List<Book> books) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(BOOK_FILE))) {
                for (Book book : books) {
                    pw.println(book.getName() + ";" + book.getAuthor() + ";" + book.getPublicyear() + ";" + book.getPagecount());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void saveLibrarians(List<Librarian> librarians) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(LIBRARIAN_FILE))) {
                for (Librarian l : librarians) {
                    pw.println(l.getEmployeeID() + ";" + l.getFirstname() + ";" + l.getLastname());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void saveStudents(List<Student> students) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENT_FILE))) {
                for (Student s : students) {
                    pw.println(s.getStudentid() + ";" + s.getFirstname() + ";" + s.getLastname() + ";" + s.getMajor() + ";" + s.getJoindate());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static List<Book> loadBooks() {
            List<Book> books = new ArrayList<>();
            try (Scanner sc = new Scanner(new FileReader(BOOK_FILE))) {
                while (sc.hasNextLine()) {
                    String[] parts = sc.nextLine().split(";");
                    if (parts.length == 4) {
                        books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                    }
                }
            } catch (IOException e) {
            }
            return books;
        }


        public static List<Student> loadStudents() {
            List<Student> students = new ArrayList<>();
            try (Scanner sc = new Scanner(new FileReader(STUDENT_FILE))) {
                while (sc.hasNextLine()) {
                    String[] parts = sc.nextLine().split(";");
                    if (parts.length == 4) {
                        String[] names = parts[1].split(" ");
                        String first = names[0];
                        String last = names.length > 1 ? names[1] : "";
                        students.add(new Student(first, last, parts[0], parts[2]));
                    }
                }
            } catch (IOException e) {
            }
            return students;
        }


        public static List<Librarian> loadLibrarians() {
            List<Librarian> librarians = new ArrayList<>();
            try (Scanner sc = new Scanner(new FileReader(LIBRARIAN_FILE))) {
                while (sc.hasNextLine()) {
                    String[] parts = sc.nextLine().split(";");
                    String[] names = parts[1].split(" ");
                    librarians.add(new Librarian(names[0], names.length > 1 ? names[1] : "", parts[0]));
                }
            } catch (IOException e) {
            }
            return librarians;
        }


    }

    public static class Menu {

        public static void studentmenu(Library library,Scanner scanner) {
            System.out.println("enter student ID");
            String ID = scanner.nextLine();

            Student student=library.findStudent(ID);

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
                System.out.println("2 loan book ");
                System.out.println("3 return book ");
                System.out.println("4 return student ");
                System.out.println("5 boooks that you loan and havenot return");
                System.out.println("6 exit");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter title of book");
                        String title = scanner.nextLine();
                       Book b= library.searchbytitle(title);
                        System.out.println(b !=null?b.toString():"book not found");
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
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
                if (librarian==null) {
                    System.out.println("librarian not found.");
                    return;
                }

            while (true) {
                System.out.println("1 add new book ");
                System.out.println("2 edit personal info");
                System.out.println("3 final approval of book request");
                System.out.println("4 confirm return of book");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter book title");
                        String title = scanner.nextLine();
                        System.out.println("enter author");
                        String author = scanner.nextLine();
                        System.out.println("enter year");
                        Integer year = scanner.nextInt();
                        System.out.println("enter count of pages");
                        Integer pages = scanner.nextInt();
                        library.addBook(new Book(title, author, year, pages));
                        System.out.println("book added");
                        break;
                    case "2":
                        return;

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
            System.out.println("top 10 most borrowed boooks");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("enter first name");
                    String firstname = scanner.nextLine();
                    System.out.println("enter last name");
                    String lastname = scanner.nextLine();
                    System.out.println("enter employee ID");
                    String ID = scanner.nextLine();
                    manager.addlibrarian(library, new Librarian(firstname, lastname, ID));
                    System.out.println("librarian added");
                    break;
                case "2":
                    return;


            }
        }


    }

    public static void main(String[] args) {
Library library;
        Scanner sc = new Scanner(System.in);



            List<Book> book = libraryData.loadBooks();
            List<Student> student = libraryData.loadStudents();
            List<Librarian> librarian = libraryData.loadLibrarians();


            System.out.println("starting new library");
            Manager manager = new Manager("reza", "amiri", "masters");
           library = new Library("UNIVERSITY", manager);
            library.addLibrarian(new Librarian("ali", "rad", "ww"));
            library.addLibrarian(new Librarian("amir", "rad", "qq"));

            while (true) {
                System.out.println("1.student 2.librarian 3.manager 4.exit");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        Menu.studentmenu(library,sc);
                        break;
                    case 2:
                        Menu.librarianmenu(library, sc);
                        break;
                    case 3:
                        Menu.managernmenu(library, sc);
                        break;
                    case 4:
                        libraryData.saveBooks(book);
                        libraryData.saveStudents(student);
                        libraryData.saveLibrarians(librarian);

                        System.exit(0);
                    default:
                        System.out.println("wrong choice");
                }
            }

        }
//    }
}
