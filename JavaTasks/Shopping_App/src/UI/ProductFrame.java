
package UI;

import model.Product;
import repository.ProductRepository;

import javax.swing.*;
import java.awt.*;

public class ProductFrame extends JFrame {

    private final ProductRepository repository;
    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField categoryField = new JTextField();
    private final JTextField priceField = new JTextField();
    private final JTextField stockField = new JTextField();
    private final JTextArea outputArea = new JTextArea();

    public ProductFrame(ProductRepository repository) {
        this.repository = repository;
        setTitle("Product Catalog");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        form.add(new JLabel("Product ID:"));
        form.add(idField);

        form.add(new JLabel("Product Name:"));
        form.add(nameField);

        form.add(new JLabel("Category:"));
        form.add(categoryField);

        form.add(new JLabel("Price (Rs.):"));
        form.add(priceField);

        form.add(new JLabel("Stock Quantity:"));
        form.add(stockField);

        JButton addButton = new JButton("Add Product");
        JButton viewButton = new JButton("View All");
        JButton searchIdButton = new JButton("Search by ID");
        JButton searchNameButton = new JButton("Search by Name");
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete by ID");
        JButton clearButton = new JButton("Clear Fields");

        JPanel buttons = new JPanel(new GridLayout(2, 4, 8, 8));
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(searchIdButton);
        buttons.add(searchNameButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);
        buttons.add(clearButton);

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        addButton.addActionListener(e -> addProduct());
        viewButton.addActionListener(e -> viewProducts());
        searchIdButton.addActionListener(e -> searchById());
        searchNameButton.addActionListener(e -> searchByName());
        updateButton.addActionListener(e -> updateProduct());
        deleteButton.addActionListener(e -> deleteProduct());
        clearButton.addActionListener(e -> clearFields());

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(form, BorderLayout.CENTER);
        topPanel.add(buttons, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addProduct() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            String category = categoryField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int stock = Integer.parseInt(stockField.getText().trim());

            if (id <= 0 || name.isEmpty() || category.isEmpty()
                    || price < 0 || stock < 0) {
                showMessage("Enter valid product details. ID must be positive; price and stock cannot be negative.");
                return;
            }

            Product product = new Product(
                    id, name, category, price, stock
            );

            if (repository.addProduct(product)) {
                outputArea.setText(
                        "Product added successfully:\n" + product
                );
                clearFields();
            } else {
                showMessage("Product ID already exists.");
            }

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid numeric ID, price and stock quantity.");
        }
    }

    private void viewProducts() {
        StringBuilder result = new StringBuilder();

        for (Product product : repository.getAllProducts()) {
            result.append(product).append("\n\n");
        }

        outputArea.setText(
                result.length() == 0
                        ? "No products found."
                        : result.toString()
        );
    }

    private void searchById() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            Product product = repository.findById(id);

            outputArea.setText(
                    product == null
                            ? "Product not found."
                            : product.toString()
            );

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid product ID.");
        }
    }

    private void searchByName() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            showMessage("Enter a product name.");
            return;
        }

        Product product = repository.findByName(name);

        outputArea.setText(
                product == null
                        ? "Product not found."
                        : product.toString()
        );
    }

    private void updateProduct() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            Product existing = repository.findById(id);

            if (existing == null) {
                outputArea.setText("Product not found.");
                return;
            }

            String name = nameField.getText().trim();
            String category = categoryField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int stock = Integer.parseInt(stockField.getText().trim());

            if (name.isEmpty() || category.isEmpty()
                    || price < 0 || stock < 0) {
                showMessage("Enter valid product details.");
                return;
            }

            existing.setName(name);
            existing.setCategory(category);
            existing.setPrice(price);
            existing.setStockQuantity(stock);

            repository.updateProduct(existing);

            outputArea.setText(
                    "Product updated successfully:\n" + existing
            );

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid ID, price and stock quantity.");
        }
    }

    private void deleteProduct() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            boolean deleted = repository.deleteProduct(id);

            outputArea.setText(
                    deleted
                            ? "Product deleted successfully."
                            : "Product not found."
            );

        } catch (NumberFormatException ex) {
            showMessage("Enter a valid product ID.");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        categoryField.setText("");
        priceField.setText("");
        stockField.setText("");
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
