package com.myApp.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myApp.domain.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataLoader {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static class DataWrapper {
        public List<MaterialData> materials;
        public List<ProductData> products;
    }

    private static class MaterialData {
        public String name;
        public RecyclingCategory recyclingCategory;
        public List<String> recyclingGuidance;
        public double environmentalImpactValue;
    }

    private static class ProductData {
        public String name;
        public String category;
        public int estimatedLifeSpan;
        public List<String> materialNames;
    }

    @SuppressWarnings("assignment.type.incompatible")
    public void load(String filePath,
                    MaterialRepository materialRepository,
                    ProductRepository productRepository) {
        try {
            @SuppressWarnings("null")
            DataWrapper data = objectMapper.readValue(new File(filePath), DataWrapper.class);
            for (MaterialData md : data.materials) {
                Material material = new Material(md.name, md.recyclingCategory, md.recyclingGuidance, md.environmentalImpactValue);
                materialRepository.addMaterial(material);
            }

            for (ProductData pd : data.products) {

                List<Material> materials = new ArrayList<>();
                for (String materialName : pd.materialNames) {
                    Optional<Material> found = materialRepository.findByName(materialName);
                    if (found.isPresent()) {
                        materials.add(found.get());
                    }
                }

                Product product = new Product(pd.name, pd.category, pd.estimatedLifeSpan, materials);
                productRepository.addProduct(product);
            }

            System.out.println("Data loaded!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}