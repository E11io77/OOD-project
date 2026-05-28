package com.myApp.domain;

public class SimpleSumStrategy implements ImpactCalculator{
    @Override
    public double calculate(Product product) {
        double total = 0;
        for (Material material : product.getMaterials()){
            total+=material.getEnvironmentalImpactValue();
        }
        return total; // napr. sklenice ma 0.9, tedy tolik CO2 stoji vyroba produktu
    }
}
