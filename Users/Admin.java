package Users;


import Util.Classes.UserFactory;
import Util.Enums.UserType;
import Util.Classes.Data;

import java.io.Serializable;

public class Admin extends User implements Serializable {


    public Admin(String username, String password){
        super(username, password, UserType.ADMIN);
    }

    public String viewLogFiles() {
        return Data.getInstance().getLogFiles();
    }

    public void createUser(UserType ut, String username, String password) {
        UserFactory.createUser(ut, username, password);
    }

    public void deleteUser(User u){

    }

    @Override
    public void update() {

    }
}
