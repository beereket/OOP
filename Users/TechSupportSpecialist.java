package Users;

import Messages.Order;
import Util.Classes.Data;

import java.util.List;


public class TechSupportSpecialist extends Employee {
    private static List<Order> orders;
    private static List<Order> accepted_orders;

    public TechSupportSpecialist(String username, String password, Integer id, String position) {
        super(username, password, id, position);
    }

    public TechSupportSpecialist(String username, String password, List<Order> orders, List<Order> accepted_orders) {
        super(username, password);
        this.orders = orders;
        this.accepted_orders = accepted_orders;
    }

    public TechSupportSpecialist(String username, String password) {
        super(username, password);
    }

    public TechSupportSpecialist(String username, String password, Integer id, String position, List<Order> orders, List<Order> accepted_orders) {
        super(username, password, id, position);
        this.orders = orders;
        this.accepted_orders = accepted_orders;
    }

    public TechSupportSpecialist() {
    }
    {
        Data data = Data.getInstance();
        data.addUser(this);
    }

    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    public void addOrder(Order o){
        orders.add(o);
    }

    @Override
    public void update() {

    }
}
