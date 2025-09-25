package com.raptor.ecommerceapi.controller;

import com.raptor.ecommerceapi.model.Product;
import com.raptor.ecommerceapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        var products = productService.getProducts();

        if (products.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        var product = productService.getProductById(id);

        if (product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
