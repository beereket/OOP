package Users;
import Messages.*;


public class Employee extends User {
    
    private Integer id;
    private String position;

    public Employee(String username, String password) {
        super(username, password);
    }

    public Employee(String username, String password, Integer id, String position) {
        super(username, password);
        this.id = id;
        this.position = position;
    }

    public Employee() {
    }

    public void sendRequest(){

    }
    public void sendMessage(Message m, Employee e){

    }

    @Override
    public void update() {

    }
}
