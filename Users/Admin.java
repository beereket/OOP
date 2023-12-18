package Users;


import Util.Classes.UserFactory;
import Util.Enums.UserType;
import Util.Classes.Data;

public class Admin extends User {


    public Admin(String username, String password){
        super(username, password);
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
