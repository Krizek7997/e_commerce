package com.krizan.e_commerce.service.api;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.dto.request.updateRequest.ProductUpdateRequest;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.utils.Amount;
import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequest request);
    void deleteProduct(Long productId);
    Product updateProduct(Long productId, ProductUpdateRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product addProductQuantity(Long productId, Amount amount);
    Product removeProductQuantity(Long productId, Amount amount);
    Product setDiscount(Long productId, Amount amount);
}
