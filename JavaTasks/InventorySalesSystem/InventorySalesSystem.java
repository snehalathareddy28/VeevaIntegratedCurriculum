package InventorySalesSystem;
import java.math.BigDecimal;
import java.util.*;

    public class InventorySalesSystem {

        // 1. Company directory
        static HashMap<String, Company> companies = new HashMap<>();

        // 2. Product catalogue
        static HashMap<String, Product> products = new HashMap<>();

        // Product name -> Product ID
        static HashMap<String, String> productNameIndex = new HashMap<>();

        // 3. Inventory tracker
        static HashMap<String, Integer> inventory = new HashMap<>();

        // 4. Sales transaction history
        static ArrayList<SaleTransaction> transactions = new ArrayList<>();

        // Transaction ID counter
        static int transactionCounter = 1001;

        // Normalize IDs and names
        static String normalize(String value) {
            return value.trim().toLowerCase();
        }

        // ------------------------------------------------
        // 1. ADD COMPANY
        // ------------------------------------------------

        static void addCompany(String id, String name,
                               String contact, String location) {

            if (id == null || id.isBlank()
                    || name == null || name.isBlank()) {

                System.out.println("Invalid company details!");
                return;
            }

            String companyId = normalize(id);

            if (companies.containsKey(companyId)) {
                System.out.println("Company ID already exists!");
                return;
            }

            companies.put(companyId,
                    new Company(id.trim(), name.trim(),
                            contact, location));

            System.out.println("Company added successfully!");
        }

        // ------------------------------------------------
        // 2. UPDATE COMPANY
        // ------------------------------------------------

        static void updateCompany(String id, String newName,
                                  String newContact, String newLocation) {

            String companyId = normalize(id);

            if (!companies.containsKey(companyId)) {
                System.out.println("Company not found!");
                return;
            }

            Company company = companies.get(companyId);

            company.setCompanyName(newName);
            company.setContactDetails(newContact);
            company.setLocation(newLocation);

            System.out.println("Company updated successfully!");
        }

        // ------------------------------------------------
        // 3. DISPLAY COMPANIES
        // ------------------------------------------------

        static void displayCompanies() {

            if (companies.isEmpty()) {
                System.out.println("No companies available!");
                return;
            }

            for (Company company : companies.values()) {
                System.out.println(company);
            }
        }

        // ------------------------------------------------
        // 4. ADD PRODUCT
        // ------------------------------------------------

        static void addProduct(String id, String name,
                               BigDecimal price, String category,
                               String companyId, int quantity) {

            String productId = normalize(id);
            String productName = normalize(name);
            String company = normalize(companyId);

            if (id == null || id.isBlank()
                    || name == null || name.isBlank()
                    || price == null || price.compareTo(BigDecimal.ZERO) <= 0
                    || quantity < 0) {

                System.out.println("Invalid product details!");
                return;
            }

            if (products.containsKey(productId)) {
                System.out.println("Product ID already exists!");
                return;
            }

            if (productNameIndex.containsKey(productName)) {
                System.out.println("Product name already exists!");
                return;
            }

            if (!companies.containsKey(company)) {
                System.out.println("Associated company not found!");
                return;
            }

            Product product = new Product(
                    id.trim(), name.trim(), price,
                    category, companyId.trim()
            );

            products.put(productId, product);

            productNameIndex.put(productName, productId);

            inventory.put(productId, quantity);

            System.out.println("Product added successfully!");
        }

        // ------------------------------------------------
        // 5. UPDATE PRODUCT
        // ------------------------------------------------

        static void updateProduct(String id, String newName,
                                  BigDecimal newPrice, String newCategory,
                                  String newCompanyId) {

            String productId = normalize(id);

            if (!products.containsKey(productId)) {
                System.out.println("Product not found!");
                return;
            }

            if (newName == null || newName.isBlank()
                    || newPrice == null
                    || newPrice.compareTo(BigDecimal.ZERO) <= 0) {

                System.out.println("Invalid product details!");
                return;
            }

            String newNameKey = normalize(newName);
            String company = normalize(newCompanyId);

            String existingProductId = productNameIndex.get(newNameKey);

            if (existingProductId != null
                    && !existingProductId.equals(productId)) {

                System.out.println("Product name already belongs to another product!");
                return;
            }

            if (!companies.containsKey(company)) {
                System.out.println("Company not found!");
                return;
            }

            Product product = products.get(productId);

            // Remove old product name from index
            productNameIndex.remove(normalize(product.getProductName()));

            // Update product details
            product.setProductName(newName.trim());
            product.setPrice(newPrice);
            product.setCategory(newCategory);
            product.setCompanyId(newCompanyId.trim());

            // Add updated product name
            productNameIndex.put(newNameKey, productId);

            System.out.println("Product updated successfully!");
        }

        // ------------------------------------------------
        // 6. PRICE LOOKUP BY PRODUCT ID
        // ------------------------------------------------

        static void findPriceById(String id) {

            String productId = normalize(id);

            if (!products.containsKey(productId)) {
                System.out.println("Product not found!");
                return;
            }

            Product product = products.get(productId);

            System.out.println("Product: " + product.getProductName());
            System.out.println("Price: Rs." + product.getPrice());
        }

        // ------------------------------------------------
        // 7. PRICE LOOKUP BY PRODUCT NAME
        // ------------------------------------------------

        static void findPriceByName(String name) {

            String productId = productNameIndex.get(normalize(name));

            if (productId == null) {
                System.out.println("Product not found!");
                return;
            }

            Product product = products.get(productId);

            System.out.println("Product: " + product.getProductName());
            System.out.println("Price: Rs." + product.getPrice());
        }

        // ------------------------------------------------
        // 8. DISPLAY PRODUCT CATALOGUE
        // ------------------------------------------------

        static void displayProducts() {

            if (products.isEmpty()) {
                System.out.println("No products available!");
                return;
            }

            for (Map.Entry<String, Product> entry : products.entrySet()) {

                String id = entry.getKey();

                System.out.println(entry.getValue());

                System.out.println("Available Stock: "
                        + inventory.get(id));

                System.out.println("-------------------------");
            }
        }

        // ------------------------------------------------
        // 9. CHECK STOCK
        // ------------------------------------------------

        static void checkStock(String id) {

            String productId = normalize(id);

            if (!products.containsKey(productId)) {
                System.out.println("Product not found!");
                return;
            }

            int available = inventory.get(productId);

            System.out.println("Product: "
                    + products.get(productId).getProductName());

            System.out.println("Available quantity: " + available);

            if (available == 0) {
                System.out.println("ALERT: Product is out of stock!");
            }
        }

        // ------------------------------------------------
        // 10. PROCESS MULTI-PRODUCT SALE
        // ------------------------------------------------

        static void processSale(Map<String, Integer> order) {

            if (order == null || order.isEmpty()) {
                System.out.println("Order cannot be empty!");
                return;
            }

            BigDecimal totalAmount = BigDecimal.ZERO;

            // Temporary map to store validated product details
            LinkedHashMap<String, Integer> validatedOrder =
                    new LinkedHashMap<>();

            // Temporary map to store transaction details
            LinkedHashMap<String, Integer> soldProducts =
                    new LinkedHashMap<>();

            // STEP 1: VALIDATE ENTIRE ORDER
            for (Map.Entry<String, Integer> entry : order.entrySet()) {

                String productId = normalize(entry.getKey());

                Integer quantity = entry.getValue();

                if (quantity == null || quantity <= 0) {
                    System.out.println("Invalid order quantity!");
                    System.out.println("Transaction cancelled.");
                    return;
                }

                if (!products.containsKey(productId)) {
                    System.out.println("Product not found: "
                            + entry.getKey());

                    System.out.println("Transaction cancelled.");
                    return;
                }

                int available = inventory.get(productId);

                String productName =
                        products.get(productId).getProductName();

                if (available == 0) {

                    System.out.println("OUT OF STOCK ALERT: "
                            + productName);

                    System.out.println("Transaction cancelled.");
                    return;
                }

                if (quantity > available) {

                    System.out.println("INSUFFICIENT STOCK!");

                    System.out.println("Product: " + productName);

                    System.out.println("Requested quantity: " + quantity);

                    System.out.println("Available quantity: " + available);

                    System.out.println("Transaction cancelled.");
                    return;
                }

                // Calculate product total
                BigDecimal productTotal =
                        products.get(productId).getPrice()
                                .multiply(BigDecimal.valueOf(quantity));

                totalAmount = totalAmount.add(productTotal);

                validatedOrder.put(productId, quantity);

                soldProducts.put(productName, quantity);
            }

            // STEP 2: DEDUCT STOCK ONLY AFTER ALL VALIDATIONS PASS
            for (Map.Entry<String, Integer> entry
                    : validatedOrder.entrySet()) {

                String productId = entry.getKey();

                int quantity = entry.getValue();

                int available = inventory.get(productId);

                inventory.put(productId, available - quantity);
            }

            // STEP 3: CREATE TRANSACTION
            String transactionId = "T" + transactionCounter++;

            SaleTransaction transaction =
                    new SaleTransaction(
                            transactionId,
                            soldProducts,
                            totalAmount
                    );

            transactions.add(transaction);

            // STEP 4: DISPLAY SUCCESS
            System.out.println("\nSALE SUCCESSFUL!");

            System.out.println("Transaction ID: " + transactionId);

            for (Map.Entry<String, Integer> entry
                    : soldProducts.entrySet()) {

                System.out.println("Product: " + entry.getKey()
                        + " | Quantity: " + entry.getValue());
            }

            System.out.println("Total Amount: Rs." + totalAmount);
        }

        // ------------------------------------------------
        // 11. DISPLAY SALES HISTORY
        // ------------------------------------------------

        static void displayTransactions() {

            if (transactions.isEmpty()) {
                System.out.println("No successful transactions!");
                return;
            }

            System.out.println("\nSALES TRANSACTION HISTORY");

            for (SaleTransaction transaction : transactions) {
                System.out.println(transaction);
            }
        }

        // ------------------------------------------------
        // 12. MAIN METHOD
        // ------------------------------------------------

        public static void main(String[] args) {

            // ADD COMPANIES
            System.out.println("===== ADD COMPANIES =====");

            addCompany("C101", "TechWorld",
                    "9876543210", "Hyderabad");

            addCompany("C102", "DigitalStore",
                    "9876501234", "Bangalore");

            // ADD PRODUCTS
            System.out.println("\n===== ADD PRODUCTS =====");

            addProduct("P101", "Wireless Mouse",
                    new BigDecimal("25.00"),
                    "Accessories", "C101", 10);

            addProduct("P102", "Mechanical Keyboard",
                    new BigDecimal("75.00"),
                    "Accessories", "C101", 0);

            addProduct("P103", "Monitor",
                    new BigDecimal("200.00"),
                    "Electronics", "C102", 7);

            // DISPLAY PRODUCTS
            System.out.println("\n===== PRODUCT CATALOGUE =====");

            displayProducts();

            // PRICE LOOKUP
            System.out.println("\n===== PRICE LOOKUP =====");

            findPriceById("P101");

            findPriceByName("Monitor");

            // CHECK STOCK
            System.out.println("\n===== STOCK CHECK =====");

            checkStock("P102");

            // SUCCESSFUL SALE
            System.out.println("\n===== SUCCESSFUL SALE =====");

            Map<String, Integer> order1 = new LinkedHashMap<>();

            order1.put("P101", 3);

            processSale(order1);

            // INSUFFICIENT STOCK
            System.out.println("\n===== INSUFFICIENT STOCK TEST =====");

            Map<String, Integer> order2 = new LinkedHashMap<>();

            order2.put("P101", 12);

            processSale(order2);

            // OUT OF STOCK
            System.out.println("\n===== OUT OF STOCK TEST =====");

            Map<String, Integer> order3 = new LinkedHashMap<>();

            order3.put("P102", 1);

            processSale(order3);

            // MULTI-PRODUCT ORDER WITH ROLLBACK
            System.out.println("\n===== ROLLBACK TEST =====");

            Map<String, Integer> order4 = new LinkedHashMap<>();

            order4.put("P101", 2);
            order4.put("P103", 10);

            processSale(order4);

            // UPDATE COMPANY
            System.out.println("\n===== UPDATE COMPANY =====");

            updateCompany("C101", "TechWorld India",
                    "9999999999", "Hyderabad");

            // UPDATE PRODUCT
            System.out.println("\n===== UPDATE PRODUCT =====");

            updateProduct("P101", "Wireless Mouse",
                    new BigDecimal("30.00"),
                    "Computer Accessories", "C101");

            // DISPLAY FINAL STOCK
            System.out.println("\n===== FINAL INVENTORY =====");

            displayProducts();

            // DISPLAY SALES HISTORY
            System.out.println("\n===== TRANSACTION LOG =====");

            displayTransactions();
        }
}
