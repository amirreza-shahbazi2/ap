package ap.projects.finalproject;


import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. log in as a guest student");
            System.out.println("4. log in as a librarian");
            System.out.println("5. loh in as a manager");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayguestmenu();
                    break;
                case 4:
                    Librarian l = librarySystem.loginLibrarian();
                    if (l != null) {
                        dispaylibrarianmenu();
                    }
                    break;
                case 5:
                    displaymanagermenu();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displaymanagermenu() {
        while (true) {
            System.out.println("\n--- manager menu ---");
            System.out.println("1. add new librarian");
            System.out.println("2. view librarian status");
            System.out.println("3. view statistical info about book loans");
            System.out.println("4. view statistical info about students");
            System.out.println("5. exit");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 5);
            switch (choice) {
                case 1:
                    librarySystem.addLibrarian();
                    break;
                case 2:
                    librarySystem.viewLibrarianStatus();

                    break;
                case 3:
                    librarySystem.viewLoanStatistics();

                    break;
                case 4:
                    librarySystem.viewStudentStatics();

                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");

        }
    }

    private void dispaylibrarianmenu() {
        while (true) {
            System.out.println("\n=== Librarian menu ===");
            System.out.println("1. change password");
            System.out.println("2. register a new book ");
            System.out.println("3. search and edit book information");
            System.out.println("4. approve loan request");
            System.out.println("5. view students loan history and stats of students");
            System.out.println("6. active or di active students");
            System.out.println("7. receive returned books");
            System.out.println("8. exit");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 8);
            switch (choice) {
                case 1:
                    librarySystem.changePassword();
                    break;
                case 2:
                    librarySystem.addanewabook();
                    break;
                case 3:
                    librarySystem.searchandEditbookInfo();
                    break;
                case 4:
                    librarySystem.approveLoan();
                    break;
                case 5:
                    librarySystem.studentLoanHistory();
                    break;
                case 6:
                    librarySystem.toggleStudentStatus();
                    break;
                case 7:
                    librarySystem.receiveReturnBook();
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayguestmenu() {
        while (true) {
            System.out.println("\n--- guest menu ---");
            System.out.println("1. display registered student count");
            System.out.println("2. search book with title");
            System.out.println("3. view statistical information");
            System.out.println("4. exit");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 4);
            switch (choice) {
                case 1:
                    displayStudentCount();
                    break;
                case 2:
                    librarySystem.searchBookwithtitle();
                    break;
                case 3:
                    librarySystem.wiewStatisticalInfo();

                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }

    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (true) {
            System.out.println("\n--- Logged In Student Menu ---");
            System.out.println("1. search a book");
            System.out.println("2. loan  book");
            System.out.println("3. exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 3);

            switch (choice) {
                case 1:
                    librarySystem.searchBook();
                    break;
                case 2:
                    System.out.println("enter student ID");
                    String studentId = scanner.nextLine();
                    Student st = librarySystem.searchStudentbyID(studentId);
                    if (st != null) {
                        librarySystem.requestLoan(st);
                    } else {
                        System.out.println("Invalid student ID. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

}