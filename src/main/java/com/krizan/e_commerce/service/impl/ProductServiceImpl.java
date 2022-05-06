package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.repository.ProductRepository;
import com.krizan.e_commerce.service.api.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> addProduct(Product product) {
        if (product.getUnitPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("UnitPrice must not be less than 0.");
        }
        if (product.getDiscount() < 0 || product.getDiscount() > 100) {
            throw new IllegalStateException("Discount must be in range 0-100.");
        }
        if (product.getQuantity() < 0) {
            throw new IllegalStateException("UnitPrice must not be less than 0.");
        }

//        product.setFinalUnitPrice(product.calcFinalUnitPrice());
        productRepository.save(product);
        Long id = product.getProductId();
        return new ResponseEntity<>("Product has been created with id: " + id + ".", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id: " + productId + " does not exist."));
        productRepository.deleteById(productId);
        return new ResponseEntity<>("Product with id: " + productId
                + " has been deleted.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long productId, Product newProduct) {
        Product oldProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id: " + productId + " does not exist."));
        oldProduct.setVendor(newProduct.getVendor());
        oldProduct.setGender(newProduct.getGender());
        oldProduct.setCategory(newProduct.getCategory());
        oldProduct.setName(newProduct.getName());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setColor(newProduct.getColor());
        oldProduct.setSize(newProduct.getSize());
        oldProduct.setUnitPrice(newProduct.getUnitPrice());
        oldProduct.setDiscountAvailable(newProduct.getDiscountAvailable());
        oldProduct.setDiscount(newProduct.getDiscount());
        oldProduct.setFinalUnitPrice(newProduct.getFinalUnitPrice());
        oldProduct.setQuantity(newProduct.getQuantity());

        productRepository.save(oldProduct);
        return new ResponseEntity<>(oldProduct, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id: " + productId + " does not exist."));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
