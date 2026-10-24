
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private final int orderId;
    private final LocalDateTime orderDate;
    private final double totalAmount;
    private String status;

    public Order(int orderId, double totalAmount) {
        this.orderId = orderId;
        this.orderDate = LocalDateTime.now();
        this.totalAmount = totalAmount;
        this.status = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "Order ID: " + orderId
                + " | Date: " + orderDate.format(formatter)
                + " | Total: Rs. "
                + String.format("%.2f", totalAmount)
                + " | Status: " + status;
    }
}
