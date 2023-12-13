package Messages;


public class Order {
    private static int num;
    private int orderId;
    
    private String description;

    public Order(String description) {
        this.description = description;
        orderId = num;
        num++;
    }

}
