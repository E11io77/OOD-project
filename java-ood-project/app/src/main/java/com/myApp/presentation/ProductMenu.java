package com.myApp.presentation;
import com.myApp.domain.SimpleSumStrategy;
import com.myApp.domain.WeightedByLifespanStrategy;
import com.myApp.application.ProductService;
import com.myApp.application.RecyclingGuidanceService;
import com.myApp.domain.Material;
import com.myApp.domain.Product;
import java.util.List;
import java.util.Scanner;
public class ProductMenu {
    private Scanner scanner;
    private ProductService productService;
    private RecyclingGuidanceService recyclingGuidanceService;

    public ProductMenu(Scanner scanner, ProductService productService, RecyclingGuidanceService recyclingGuidanceService) {
                this.scanner = scanner;
                this.productService = productService;
                this.recyclingGuidanceService = recyclingGuidanceService;
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
            System.out.println("Work in progress");
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
                chooseImpactStrategy(product);
                break;
            case "b":
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void chooseImpactStrategy(Product product) {
        System.out.println("\n--- Select Calculation Strategy ---");
        System.out.println("1. Simple sum (total material impact)");
        System.out.println("2. Weighted by lifespan (impact per year)");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine();
        switch (choice) {
        case "1":
            productService.setImpactCalculator(new SimpleSumStrategy());
            System.out.println("Strategy set: Simple sum");
            double sumImpact = productService.calculateImpact(product);
                System.out.printf("Environmental impact is: %.2f kg CO2%n", sumImpact);
            break;
        case "2":
            productService.setImpactCalculator(new WeightedByLifespanStrategy());
            System.out.println("Strategy set: Weighted by lifespan");
            double weightedImpact = productService.calculateImpact(product);
                System.out.printf("Yearly impact is: %.2f kg CO2%n", weightedImpact);
            break;
        default:
            System.out.println("Invalid choice, strategy unchanged.");
    }
    }

    private void printMenu() {
        System.out.println("\n--- Product Menu ---");
        System.out.println("1. Select a product");
        System.out.println("b. Back");
        System.out.print("Your choice: ");
    }
    
    private void showRecyclingInstructions(Product product) {
        String guidance = RecyclingGuidanceService.getGuidance(product);
        System.out.println("\n--- Recycling Instructions for " + product.getName() + " ---");

        for (Material material : product.getMaterials()) {
        System.out.println(guidance);
        }
    }

}
