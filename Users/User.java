package Users;

import Messages.Order;
import Util.*;
import Util.Classes.Data;
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

    {
        Data data = Data.getInstance();
        data.addUser(this);
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

    public void setPassword(String password) {
        this.password = password;
    }


    public void reportIssue(String description) {
        TechSupportSpecialist tech = new TechSupportSpecialist();
        tech.addOrder(new Order(description));
    }


    public abstract void update();
}
