package ap.projects.finalproject;

public class Librarian1 extends User {
    private String name;


    public Librarian1(String name, String username, String password) {
        super(username, password);
        this.name = name;

    }
    public String getName() {
        return name;
    }



}

