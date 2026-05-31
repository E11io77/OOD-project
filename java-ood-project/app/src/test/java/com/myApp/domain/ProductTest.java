package com.myApp.domain;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    void shouldStoreCorrectName() {
        // ARRANGE
        Product product = new Product("Shoe box", "Packaging", 2, List.of());
        
        // ACT
        String result = product.getName();
        
        // ASSERT
        assertEquals("Shoe box", result);
    }

      @Test
    void shouldStoreCorrectCategory() {
        // ARRANGE
        Product product = new Product("Shoe box", "Packaging", 2, List.of());
        
        // ACT
        String result = product.getCategory();
        
        // ASSERT
        assertEquals("Packaging", result);
    }

      @Test
    void shouldStoreCorrectELSpan() {
        // ARRANGE
        Product product = new Product("Shoe box", "Packaging", 2, List.of());
        
        // ACT
        int result = product.getEstimatedLifeSpan();
        
        // ASSERT
        assertEquals(2, result); // výsledek bez uvozovek, je to číslo, ne slovo
    }

      @Test
    void shouldStoreCorrectMaterialList() {
        // ARRANGE
        Material cardboard = new Material("Cardboard", RecyclingCategory.CARDBOARD, List.of(), 1.1);
        Product product = new Product("Shoe box", "Packaging", 2, List.of(cardboard));
        
        // ACT
        List<Material> result = product.getMaterials();
        
        // ASSERT
        assertEquals(List.of(cardboard), result); //nezapomenout na List.of
    }

    
}
