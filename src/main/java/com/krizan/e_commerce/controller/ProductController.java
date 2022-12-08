package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.dto.response.ProductResponse;
import com.krizan.e_commerce.dto.request.updateRequest.ProductUpdateRequest;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.utils.Amount;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return new ProductResponse(productService.addProduct(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductUpdateRequest request
    ) {
        return new ProductResponse(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts().stream()
            .map(ProductResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        return new ProductResponse(productService.getProductById(id));
    }

    @PostMapping("/{id}/addQuantity")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse addProductQuantity(
        @PathVariable("id") Long id,
        @RequestBody Amount amount
    ) {
        return new ProductResponse(productService.addProductQuantity(id, amount));
    }

    @PostMapping("/{id}/removeQuantity")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse removeProductQuantity(
        @PathVariable("id") Long id,
        @RequestBody Amount amount
    ) {
        return new ProductResponse(productService.removeProductQuantity(id, amount));
    }

    @PostMapping("/{id}/setDiscount")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse setDiscount(@PathVariable("id") Long id, @RequestBody Amount amount) {
        return new ProductResponse(productService.setDiscount(id, amount));
    }
}
