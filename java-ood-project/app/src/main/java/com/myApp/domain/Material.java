package com.myApp.domain;
import java.util.List;

public class Material {
    private String name;
    private RecyclingCategory recyclingCategory;
    private List<String> recyclingGuidance;

    public String getName() { return name; }
    public RecyclingCategory getRecyclingCategory() { return recyclingCategory; }
    public List<String> getRecyclingGuidance() { return recyclingGuidance; }

    public void setName(String name) { this.name = name; }
    public void setRecyclingCategory(RecyclingCategory recyclingCategory) { this.recyclingCategory = recyclingCategory; }
    public void setRecyclingGuidance(List<String> recyclingGuidance) { this.recyclingGuidance = recyclingGuidance; }
}
