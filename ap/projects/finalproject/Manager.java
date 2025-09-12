package ap.projects.finalproject;

import java.io.Serializable;

public class Manager extends User implements Serializable {
    private String name ;

    public Manager(String name, String password, String username) {
        super(username, password);
        this.name = name;
        }
        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }
}
