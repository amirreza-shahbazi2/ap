package ap.projects.finalproject;

import java.io.Serializable;

public class User implements Serializable {
    protected String username;
    protected String password;
    protected boolean active=true;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newpassword) {
        this.password = newpassword;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
