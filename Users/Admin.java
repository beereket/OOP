package Users;


import Util.Classes.UserFactory;
import Util.Enums.UserType;
import Util.Classes.Data;

public class Admin extends User {


    public Admin(String username, String password, String logFiles) {
        super(username, password);
    }

    public String viewLogFiles() {
        return Data.INSTANCE.getLogFiles();
    }

    public void createUser(UserType ut, String username, String password) {
        UserFactory.createUser(ut, username, password);
    }

    @Override
    public void update() {

    }
}
