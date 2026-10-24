
package UI;

import model.Order;
import repository.OrderRepository;

import javax.swing.*;
import java.awt.*;

public class OrderFrame extends JFrame {

    private final OrderRepository repository;

    private final JTextField orderIdField = new JTextField();
    private final JComboBox<String> statusBox = new JComboBox<>(
            new String[]{
                    "PLACED",
                    "CONFIRMED",
                    "SHIPPED",
                    "DELIVERED",
                    "CANCELLED"
            }
    );

    private final JTextArea outputArea = new JTextArea();

    public OrderFrame(OrderRepository repository) {
        this.repository = repository;

        setTitle("Order Management");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        form.add(new JLabel("Order ID:"));
        form.add(orderIdField);

        form.add(new JLabel("New Status:"));
        form.add(statusBox);

        JButton viewButton = new JButton("View All Orders");
        JButton searchButton = new JButton("Search Order");
        JButton updateButton = new JButton("Update Status");

        JPanel buttons = new JPanel(new GridLayout(1, 3, 8, 8));
        buttons.add(viewButton);
        buttons.add(searchButton);
        buttons.add(updateButton);

        outputArea.setEditable(false);

        viewButton.addActionListener(e -> viewOrders());
        searchButton.addActionListener(e -> searchOrder());
        updateButton.addActionListener(e -> updateStatus());

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void viewOrders() {
        StringBuilder result = new StringBuilder();

        for (Order order : repository.getAllOrders()) {
            result.append(order).append("\n\n");
        }

        outputArea.setText(
                result.length() == 0
                        ? "No orders found."
                        : result.toString()
        );
    }

    private void searchOrder() {
        try {
            int id = Integer.parseInt(orderIdField.getText().trim());
            Order order = repository.findById(id);

            outputArea.setText(
                    order == null
                            ? "Order not found."
                            : order.toString()
            );

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid order ID.");
        }
    }

    private void updateStatus() {
        try {
            int id = Integer.parseInt(orderIdField.getText().trim());
            String status = (String) statusBox.getSelectedItem();

            if (repository.updateStatus(id, status)) {
                outputArea.setText("Order status updated successfully.");
            } else {
                outputArea.setText("Order not found.");
            }

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid order ID.");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
