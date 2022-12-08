package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.ProductIdRequest;
import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.dto.response.ShoppingCartResponse;
import com.krizan.e_commerce.service.api.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCartResponse getShoppingCartById(@PathVariable("id") Long id) {
        return new ShoppingCartResponse(shoppingCartService.getShoppingCartById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCartResponse addShoppingCart() {
        return new ShoppingCartResponse(shoppingCartService.addShoppingCart());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingCart(@PathVariable("id") Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }

    @PostMapping("/{id}/add")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCartResponse addProductToShoppingCart(
            @PathVariable("id") Long id,
            @RequestBody ShoppingCartEntryRequest request
    ) {
        return new ShoppingCartResponse(shoppingCartService.addProductToShoppingCart(id, request));
    }

    @DeleteMapping("/{id}/remove")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductFromShoppingCart(
        @PathVariable("id") Long id,
        @RequestBody ProductIdRequest request
    ) {
        shoppingCartService.deleteProductFromShoppingCart(id, request);
    }
}
