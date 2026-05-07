package com.myApp.presentation;
import com.myApp.domain.Material;
import com.myApp.application.MaterialService;
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
        System.out.println("Adding material - coming soon!");

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
