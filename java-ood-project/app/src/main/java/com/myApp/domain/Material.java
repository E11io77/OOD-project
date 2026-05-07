package com.myApp.domain;
import java.util.List;

public class Material {
    private String name;
    private RecyclingCategory recyclingCategory;
    private List<String> recyclingGuidance;
    private double environmentalImpactValue;

    public String getName() {
        return name;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
    public List<String> getRecyclingGuidance() {
        return recyclingGuidance;
    }

    public double getEnvironmentalImpactValue () {
        return environmentalImpactValue;
    }

    public Material(String name, RecyclingCategory RecyclingCategory, List<String> RecyclingGuidance, double eenvironmentalImpactValue) {
        this.name = name;
        this.recyclingCategory = RecyclingCategory;
        this.recyclingGuidance = RecyclingGuidance;
        this.environmentalImpactValue = environmentalImpactValue;
    }    
}
