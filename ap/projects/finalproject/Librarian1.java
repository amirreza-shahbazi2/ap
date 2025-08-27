package ap.projects.finalproject;

public class Librarian1 extends User {
    private String nameLibrarian;


    public Librarian1(String name, String username, String password) {
        super(username, password);
        this.nameLibrarian = name;

    }
    public String getNameLibrarian() {
        return nameLibrarian;
    }

    public String toString(){
        return " name of Librarian: " + this.nameLibrarian ;
    }

}

