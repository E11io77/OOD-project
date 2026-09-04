package com.myApp.application;
import com.myApp.domain.Material;
import com.myApp.domain.Product;
import java.util.List;

public class RecyclingGuidanceService {
    
    public List<Material> getGuidance(Product product) {
        return product.getMaterials();
    }
}