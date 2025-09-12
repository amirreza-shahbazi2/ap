package ap.projects.finalproject;

import java.util.List;

public class Main_Finalproject {
    public static void main(String[] args) {
        LibrarySystem ls = new LibrarySystem();
        try {

            List<Librarian> m = ls.libraryPersistence.loadLibrariansFromFile();
            ls.setLibrarians(m);
            List<Book> b = ls.libraryPersistence.loadBooks();
            ls.setBooks(b);
            List<Student> S = ls.libraryPersistence.loadStudents();
            ls.setStudents(S);
            List<Loan> l = ls.libraryPersistence.loadLoans();
            ls.setLoans(l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("cannot load sucsefully");
        }
        MenuHandler newMenu = new MenuHandler(ls);
        Manager M = new Manager("AA", "AA", "AA");

        newMenu.displayMainMenu();

    }
}
