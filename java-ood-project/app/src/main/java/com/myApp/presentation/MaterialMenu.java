package com.myApp.presentation;
import com.myApp.domain.Material;
import com.myApp.domain.RecyclingCategory;
import com.myApp.application.MaterialService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MaterialMenu {
    private Scanner scanner;
    private MaterialService materialService;
    public MaterialMenu(Scanner scanner, MaterialService materialService) {
                this.scanner = scanner;
                this.materialService = materialService;
    }
    public void show() {
        boolean inMenu = true;
        while (inMenu) {
            printMenu();
            String choice = scanner.nextLine ();

            switch (choice) {
                case "1":
                    addMaterial();
                    break;
                case "2":
                    listMaterials();
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


    private void addMaterial() {
        System.out.println("--- Adding material ---");

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Choose recycling category: ");

        RecyclingCategory[] categories = RecyclingCategory.values();
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ". " + categories[i]);
            }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
            RecyclingCategory category = categories[index];

        System.out.println("Enter recycling instructions: ");
        System.out.println("Recycling instructions would be added by an administrator, not end user.");
        List<String> recyclingGuidance = new ArrayList<>();
        System.out.println("Enter impact value: ");
        double impact = Double.parseDouble(scanner.nextLine());

        Material material = new Material(name, category, recyclingGuidance, impact);
        materialService.addMaterial(material);

    }

    private void listMaterials() {
        List<Material> materials = materialService.listMaterials();

        if (materials.isEmpty()) {
            System.out.println("No materials found.");
            return;
        }
    
        System.out.println("\n--- All Materials ---");
        for (Material material : materials) {
            System.out.println(material.getName() + " | " + material.getRecyclingCategory());
    }
    }

    private void printMenu() {
        System.out.println("\n--- Material Menu ---");
        System.out.println("1. Add material");
        System.out.println("2. List all materials");
        System.out.println("b. Back");
        System.out.print("Your choice: ");
    }

}
