
package model;

public class Product {

    private final int productId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    public Product(int productId, String name, String category,
                   double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ID: " + productId
                + " | Name: " + name
                + " | Category: " + category
                + " | Price: Rs. " + String.format("%.2f", price)
                + " | Stock: " + stockQuantity;
    }
}
