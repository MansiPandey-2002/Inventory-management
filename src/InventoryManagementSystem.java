import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    private ArrayList<Product> products;
    private Scanner scanner;

    public InventoryManagementSystem() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.println("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, quantity, price);
        products.add(product);

        System.out.println("Product added successfully!");
    }

    public void updateProduct() {
        System.out.println("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Enter new name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    product.setName(name);
                }

                System.out.println("Enter new quantity (leave blank to keep current): ");
                String quantityStr = scanner.nextLine();
                if (!quantityStr.isEmpty()) {
                    int quantity = Integer.parseInt(quantityStr);
                    product.setQuantity(quantity);
                }

                System.out.println("Enter new price (leave blank to keep current): ");
                String priceStr = scanner.nextLine();
                if (!priceStr.isEmpty()) {
                    double price = Double.parseDouble(priceStr);
                    product.setPrice(price);
                }

                System.out.println("Product updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void removeProduct() {
        System.out.println("Enter Product ID to remove: ");
        int id = scanner.nextInt();

        products.removeIf(product -> product.getId() == id);

        System.out.println("Product removed successfully!");
    }

    public void searchProduct() {
        System.out.println("Enter Product ID to search: ");
        int id = scanner.nextInt();

        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void displayMenu() {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Search Product");
        System.out.println("5. List Products");
        System.out.println("6. Exit");
    }

    public void start() {
        while (true) {
            displayMenu();
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    listProducts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.start();
    }
}
