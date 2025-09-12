package ap.projects.finalproject;

import java.util.List;

public interface Persistence {
    void saveLibrarianToFile(List<Librarian> librarians);
    List<Librarian> loadLibrariansFromFile();
    void saveBooks(List<Book> books);
    List<Book> loadBooks();
    void saveStudents(List<Student> students);
    List<Student> loadStudents();
    void saveLoans(List<Loan> loans);
    List<Loan> loadLoans();
}
