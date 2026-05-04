package com.myApp.domain;
import java.util.List;

public class Material {
    private String name;
    private RecyclingCategory recyclingCategory;
    private List<String> recyclingGuidance;

    public String getName() {
        return name;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
    public List<String> getRecyclingGuidance() {
        return recyclingGuidance;
    }

    public Material(String name, RecyclingCategory RecyclingCategory, List<String> RecyclingGuidance) {
        this.name = name;
        this.recyclingCategory = RecyclingCategory;
        this.recyclingGuidance = RecyclingGuidance;
    }    
}
