
package ui;

import model.Customer;
import repository.CustomerRepository;

import javax.swing.*;
import java.awt.*;

public class CustomerFrame extends JFrame {

    private final CustomerRepository repository =
            new CustomerRepository();

    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JTextField addressField = new JTextField();
    private final JTextField cityField = new JTextField();
    private final JTextField phoneField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextArea outputArea = new JTextArea();

    public CustomerFrame() {
        setTitle("Customer Management");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(7, 2, 8, 8));
        form.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        form.add(new JLabel("Customer ID:"));
        form.add(idField);

        form.add(new JLabel("Name:"));
        form.add(nameField);

        form.add(new JLabel("Email:"));
        form.add(emailField);

        form.add(new JLabel("Address:"));
        form.add(addressField);

        form.add(new JLabel("City:"));
        form.add(cityField);

        form.add(new JLabel("Phone:"));
        form.add(phoneField);

        form.add(new JLabel("Password:"));
        form.add(passwordField);

        JButton addButton = new JButton("Add Customer");
        JButton viewButton = new JButton("View All");
        JButton searchButton = new JButton("Search by ID");
        JButton deleteButton = new JButton("Delete by ID");
        JButton updateButton = new JButton("Update Customer");

        JPanel buttons = new JPanel(new GridLayout(2, 3, 8, 8));
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(searchButton);
        buttons.add(deleteButton);
        buttons.add(updateButton);

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);

        addButton.addActionListener(e -> addCustomer());
        viewButton.addActionListener(e -> viewCustomers());
        searchButton.addActionListener(e -> searchCustomer());
        deleteButton.addActionListener(e -> deleteCustomer());
        updateButton.addActionListener(e -> updateCustomer());

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addCustomer() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String address = addressField.getText().trim();
            String city = cityField.getText().trim();
            String phone = phoneField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || email.isEmpty()
                    || address.isEmpty() || city.isEmpty()
                    || phone.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this, "Please fill in all fields."
                );
                return;
            }

            Customer customer = new Customer(
                    id, name, email, address, city, phone, password
            );

            if (repository.addCustomer(customer)) {
                outputArea.setText(
                        "Customer added successfully:\n" + customer
                );
                clearFields();
            } else {
                JOptionPane.showMessageDialog(
                        this, "Customer ID already exists."
                );
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Customer ID must be a valid integer."
            );
        }
    }

    private void viewCustomers() {
        StringBuilder result = new StringBuilder();

        for (Customer customer : repository.getAllCustomers()) {
            result.append(customer).append("\n");
        }

        outputArea.setText(
                result.length() == 0
                        ? "No customers found."
                        : result.toString()
        );
    }

    private void searchCustomer() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            Customer customer = repository.findById(id);

            outputArea.setText(
                    customer == null
                            ? "Customer not found."
                            : customer.toString()
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Enter a valid customer ID."
            );
        }
    }

    private void deleteCustomer() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            boolean deleted = repository.deleteCustomer(id);

            outputArea.setText(
                    deleted
                            ? "Customer deleted successfully."
                            : "Customer not found."
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Enter a valid customer ID."
            );
        }
    }

    private void updateCustomer() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            Customer existing = repository.findById(id);

            if (existing == null) {
                outputArea.setText("Customer not found.");
                return;
            }

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String address = addressField.getText().trim();
            String city = cityField.getText().trim();
            String phone = phoneField.getText().trim();

            if (name.isEmpty() || email.isEmpty()
                    || address.isEmpty() || city.isEmpty()
                    || phone.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Fill in all customer details to update."
                );
                return;
            }

            existing.setName(name);
            existing.setEmail(email);
            existing.setAddress(address);
            existing.setCity(city);
            existing.setPhoneNo(phone);

            boolean updated = repository.updateCustomer(existing);

            outputArea.setText(
                    updated
                            ? "Customer updated successfully:\n" + existing
                            : "Customer update failed."
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Enter a valid customer ID."
            );
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        addressField.setText("");
        cityField.setText("");
        phoneField.setText("");
        passwordField.setText("");
    }
}
