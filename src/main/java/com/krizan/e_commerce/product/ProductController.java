package com.krizan.e_commerce.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {this.productRepository = productRepository; }

    @PostMapping
    public ResponseEntity addNewProduct(@RequestBody Product product) {
        product.setFinalUnitPrice(product.calcFinalUnitPrice());
        if (product.getDiscount() >= 0 && product.getDiscount() <= 100) {
            productRepository.save(product);
            Long id = product.getProductId();
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body("Parameter 'Discount' is out of bounds");
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") Long id, @RequestBody Product newProduct) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            product.setVendorId(newProduct.getVendorId());
            product.setCategoryId(newProduct.getCategoryId());
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setColor(newProduct.getName());
            product.setSize(newProduct.getName());

            if (newProduct.getDiscount() >= 0 && newProduct.getDiscount() <= 100) {
                product.setDiscount(newProduct.getDiscount());
            } else return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Parameter 'Discount' is out of bounds");

            product.setDiscountAvailable(newProduct.getDiscountAvailable());
            product.setUnitPrice(newProduct.getUnitPrice());
            product.setFinalUnitPrice(newProduct.calcFinalUnitPrice());
            product.setOnOrder(newProduct.getOnOrder());
            productRepository.save(product);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Product with id: " + id + " doesn't exist.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Product with id: " + id + " doesn't exist.");
        }
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            Optional<Product> product = productRepository.findById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
