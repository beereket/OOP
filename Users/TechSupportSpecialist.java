package Users;

import Messages.Order;

import java.util.List;


public class TechSupportSpecialist extends Employee {
    private static List<Order> orders;
    private static List<Order> accepted_orders;


    public TechSupportSpecialist() {
    }

    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    public static void addOrder(Order o){
        orders.add(o);
    }

    @Override
    public void update() {

    }
}
