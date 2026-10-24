
package repository;

import model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Integer, Product> products = new HashMap<>();

    public boolean addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            return false;
        }

        products.put(product.getProductId(), product);
        return true;
    }

    public Product findById(int productId) {
        return products.get(productId);
    }

    public Product findByName(String name) {
        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public boolean updateProduct(Product product) {
        if (!products.containsKey(product.getProductId())) {
            return false;
        }

        products.put(product.getProductId(), product);
        return true;
    }

    public boolean deleteProduct(int productId) {
        return products.remove(productId) != null;
    }
}
