package com.myApp.presentation;
import com.myApp.domain.SimpleSumStrategy;
import com.myApp.domain.WeightedByLifespanStrategy;
import com.myApp.application.ProductService;
import com.myApp.application.RecyclingGuidanceService;
import com.myApp.application.MaterialService;
import com.myApp.domain.Material;
import com.myApp.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ProductMenu {
    private Scanner scanner;
    private ProductService productService;
    private MaterialService materialService;

    public ProductMenu(Scanner scanner, ProductService productService, RecyclingGuidanceService recyclingGuidanceService, MaterialService materialService) {
                this.scanner = scanner;
                this.productService = productService;
                this.materialService = materialService;
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
            addNewProduct();
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
        System.out.println(guidance);
        }

    
    private void addNewProduct () {
        System.out.println("--- Adding product ---");
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter category: ");
        String category = scanner.nextLine();

        System.out.println("Enter life span: ");
        int lifeSpan = Integer.parseInt(scanner.nextLine()); // po zadání nechá znak \n, další scanner vyhodnotí jako prázdná řádek - proto nextLine a pak se převede na číslo

        List<Material> selectedMaterials = new ArrayList<>();
        List<Material> availableMaterials = materialService.listMaterials();
        
        boolean selectingMaterials = true;
            while (selectingMaterials) {
            System.out.println("Enter materials: ");
            System.out.println("\nPlease choose from the list of materials");
            System.out.println("\nOnce done, press D");
            for (int i = 0; i < availableMaterials.size(); i++) {
                System.out.println((i + 1) + ". " + availableMaterials.get(i).getName());
            }

            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("D")) {
                selectingMaterials = false;
            } else {
                int index = Integer.parseInt(choice) - 1;
                selectedMaterials.add(availableMaterials.get(index));
                System.out.println("Added: " + availableMaterials.get(index).getName());
            }
    }

        Product product = new Product(name, category, lifeSpan, selectedMaterials);
        productService.addProduct(product);
        System.out.println("Product added!");
    }

    }
