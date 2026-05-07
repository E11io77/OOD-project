package com.myApp.domain;

public class WeightedByLifespanStrategy implements ImpactCalculator{
    @Override
    public double calculate(Product product) {
        double total = 0;
        for (Material material : product.getMaterials()){
            total+=material.getEnvironmentalImpactValue();

        }
        return total/product.getEstimatedLifeSpan(); // kolik stoji vyroba produktu vydeleno jejich zivotnosti
    }
}
