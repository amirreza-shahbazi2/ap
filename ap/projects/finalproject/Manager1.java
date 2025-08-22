package ap.projects.finalproject;

public class Manager1 extends User {
    private String name ;

    public Manager1(String name, String password, String username) {
        super(username, password);
        this.name = name;
        }
}
