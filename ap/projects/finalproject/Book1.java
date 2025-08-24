package ap.projects.finalproject;

public class Book1 {
    private String name;
    private String author;
    private int publicyear;
    private boolean available=true;
//    private int borrowcount = 0;

    public Book1(String name, String author, int publicyear) {
        this.name = name;
        this.author = author;
        this.publicyear = publicyear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicyear() {
        return publicyear;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
//    public void increaseborrowcount() {
//        borrowcount++;
//    }

    public String toString() {
        return "name of the Book:" + getName() + " | author of the Book:" + getAuthor() +
                " | publication year:" + getPublicyear()+
                " | isAvailable:" + (isAvailable() ? "Yes" : "No");
    }

}
