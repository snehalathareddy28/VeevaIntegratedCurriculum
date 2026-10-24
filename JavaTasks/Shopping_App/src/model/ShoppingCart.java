
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final List<CartItem> items = new ArrayList<>();

    public boolean addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            return false;
        }

        if (quantity > product.getStockQuantity()) {
            return false;
        }

        for (CartItem item : items) {
            if (item.getProduct().getProductId()
                    == product.getProductId()) {

                int newQuantity = item.getQuantity() + quantity;

                if (newQuantity > product.getStockQuantity()) {
                    return false;
                }

                item.setQuantity(newQuantity);
                return true;
            }
        }

        items.add(new CartItem(product, quantity));
        return true;
    }

    public boolean removeProduct(int productId) {
        return items.removeIf(
                item -> item.getProduct().getProductId() == productId
        );
    }

    public boolean updateQuantity(int productId, int quantity) {
        if (quantity <= 0) {
            return false;
        }

        for (CartItem item : items) {
            if (item.getProduct().getProductId() == productId) {

                if (quantity > item.getProduct().getStockQuantity()) {
                    return false;
                }

                item.setQuantity(quantity);
                return true;
            }
        }

        return false;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
