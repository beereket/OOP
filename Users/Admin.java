package Users;


import Util.Classes.UserFactory;
import Util.Enums.UserType;
import Util.Classes.Data;

import java.io.IOException;
import java.io.Serializable;

public class Admin extends User implements Serializable {


    public Admin(String username, String password){
        super(username, password, UserType.ADMIN);
    }

    private String viewLogFiles() {
        return Data.getInstance().getLogFiles();
    }

    private void createUser(UserType ut, String username, String password) {
        UserFactory.createUser(ut, username, password);
    }

//    //private void deleteUser(User u){
//        Data.getInstance().removeUser(u);
//    }

    @Override
    public void update() {

    }
    //MENU METHODS
    @Override
    public void run() throws IOException {

    }

    @Override
    protected void displayRussianMenu() {

    }

    @Override
    protected void displayKazakhMenu() {

    }

    @Override
    protected void displayEnglishMenu() {

    }
}
