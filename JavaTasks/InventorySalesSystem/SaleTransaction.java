package InventorySalesSystem;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaleTransaction {
        private String transactionId;

        // Product name -> quantity sold
        private Map<String, Integer> productsSold;

        private BigDecimal totalAmount;

        public SaleTransaction(String transactionId,
                               Map<String, Integer> productsSold,
                               BigDecimal totalAmount) {

            this.transactionId = transactionId;
            this.productsSold = new LinkedHashMap<>(productsSold);
            this.totalAmount = totalAmount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public Map<String, Integer> getProductsSold() {
            return new LinkedHashMap<>(productsSold);
        }

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        @Override
        public String toString() {

            return "Transaction ID: " + transactionId
                    + ", Products Sold: " + productsSold
                    + ", Total Amount: Rs." + totalAmount;
        }
    }

