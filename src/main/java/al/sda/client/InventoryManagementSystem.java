package al.sda.client;

import al.sda.Dto.ProductDto;
import al.sda.Entity.Product;
import al.sda.service.ProductService;
import al.sda.service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Find product by id");
            System.out.println("4. Notify low stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    findProductByID(scanner);
                    break;
                case 4:
                    notifyLowStock(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void createProduct(Scanner scanner) {
        System.out.println("Enter product name: ");
        String name = scanner.next();
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }

        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        if(price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        if(quantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }

        System.out.println("Enter product description: ");
        String description = scanner.next();
        if(description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Product description cannot be empty");
        }
        System.out.println("Enter product category: ");
        long category = scanner.nextLong();
        if(category < 0) {
            throw new IllegalArgumentException("Product category cannot be negative");
        }
        // Creating the product
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);
        productDto.setDescription(description);
        productDto.setCategoryId(category);

        ProductService productService = new ProductServiceImpl();
        productService.createProduct(productDto);
    }

    private static void displayAllProducts() {
        ProductService productService = new ProductServiceImpl();
        List<Product> productDtos = productService.getAllProducts();

        if (productDtos.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product productDto : productDtos) {
                System.out.println(productDto);
            }
        }
    }

    private static void findProductByID(Scanner scanner) {
        System.out.println("Enter product id");
        int id = scanner.nextInt();
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findOne((long) id);
        if (product != null) {
            System.out.println(product);
        }else{
            System.out.println("Invalid product id");
        }
    }

    private static void notifyLowStock(Scanner scanner) {
        System.out.println("Low stock products have been added to the inventory.");
        System.out.println("Ju lutem fusni limit stock");
        int limitStock = scanner.nextInt();
        ProductService productService = new ProductServiceImpl();
        List<Product> productList =
                productService.getAllProducts();
        for (Product product: productList) {
            if(product.getQuantity() <= limitStock) {
                System.out.println(product);
            }
        }
    }

}
