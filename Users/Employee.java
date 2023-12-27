package Users;

import Messages.Message;
import Messages.Request;
import Util.Data.DB;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;


/**
 * Represents an employee in the system. This class extends User and includes functionalities specific to employees,
 * such as sending requests and messages.
 */
public class Employee extends User implements Serializable {
    protected Integer id;
    protected Vector<Message> messages = new Vector<Message>();
    private Boolean isResearcher = false;

    public Employee() {
    }
    /**
     * Constructs an Employee with specified username, password, and user type. Automatically assigns an ID based on
     * the number of employees already present in the system.
     *
     * @param username The username for the employee.
     * @param password The password for the employee.
     * @param ut The user type of the employee.
     */
    public Employee(String username, String password, UserType ut) {
        super(username, password, ut);
        id = DB.getInstance().getUsersByUserType(UserType.EMPLOYEE).size() + 1;
    }
    /**
     * Sends a request to the Rector. The request is added to the Rector's list of pending requests.
     *
     * @param content The content of the request.
     */
    public void sendRequest(String content){
        Rector.getINSTANCE().addRequest(new Request(this, content));
    }
    /**
     * Sends a message to another employee. The message is added to the recipient's message list.
     *
     */
    public void sendMessage(){
        System.out.println("Employee username");
        String name = in.nextLine();

        System.out.println("Message:");
        String message = in.nextLine();

        Employee e = (Employee)DB.getInstance().getUserByUsername(name);
        e.addMessage(new Message(this, e, message));

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
    public void addMessage(Message m){
        messages.add(m);
    }
}
