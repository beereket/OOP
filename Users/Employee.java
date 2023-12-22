package Users;
import Messages.*;
import Util.Enums.UserType;

import java.io.Serializable;
import java.util.Vector;


public class Employee extends User implements Serializable {
    
    protected Integer id;
    protected Vector<Message> messages = new Vector<Message>();

    public Employee() {
    }

    public Employee(String username, String password, UserType userType, Integer id) {
        super(username, password, userType);
        this.id = id;
    }

    public void sendRequest(String content){
        Rector.getINSTANCE().addRequest(new Request(this, content));
    }
    public void sendMessage(Message m, Employee e){
        e.messages.add(m);
    }

    @Override
    public void update() {

    }
}
