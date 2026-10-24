
package repository;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {

    private final Map<Integer, Customer> customers = new HashMap<>();

    public boolean addCustomer(Customer customer) {
        if (customers.containsKey(customer.getCustomerId())) {
            return false;
        }

        customers.put(customer.getCustomerId(), customer);
        return true;
    }

    public Customer findById(int customerId) {
        return customers.get(customerId);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

    public boolean deleteCustomer(int customerId) {
        return customers.remove(customerId) != null;
    }

    public boolean updateCustomer(Customer customer) {
        if (!customers.containsKey(customer.getCustomerId())) {
            return false;
        }

        customers.put(customer.getCustomerId(), customer);
        return true;
    }

    public Customer findByName(String name) {
        for (Customer customer : customers.values()) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }

        return null;
    }

    public Customer findByCity(String city) {
        for (Customer customer : customers.values()) {
            if (customer.getCity().equalsIgnoreCase(city)) {
                return customer;
            }
        }

        return null;
    }

    public Customer findByPhoneNo(String phoneNo) {
        for (Customer customer : customers.values()) {
            if (customer.getPhoneNo().equals(phoneNo)) {
                return customer;
            }
        }

        return null;
    }
}
