package Users;

import Messages.Message;
import Messages.Request;
import Util.Classes.Data;
import Util.Data.DB;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;


public class Employee extends User implements Serializable {
    
    protected Integer id;
    protected Vector<Message> messages = new Vector<Message>();
    private Boolean isResearcher = false;

    public Employee() {
    }

    public Employee(String username, String password, UserType ut) {
        super(username, password, ut);
        id = DB.getInstance().getUsersByUserType(UserType.EMPLOYEE).size() + 1;

    }

    public void sendRequest(String content){
        Rector.getINSTANCE().addRequest(new Request(this, content));
    }
    public void sendMessage(Message m, Employee e){
        e.messages.add(m);
    }

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


    @Override
    public void update() {

    }
}
