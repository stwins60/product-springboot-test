package com.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    // A simple dictionary (Map) to hold product data
    private static final Map<String, String> productDictionary = new HashMap<>();

    static {
        // Sample data
        productDictionary.put("1", "Product 1 description");
        productDictionary.put("2", "Product 2 description");
        productDictionary.put("3", "Product 3 description");
    }

    @GetMapping("/product")
    public ResponseEntity<Map<String, String>> getAllProducts() {
        return new ResponseEntity<>(productDictionary, HttpStatus.OK);
    }

    // Route to get product by ID
    @GetMapping("/product/{id}")
    public ResponseEntity<String> getProductById(@PathVariable String id) {
        String product = productDictionary.get(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Health check route
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Service is healthy", HttpStatus.OK);
    }
}
