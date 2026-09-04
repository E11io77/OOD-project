package com.myApp;

import java.util.Scanner;

import com.myApp.application.MaterialService;
import com.myApp.application.ProductService;
import com.myApp.application.RecyclingGuidanceService;
import com.myApp.domain.ImpactCalculator;
import com.myApp.domain.SimpleSumStrategy;
import com.myApp.domain.LocalMaterialRepository;
import com.myApp.domain.LocalProductRepository;
import com.myApp.presentation.MainMenu;
import com.myApp.presentation.MaterialMenu;
import com.myApp.presentation.ProductMenu;
import com.myApp.infrastructure.DataLoader;

public class Main {
    public static void main(String[] args) {

        LocalMaterialRepository materialRepository = new LocalMaterialRepository();
        LocalProductRepository productRepository = new LocalProductRepository();

        ImpactCalculator impactCalculator = new SimpleSumStrategy();
        MaterialService materialService = new MaterialService(materialRepository);
        ProductService productService = new ProductService(productRepository, impactCalculator);

        DataLoader dataLoader = new DataLoader();
        try {
            String filePath = new java.io.File(
                Main.class.getClassLoader().getResource("data.json").toURI()
            ).getPath();
            dataLoader.load(filePath, materialRepository, productRepository);
        } catch (Exception e) {
            System.out.println("Could not load data: " + e.getMessage());
        }

        

        Scanner scanner = new Scanner(System.in);
        RecyclingGuidanceService recyclingGuidanceService = new RecyclingGuidanceService();
        ProductMenu productMenu = new ProductMenu(scanner, productService, recyclingGuidanceService, materialService);
        MaterialMenu materialMenu = new MaterialMenu(scanner, materialService);

        MainMenu mainMenu = new MainMenu(scanner, productMenu, materialMenu);
        mainMenu.start();
        scanner.close();
    }
}