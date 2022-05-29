package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.dto.updateRequest.ProductUpdateRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Category;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.model.Vendor;
import com.krizan.e_commerce.repository.ProductRepository;
import com.krizan.e_commerce.service.api.CategoryService;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.VendorService;
import com.krizan.e_commerce.utils.Amount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public Product addProduct(ProductRequest request) throws NotFoundException {
        Category category = categoryService.getCategoryById(request.getCategory());
        Vendor vendor = vendorService.getVendorById(request.getVendor());
        Product product = new Product(request, category, vendor);

        if (category.getProducts() != null) {
            category.getProducts().add(product);
        }
        if (vendor.getProducts() != null) {
            vendor.getProducts().add(product);
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) throws NotFoundException {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductUpdateRequest request) throws NotFoundException {
        Product product = getProductById(productId);

        if (request.getGender() != null) {
            product.setGender(request.getGender());
        }
        if (request.getCategory() != null) {
            product.setCategory(categoryService.getCategoryById(request.getCategory()));
        }
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        if (request.getColor() != null) {
            product.setColor(request.getColor());
        }
        if (request.getSize() != null) {
            product.setSize(request.getSize());
        }
        if (request.getUnitPrice() != null
                && request.getUnitPrice().compareTo(BigDecimal.ZERO) > 0) {
            product.setUnitPrice(request.getUnitPrice());
            calcFinalUnitPrice(product);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) throws NotFoundException {
        Product product = productRepository.findProductById(productId);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    @Override
    public Product addProductQuantity(Long productId, Amount amount) throws NotFoundException, IllegalOperationException {
        Product product = getProductById(productId);
        if (amount != null && amount.getAmount() != null) {
            if (amount.getAmount() < 0) {
                throw new IllegalOperationException();
            }
            product.setQuantity(product.getQuantity() + amount.getAmount());
        }
        return productRepository.save(product);
    }

    @Override
    public Product removeProductQuantity(Long productId, Amount amount) throws NotFoundException, IllegalOperationException {
        Product product = getProductById(productId);
        if (amount != null && amount.getAmount() != null) {
            if (product.getQuantity() - amount.getAmount() < 0) {
                throw new IllegalOperationException();
            }
            product.setQuantity(product.getQuantity() - amount.getAmount());
        }
        return productRepository.save(product);
    }

    @Override
    public Product setDiscount(Long productId, Amount amount) throws NotFoundException, IllegalOperationException {
        Product product = getProductById(productId);
        if (amount != null && amount.getAmount() != null) {
            if (amount.getAmount() < 1 || amount.getAmount() > 100) {
                throw new IllegalOperationException();
            }
            if (amount.getAmount() > 0 && amount.getAmount() < 100) {
                product.setDiscount(amount.getAmount());
                product.setDiscountAvailable(true);
            }
        }
        if (amount != null && amount.getAmount() == null) {
            product.setDiscount(null);
            product.setDiscountAvailable(false);
        }

        calcFinalUnitPrice(product);
        return productRepository.save(product);
    }

    private void calcFinalUnitPrice(Product product) {
        if (!product.getDiscountAvailable()){
            product.setFinalUnitPrice(product.getUnitPrice());
        } else {
            double doubleDiscount = product.getDiscount() / 100D;
            var bigDecimalValueOfDiscount = BigDecimal.valueOf(doubleDiscount);
            product.setFinalUnitPrice(product.getUnitPrice().subtract(product.getUnitPrice()
                            .multiply(bigDecimalValueOfDiscount).setScale(2, RoundingMode.HALF_UP)));
        }
    }
}
