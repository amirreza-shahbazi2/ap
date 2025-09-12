package ap.projects.finalproject;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private int publicyear;
    private boolean available = true;
    private String addedByLibrarian;

    public Book(String name, String author, int publicyear, String addedByLibrarian) {
        this.name = name;
        this.author = author;
        this.publicyear = publicyear;
        this.addedByLibrarian = addedByLibrarian;
    }
    public String getAddedByLibrarian(){
        return addedByLibrarian;
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

    public int getPublicyear() {
        return publicyear;
    }

    public void setPublicyear(int publicyear) {
        this.publicyear = publicyear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "name of the Book:" + getName() + " | author of the Book:" + getAuthor() +
                " | publication year:" + getPublicyear() +
                " | isAvailable:" + (isAvailable() ? "Yes" : "No");
    }
    public String toStringGuest() {
        return "name of the Book:" + getName() + " | author of the Book:" + getAuthor() +
                " | publication year:" + getPublicyear();
    }

}
