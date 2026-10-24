
package UI;

import model.CartItem;
import model.Product;
import model.ShoppingCart;
import repository.ProductRepository;

import javax.swing.*;
import java.awt.*;

public class CartFrame extends JFrame {

    private final ProductRepository productRepository;
    private final ShoppingCart cart;

    private final JTextField productIdField = new JTextField();
    private final JTextField quantityField = new JTextField("1");
    private final JTextArea outputArea = new JTextArea();

    public CartFrame(ProductRepository productRepository,
                     ShoppingCart cart) {

        this.productRepository = productRepository;
        this.cart = cart;

        setTitle("Shopping Cart");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        form.add(new JLabel("Product ID:"));
        form.add(productIdField);

        form.add(new JLabel("Quantity:"));
        form.add(quantityField);

        JButton addButton = new JButton("Add to Cart");
        JButton viewButton = new JButton("View Cart");
        JButton updateButton = new JButton("Update Quantity");
        JButton removeButton = new JButton("Remove Item");
        JButton clearButton = new JButton("Clear Cart");

        JPanel buttons = new JPanel(new GridLayout(2, 3, 8, 8));
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(updateButton);
        buttons.add(removeButton);
        buttons.add(clearButton);

        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        addButton.addActionListener(e -> addToCart());
        viewButton.addActionListener(e -> viewCart());
        updateButton.addActionListener(e -> updateQuantity());
        removeButton.addActionListener(e -> removeItem());

        clearButton.addActionListener(e -> {
            cart.clearCart();
            viewCart();
        });

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addToCart() {
        try {
            int id = Integer.parseInt(productIdField.getText().trim());
            int quantity = Integer.parseInt(
                    quantityField.getText().trim()
            );

            Product product = productRepository.findById(id);

            if (product == null) {
                showMessage("Product not found. Add it in Product Catalog first.");
                return;
            }

            if (cart.addProduct(product, quantity)) {
                viewCart();
            } else {
                showMessage(
                        "Invalid quantity or insufficient stock."
                );
            }

        } catch (NumberFormatException ex) {
            showMessage("Enter valid numeric product ID and quantity.");
        }
    }

    private void updateQuantity() {
        try {
            int id = Integer.parseInt(productIdField.getText().trim());
            int quantity = Integer.parseInt(
                    quantityField.getText().trim()
            );

            if (cart.updateQuantity(id, quantity)) {
                viewCart();
            } else {
                showMessage(
                        "Could not update. Check the product ID, quantity and stock."
                );
            }

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid product ID and quantity.");
        }
    }

    private void removeItem() {
        try {
            int id = Integer.parseInt(productIdField.getText().trim());

            if (cart.removeProduct(id)) {
                viewCart();
            } else {
                showMessage("That product is not in the cart.");
            }

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid product ID.");
        }
    }

    private void viewCart() {
        if (cart.isEmpty()) {
            outputArea.setText("Your shopping cart is empty.");
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append("YOUR SHOPPING CART\n");
        result.append("==============================\n");

        for (CartItem item : cart.getItems()) {
            result.append(item).append("\n");
        }

        result.append("==============================\n");
        result.append("TOTAL: Rs. ")
                .append(String.format("%.2f", cart.getTotal()));

        outputArea.setText(result.toString());
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
