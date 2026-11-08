
package repository;

import model.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private final Map<Integer, Order> orders = new HashMap<>();

    public boolean addOrder(Order order) {
        if (orders.containsKey(order.getOrderId())) {
            return false;
        }

        orders.put(order.getOrderId(), order);
        return true;
    }

    public Order findById(int orderId) {
        return orders.get(orderId);
    }

    public Collection<Order> getAllOrders() {
        return orders.values();
    }

    public boolean updateStatus(int orderId, String status) {
        Order order = orders.get(orderId);

        if (order == null) {
            return false;
        }

        order.setStatus(status);
        return true;
    }
}
