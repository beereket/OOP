package Users;


import Util.Classes.Data;
import Util.Classes.UserFactory;
import Util.Enums.UserType;

public class Admin extends User {
    
    private String logFiles;

    public Admin(String username, String password, String logFiles) {
        super(username, password);
        this.logFiles = logFiles;
    }

    public String viewLogFiles() {
        return logFiles;
    }

    public void createUser(UserType ut, String username, String password) {
        UserFactory.createUser(ut, username, password);
    }
    {
        Data data = Data.getInstance();
        data.addUser(this);
    }


    @Override
    public void update() {

    }
}
