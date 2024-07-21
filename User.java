package JP_Online_Shopping_System;

import java.util.*;

public class User {
    private int userID;
    private String name;
    private Map<Integer, Integer> shoppingCart; // ProductID -> Quantity
    private List<Integer> orderHistory; // Order IDs

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
        this.shoppingCart = new HashMap<>();
        this.orderHistory = new ArrayList<>();
    }

    // Getters
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public List<Integer> getOrderHistory() {
        return orderHistory;
    }

    // Methods
    public void addToCart(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            if (shoppingCart.containsKey(product.getProductID())) {
                shoppingCart.put(product.getProductID(), shoppingCart.get(product.getProductID()) + quantity);
            } else {
                shoppingCart.put(product.getProductID(), quantity);
            }
            System.out.println(quantity + " units of " + product.getName() + " added to cart.");
        } else {
            System.out.println("Insufficient stock for " + product.getName());
        }
    }

    public void removeFromCart(Product product, int quantity) {
        if (shoppingCart.containsKey(product.getProductID())) {
            int currentQuantity = shoppingCart.get(product.getProductID());
            if (quantity >= currentQuantity) {
                shoppingCart.remove(product.getProductID());
            } else {
                shoppingCart.put(product.getProductID(), currentQuantity - quantity);
            }
            System.out.println(quantity + " units of " + product.getName() + " removed from cart.");
        } else {
            System.out.println(product.getName() + " not found in cart.");
        }
    }

    public void placeOrder(Map<Integer, Product> products) {
        if (!shoppingCart.isEmpty()) {
            double totalAmount = 0;
            System.out.println("Order placed successfully:");
            System.out.println("Ordered Items:");
            for (Map.Entry<Integer, Integer> entry : shoppingCart.entrySet()) {
                int productID = entry.getKey();
                int quantity = entry.getValue();
                Product product = products.get(productID);
                if (product != null) {
                    double itemTotal = product.getPrice() * quantity;
                    totalAmount += itemTotal;
                    product.updateStock(quantity);
                    System.out.println(product.getName() + " x " + quantity + " = $" + itemTotal);
                }
            }
            System.out.println("Total Amount: $" + totalAmount);
            shoppingCart.clear(); // Clear cart after placing order
        } else {
            System.out.println("Shopping cart is empty. Add items to cart first.");
        }
    }
}
