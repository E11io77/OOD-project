package com.myApp.domain;
import java.util.List;
public class Product {
    private String name;
    private String category;
    private int estimatedLifeSpan;
    private List<Material> materials;

    public Product(String name, String category, int estimatedLifeSpan, List<Material> materials) {
        this.name = name;
        this.category = category;
        this.estimatedLifeSpan = estimatedLifeSpan;
        this.materials = materials;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getEstimatedLifeSpan() { return estimatedLifeSpan; }
    public List<Material> getMaterials() { return materials; }
}
