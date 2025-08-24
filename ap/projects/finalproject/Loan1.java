package ap.projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Loan1 implements Serializable {
    private Book1 book1;
    private Student1 student1;
    private LocalDate startDate;
    private LocalDate endDate;
    private Date returnDate;
    private boolean approved;
    public Loan1(Book1 book1, Student1 student1, LocalDate startDate, LocalDate endDate) {
        this.book1 = book1;
        this.student1 = student1;
        this.startDate = startDate;
        this.endDate = endDate;
//        this.returnDate = returnDate;
        this.approved = false;
    }
    public Book1 getBook1() {
        return book1;
    }
    public Student1 getStudent1() {
        return student1;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApprovedtrue() {
        this.approved = true;
    }
    public void setApprovedfalse() {
        this.approved = false;
    }
    public String toString() {
        return "requestloan: "+"| student: "+student1.getName()+
                " | book: "+book1.getName()+ " | startdate: "+getStartDate()+
                " | end date: "+getEndDate()+ " | is approved: "+ (isApproved() ? "Yes" : "No");

    }

}
