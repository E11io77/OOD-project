package com.myApp.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MaterialTest {

    @Test
    void shouldStoreCorrectName() {
        // ARRANGe
        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);

        // ACT
        String result = material.getName();

        // ASSERT
        assertEquals("Cardboard", result);
    }

    @Test
    void shouldStoreCorrectImpactValue() {
        // ARRANGE
        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);

        // ACT
        double result = material.getEnvironmentalImpactValue();

        // ASSERT
        assertEquals(1.1, result);
    }

    @Test
    void shouldStoreCorrectRecyclingCategory() {
        // ARRANGE
        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);

        // ACT
        RecyclingCategory result = material.getRecyclingCategory();

        // ASSERT
        assertEquals(RecyclingCategory.CARDBOARD, result);
    }

    @Test
    void shouldStoreCorrectRecyclingGuidance() {
        // ARRANGE
        List<String> guidance = List.of("Fold flat.", "Place in paper bin.");
        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, guidance, 1.1);

        // ACT
        List<String> result = material.getRecyclingGuidance();

        // ASSERT
        assertEquals(guidance, result);
    }
}