package Users;

import Messages.Order;

import java.io.Serializable;
import java.util.List;


public class TechSupportSpecialist extends Employee implements Serializable {
    protected static List<Order> orders;
    protected static List<Order> accepted_orders;


    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    //MENU
    @Override
    public void run(){

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
