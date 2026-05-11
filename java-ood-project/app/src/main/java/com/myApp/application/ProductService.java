package com.myApp.application;
import com.myApp.domain.Product;
import com.myApp.domain.ProductRepository;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

        public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(String name) {
        return productRepository.findByName(name);
    }

    public double calculateImpact (Product product) {
        return impactCalculator.calculate(product);
    }

    public void setImpactCalculator(ImpactCalculator impactCalculator) {
        this.impactCalculator = impactCalculator;
    }
}
