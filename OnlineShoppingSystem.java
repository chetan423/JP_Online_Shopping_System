package JP_Online_Shopping_System;

import java.util.Scanner;

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Administrator admin = new Administrator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Add User");
            System.out.println("3. View Products");
            System.out.println("4. View Users");
            System.out.println("5. Add to Cart");
            System.out.println("6. Remove from Cart");
            System.out.println("7. Place Order");
            System.out.println("8. Process Orders");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    admin.addProduct(name, price, description, quantity);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    admin.addUser(userName);
                    break;
                case 3:
                    admin.viewProducts();
                    break;
                case 4:
                    admin.viewUsers();
                    break;
                case 5:
                    System.out.print("Enter user ID: ");
                    int userIDAdd = scanner.nextInt();
                    System.out.print("Enter product ID: ");
                    int productIDAdd = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantityAdd = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    User userAdd = admin.getUsers().get(userIDAdd);
                    Product productAdd = admin.getProducts().get(productIDAdd);
                    if (userAdd != null && productAdd != null) {
                        userAdd.addToCart(productAdd, quantityAdd);
                    } else {
                        System.out.println("Invalid user ID or product ID.");
                    }
                    break;
                case 6:
                    System.out.print("Enter user ID: ");
                    int userIDRemove = scanner.nextInt();
                    System.out.print("Enter product ID: ");
                    int productIDRemove = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantityRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    User userRemove = admin.getUsers().get(userIDRemove);
                    Product productRemove = admin.getProducts().get(productIDRemove);
                    if (userRemove != null && productRemove != null) {
                        userRemove.removeFromCart(productRemove, quantityRemove);
                    } else {
                        System.out.println("Invalid user ID or product ID.");
                    }
                    break;
                case 7:
                    System.out.print("Enter user ID: ");
                    int userIDOrder = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    User userOrder = admin.getUsers().get(userIDOrder);
                    if (userOrder != null) {
                        userOrder.placeOrder(admin.getProducts());
                    } else {
                        System.out.println("Invalid user ID.");
                    }
                    break;
                case 8:
                    admin.processOrders();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
