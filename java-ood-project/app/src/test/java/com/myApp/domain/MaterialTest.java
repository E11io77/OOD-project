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

        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);


        double result = material.getEnvironmentalImpactValue();


        assertEquals(1.1, result);
    }

    @Test
    void shouldStoreCorrectRecyclingCategory() {

        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);


        RecyclingCategory result = material.getRecyclingCategory();


        assertEquals(RecyclingCategory.CARDBOARD, result);
    }

    @Test
    void shouldStoreCorrectRecyclingGuidance() {

        List<String> guidance = List.of("Fold flat.", "Place in paper bin.");
        Material material = new Material("Cardboard", RecyclingCategory.CARDBOARD, guidance, 1.1);


        List<String> result = material.getRecyclingGuidance();


        assertEquals(guidance, result);
    }
}