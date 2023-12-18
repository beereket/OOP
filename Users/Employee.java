package Users;
import Messages.*;

import java.io.Serializable;


public class Employee extends User implements Serializable {
    
    private Integer id;

    public Employee() {
    }

    public void sendRequest(String content){
        Rector.getINSTANCE().addRequest(new Request(this, content));
    }
    public void sendMessage(Message m, Employee e){
    }

    @Override
    public void update() {

    }
}
