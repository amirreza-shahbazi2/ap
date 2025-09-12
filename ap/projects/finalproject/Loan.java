package ap.projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable {
    private Book book;
    private Student student;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private boolean approved;
    private String approvedByLibrarian;
    private String returnedByLibrarian;
    public Loan(Book book, Student student, LocalDate startDate, LocalDate endDate) {
        this.book = book;
        this.student = student;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approved = false;
    }
    public String getApprovedByLibrarian() {
        return approvedByLibrarian;
    }
    public void setApprovedByLibrarian(String username) {
        this.approvedByLibrarian = username;
    }
    public String getReturnedByLibrarian() {
        return returnedByLibrarian;
    }
    public void setReturnedByLibrarian(String username) {
        this.returnedByLibrarian = username;
    }
    public Book getBook1() {
        return book;
    }
    public Student getStudent1() {
        return student;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String toString() {
        return "requestloan: "+"| student: "+ student.getName()+
                " | book: "+ book.getName()+ " | startdate: "+getStartDate()+
                " | end date: "+getEndDate()+ " | is approved: "+ (isApproved() ? "Yes" : "No");

    }

}
