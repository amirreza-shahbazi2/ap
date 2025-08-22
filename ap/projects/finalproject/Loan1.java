package ap.projects.finalproject;

import java.io.Serializable;
import java.util.Date;

public class Loan1 implements Serializable {
    private Book1 book1;
    private Student1 student1;
    private Date startDate;
    private Date endDate;
    private Date returnDate;
    public Loan1(Book1 book1, Student1 student1, Date startDate, Date endDate, Date returnDate) {
        this.book1 = book1;
        this.student1 = student1;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
    }
    public Book1 getBook1() {
        return book1;
    }
    public Student1 getStudent1() {
        return student1;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
