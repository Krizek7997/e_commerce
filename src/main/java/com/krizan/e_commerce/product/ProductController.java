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
    public ResponseEntity<String> addNewProduct(@RequestBody Product product) {
        product.setFinalUnitPrice(product.calcFinalUnitPrice());
        if (product.getDiscount() >= 0 && product.getDiscount() <= 100 && product.getQuantity() > 0) {
            productRepository.save(product);
            Long id = product.getProductId();
            return new ResponseEntity<>("Product has been added with id: " + id + ".", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Parameter 'Discount' is out of bounds.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product newProduct) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            product.setVendor(newProduct.getVendor());
            product.setCategory(newProduct.getCategory());
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setColor(newProduct.getName());
            product.setSize(newProduct.getName());
            if (newProduct.getDiscount() >= 0 && newProduct.getDiscount() <= 100) {
                product.setDiscount(newProduct.getDiscount());
            } else {
                return new ResponseEntity<>("Parameter 'Discount' is out of bounds.",
                        HttpStatus.PRECONDITION_FAILED);
            }
            product.setDiscountAvailable(newProduct.getDiscountAvailable());
            product.setUnitPrice(newProduct.getUnitPrice());
            product.setFinalUnitPrice(newProduct.calcFinalUnitPrice());
            product.setOnOrder(newProduct.getOnOrder());
            if (newProduct.getQuantity() > 0) {
                product.setQuantity(newProduct.getQuantity());
            } else {
                return new ResponseEntity<>("Parameter 'Quantity' is out of bounds.",
                        HttpStatus.PRECONDITION_FAILED);
            }
            productRepository.save(product);

            return new ResponseEntity<>("Product with id: " + id + " has been updated.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product with id: " + id + " has been deleted.",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product with id: " + id + " doesn't exist.",
                    HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products.toString(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            Optional<Product> product = productRepository.findById(id);
            return new ResponseEntity<>(product.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product with id: " + id + " doesn't exist.",
                    HttpStatus.NOT_FOUND);
        }
    }
}
