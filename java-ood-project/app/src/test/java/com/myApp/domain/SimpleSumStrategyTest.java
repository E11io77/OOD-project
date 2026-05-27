package com.myApp.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SimpleSumStrategyTest {

    @Test //testy jsou jiné metody ve stejné třídě
    void shouldSumImpactValuesOfAllMaterials() {
        // ARRANGE
        Material plastic = new Material("Plastic", RecyclingCategory.PLASTIC, List.of(), 3.5);
        Material glass   = new Material("Glass",   RecyclingCategory.GLASS,   List.of(), 0.9);
        Product  bottle  = new Product("Bottle", "Container", 1, List.of(plastic, glass));
        ImpactCalculator calc = new SimpleSumStrategy();

        // ACT
        double result = calc.calculate(bottle);

        // ASSERT
        assertEquals(4.4, result);
    }

    @Test
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // ARRANGE
        Product  emptyProduct = new Product("Empty", "Container", 1, List.of());
        ImpactCalculator calc = new SimpleSumStrategy();

        // ACT
        double result = calc.calculate(emptyProduct);

        // ASSERT
        assertEquals(0.0, result);
    }
}
