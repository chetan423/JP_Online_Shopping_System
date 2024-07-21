package JP_Online_Shopping_System;

public class Product {
    private int productID;
    private String name;
    private double price;
    private String description;
    private int quantity;

    public Product(int productID, String name, double price, String description, int quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    // Methods
    public void displayProductInfo() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);
        System.out.println("Available Quantity: " + quantity);
    }

    public void updateStock(int quantitySold) {
        if (quantity >= quantitySold) {
            quantity -= quantitySold;
            System.out.println(quantitySold + " units of " + name + " sold.");
        } else {
            System.out.println("Insufficient stock for " + name);
        }
    }
}
