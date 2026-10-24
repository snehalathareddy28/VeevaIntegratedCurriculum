
import javax.swing.*;
import java.awt.*;

import model.ShoppingCart;
import repository.ProductRepository;
import repository.OrderRepository;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Create shared repositories and shopping cart
            ProductRepository productRepository =
                    new ProductRepository();

            OrderRepository orderRepository =
                    new OrderRepository();

            ShoppingCart shoppingCart =
                    new ShoppingCart();

            // Main dashboard window
            JFrame frame =
                    new JFrame("E-Commerce Management System");

            frame.setSize(700, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Dashboard title
            JLabel title = new JLabel(
                    "Welcome to E-Commerce",
                    SwingConstants.CENTER
            );

            title.setFont(
                    new Font("Arial", Font.BOLD, 26)
            );

            // Dashboard buttons
            JButton customerButton =
                    new JButton("Customer Management");

            JButton productButton =
                    new JButton("Product Catalog");

            JButton cartButton =
                    new JButton("Shopping Cart");

            JButton orderButton =
                    new JButton("Order Management");

            // Arrange buttons in a 2 x 2 grid
            JPanel buttonPanel =
                    new JPanel(new GridLayout(2, 2, 15, 15));

            buttonPanel.add(customerButton);
            buttonPanel.add(productButton);
            buttonPanel.add(cartButton);
            buttonPanel.add(orderButton);

            // Main layout
            JPanel mainPanel =
                    new JPanel(new BorderLayout(20, 30));

            mainPanel.setBorder(
                    BorderFactory.createEmptyBorder(
                            40, 40, 40, 40
                    )
            );

            mainPanel.add(title, BorderLayout.NORTH);
            mainPanel.add(buttonPanel, BorderLayout.CENTER);

            // Open Customer Management
            customerButton.addActionListener(e ->
                    new ui.CustomerFrame()
            );

            // Open Product Catalog with shared repository
            productButton.addActionListener(e ->
                    new UI.ProductFrame(productRepository)
            );

            // Open Shopping Cart with shared products and cart
            cartButton.addActionListener(e ->
                    new UI.CartFrame(
                            productRepository,
                            shoppingCart
                    )
            );

            // Open Order Management with shared repository
            orderButton.addActionListener(e ->
                    new UI.OrderFrame(orderRepository)
            );

            // Display dashboard
            frame.setContentPane(mainPanel);
            frame.setVisible(true);
        });
    }
}
