package Users;

import Messages.Message;
import Messages.Request;
import Research.*;
import Research.ResearchProjectJoinException;
import Research.ResearchSupervisorException;
import Util.Classes.Data;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Vector;


public class Employee extends User implements Serializable {
    
    protected Integer id;
    protected Vector<Message> messages = new Vector<Message>();
    private Boolean isResearcher = false;

    public Employee() {
    }

    public Employee(String username, String password, UserType userType) {
        super(username, password, userType);
        id = Data.getInstance().getEmployees().size() + 1;

        Data.getInstance().getEmployees().add(this);
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
