package com.myApp.presentation;

import java.util.Scanner;
public class MainMenu {
    private Scanner scanner;
    private ProductMenu productMenu;
    private MaterialMenu materialMenu;

     public MainMenu(Scanner scanner, ProductMenu productMenu, MaterialMenu materialMenu) {
        this.scanner = scanner;
        this.productMenu = productMenu;
        this.materialMenu = materialMenu;
    }


    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    productMenu.show();
                    break;
                case "2":
                    materialMenu.show();
                    break;
                case "E":
                    System.out.println("Thank you and have a good day!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try ahain.");
            }
            
        }
        
    }
    private void printMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Products");
        System.out.println("2. Materials");
        System.out.println("E. Exit");
        System.out.print("Your choice: ");
    }
}
