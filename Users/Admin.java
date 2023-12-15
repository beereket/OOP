package Users;


import Utils.classes.UserFactory;
import Utils.enums.UserType;
import Utils.classes.Data;


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
