package Users;

import Messages.Order;
import Util.Classes.Data;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;
import Util.Observer;

import java.io.Serializable;
import java.util.Vector;

public abstract class User implements Observer, Serializable {
    
    private String username;
    private String password;
    private UserType userType;

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
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
    public static User authenticate(String username, String password) throws UserNotFound {
        Vector<User> users = Data.getInstance().getUsers();
        for (User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFound();
    }


    public void reportIssue(String description) {
        TechSupportSpecialist.addOrder(new Order(description));
    }


    public abstract void update();
}
