package Users;

import Messages.Order;

import java.util.List;


public class TechSupportSpecialist extends Employee {
    protected static List<Order> orders;
    protected static List<Order> accepted_orders;




    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    @Override
    public void update() {

    }
}
