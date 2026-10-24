
package model;

public class Customer {

    private final int customerId;
    private String name;
    private String email;
    private String address;
    private String city;
    private String phoneNo;
    private String password;

    public Customer(
            int customerId,
            String name,
            String email,
            String address,
            String city,
            String phoneNo,
            String password
    ) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public boolean checkPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return customerId + " | " + name + " | " + email
                + " | " + city + " | " + phoneNo;
    }
}
