package JP_Online_Shopping_System;

import java.util.Scanner;

public class OnlineSystem {
    public static void main(String[] args) {
        Administrator admin = new Administrator();
        Scanner scanner = new Scanner(System.in);

        // Example usage
        admin.addProduct("Laptop", 999.99, "High-performance laptop", 10);
        admin.addProduct("Smartphone", 499.99, "Latest smartphone model", 20);
        admin.addUser("Alice");
        admin.addUser("Bob");

        admin.viewProducts();
        admin.viewUsers();

        User alice = admin.getUsers().get(1);
        User bob = admin.getUsers().get(2);

        alice.addToCart(admin.getProducts().get(1), 1); // Add 1 laptop to Alice's cart
        alice.addToCart(admin.getProducts().get(2), 2); // Add 2 smartphones to Alice's cart

        bob.addToCart(admin.getProducts().get(2), 1); // Add 1 smartphone to Bob's cart

        admin.processOrders(); // Process all orders
    }
}
