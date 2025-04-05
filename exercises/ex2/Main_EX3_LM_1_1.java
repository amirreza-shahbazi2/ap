package exercises.ex2;
class Book{
    private String name;
    private String author;
    private int pagecount;
    private int publicyear;
    public Book(String name, String author, int pagecount, int publicear) {
        this.name = name;
        this.author = author;
        this.pagecount = pagecount;
        this.publicyear = publicear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPagecount() {
        return pagecount;
    }
    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    public int getPublicyear() {
        return publicyear;
    }
    public void setPublicyear(int publicyear) {
        this.publicyear = publicyear;
    }
    public String toString() {
        return "name of the book:"+ name+" | author of the book:"+author+" | page of book:"+pagecount
                +" | publication year:"+publicyear;
    }
}
class Student{
    private String firstname;
    private String lastname;
    private String studentid;
    private String major;
    public Student(String firstname, String lastname, String studentid, String major) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentid = studentid;
        this.major = major;
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
    public String getStudentid() {
        return studentid;
    }
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String toString() {
        return "first name of student:"+firstname+" | lastname of student:"+lastname+" | studentid of student:"
                +studentid+" | major of student:"+major;
    }
}

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Book book1=new Book("big java","cay S.Horstmann",1040,2015);
        Book book2 =new Book("java programming","john doe",350,2020);

        Student student1=new Student("reza","rezaei","967543761","computer science");
        Student student2=new Student("ali","shahbazi","254859714","electrical engineering");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(student1);
        System.out.println(student2);
    }

}
