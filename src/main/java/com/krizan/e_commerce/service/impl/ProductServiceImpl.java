package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.dto.updateRequest.ProductUpdateRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.repository.ProductRepository;
import com.krizan.e_commerce.service.api.CategoryService;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.VendorService;
import com.krizan.e_commerce.utils.Amount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final VendorService vendorService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, VendorService vendorService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.vendorService = vendorService;
    }

    @Override
    public Product addProduct(ProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) throws NotFoundException {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductUpdateRequest request) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product getProductById(Long productId) throws NotFoundException {
        Product product = productRepository.findProductByProductId(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    @Override
    public Product addProductQuantity(Long productId, Amount amount) {
        return null;
    }

    @Override
    public Product setDiscount(Long productId, Amount amount) {
        return null;
    }
}
