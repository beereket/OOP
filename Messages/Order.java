package Messages;


import java.io.Serializable;
import java.util.Objects;
/**
 * Represents an order with a unique order ID and a description.
 */
public class Order implements Serializable {
    private static int num;
    private int orderId;
    
    private String description;

    public Order(String description) {
        this.description = description;
        orderId = num;
        num++;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Order.num = num;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }
}
