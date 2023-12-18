package Users;

import Util.Observer;

import java.io.Serializable;

public abstract class User implements Observer, Serializable {
    
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void reportIssue(String description) {
    }


    public abstract void update();
}
