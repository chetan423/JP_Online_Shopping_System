package JP_Online_Shopping_System;

import java.util.*;

public class Administrator {
    private Map<Integer, Product> products;
    private Map<Integer, User> users;
    private int nextProductID;
    private int nextUserID;

    public Administrator() {
        products = new HashMap<>();
        users = new HashMap<>();
        nextProductID = 1;
        nextUserID = 1;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void addProduct(String name, double price, String description, int quantity) {
        products.put(nextProductID, new Product(nextProductID, name, price, description, quantity));
        System.out.println("Product added successfully. Product ID: " + nextProductID);
        nextProductID++;
    }

    public void addUser(String name) {
        users.put(nextUserID, new User(nextUserID, name));
        System.out.println("User added successfully. User ID: " + nextUserID);
        nextUserID++;
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Available Products:");
            for (Product product : products.values()) {
                product.displayProductInfo();
                System.out.println();
            }
        }
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("Registered Users:");
            for (User user : users.values()) {
                System.out.println("User ID: " + user.getUserID() + " | Name: " + user.getName());
            }
        }
    }

    public void processOrders() {
        System.out.println("Processing orders...");
        for (User user : users.values()) {
            user.placeOrder(products);
            user.getOrderHistory().add(user.getUserID()); // Simulated order history storage
        }
    }
}          
