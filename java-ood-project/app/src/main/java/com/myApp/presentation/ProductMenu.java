package com.myApp.presentation;
import com.myApp.application.ProductService;
import com.myApp.domain.Material;
import com.myApp.domain.Product;
import java.util.List;
import java.util.Scanner;
public class ProductMenu {
    private Scanner scanner;
    private ProductService productService;
    public ProductMenu(Scanner scanner, ProductService productService) {
                this.scanner = scanner;
                this.productService = productService;
    }
    public void show() {
        boolean inMenu = true;
        while (inMenu) {
            printMenu();
            String choice = scanner.nextLine ();

            switch (choice) {
                case "1":
                    Product selected = handleProductSelection();
                    if (selected != null) {
                        showProductActions(selected);
                    };
                    break;
                case "b":
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. PLease try again.");
                    break;
            }
        }
    }

    //private void listProducts() {
    //    List<Product> products = productService.listProducts();
    //        if (products.isEmpty()) {
    //        System.out.println("No products found.");
    //        return; 
    //    }
    //    }
    //     System.out.println("\n--- All Products ---");
    //    for (Product product : products) {
    //        System.out.println(product.getName() + " | " + product.getCategory());
    //}
    //}
    //
//
    //private void selectProducts() {
//
    //}

    private Product handleProductSelection() {
        List<Product> products = productService.listProducts();

        System.out.println("\n--- Select a Product ---");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " | " + products.get(i).getCategory());
        }
        
        System.out.println("A. Add new product");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("A")) {
            System.out.println("pass");
            return null;
        }

        int index = Integer.parseInt(choice) - 1;
        return products.get(index);
    }

    private void showProductActions(Product product) {
        System.out.println("\n--- Selected: " + product.getName() + " ---");
        System.out.println("1. Show recycling instructions");
        System.out.println("2. Calculate impact value");
        System.out.println("B. Back");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                showRecyclingInstructions(product);
                break;
            case "2":
                System.out.println("Impact calculation - coming soon!");
                break;
            case "b":
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }


    private void printMenu() {
        System.out.println("\n--- Product Menu ---");
        System.out.println("1. Select a product");
        System.out.println("b. Back");
        System.out.print("Your choice: ");
    }
    
    private void showRecyclingInstructions(Product product) {
        System.out.println("\n--- Recycling Instructions for " + product.getName() + " ---");

        for (Material material : product.getMaterials()) {
            System.out.println("\nMaterial: " + material.getName() 
                               + " (" + material.getRecyclingCategory() + ")");
            System.out.println("Instructions:");

            for (String instruction : material.getRecyclingGuidance()) {
                System.out.println("  - " + instruction);
            }
        }
    }

}
