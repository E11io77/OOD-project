package com.myApp.application;
import com.myApp.domain.Material;
import com.myApp.domain.Product;

public class RecyclingGuidanceService {

    public static String getGuidance(Product product) {
        String result = "";
        for (Material material : product.getMaterials()) {
            result += "\nMaterial: " + material.getName() 
                    + " (" + material.getRecyclingCategory() + ")\n";
            for (String instruction : material.getRecyclingGuidance()) {
                result += "  - " + instruction + "\n";
            }
        }
        return result;
    }
}