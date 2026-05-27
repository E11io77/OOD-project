package com.myApp.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WeightedByLifespanStrategyTest {

    @Test
    void shouldDivideImpactByLifespan() {
        // ARRANGE
        Material cardboard = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 4.4);
        Product shoeBox = new Product("Shoe box", "Packaging", 2, List.of(cardboard));
        ImpactCalculator calc = new WeightedByLifespanStrategy();

        // ACT
        double result = calc.calculate(shoeBox);

        // ASSERT
        assertEquals(2.2, result);
    }

    @Test
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // ARRANGE
        Product emptyProduct = new Product("ABC", "XYZ", 1, List.of());
        ImpactCalculator calc = new WeightedByLifespanStrategy();

        // ACT
        double result = calc.calculate(emptyProduct);

        // ASSERT
        assertEquals(0.0, result);
}
}