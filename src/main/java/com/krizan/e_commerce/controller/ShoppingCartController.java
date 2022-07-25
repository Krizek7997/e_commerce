package com.krizan.e_commerce.controller;

import com.krizan.e_commerce.dto.request.ProductIdRequest;
import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.dto.response.ShoppingCartResponse;
import com.krizan.e_commerce.service.api.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartResponse> getShoppingCartById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ShoppingCartResponse(shoppingCartService.getShoppingCartById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShoppingCartResponse> addShoppingCart() {
        return new ResponseEntity<>(new ShoppingCartResponse(shoppingCartService.addShoppingCart()), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingCart(@PathVariable("id") Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ShoppingCartResponse> addProductToShoppingCart(
            @PathVariable("id") Long id,
            @RequestBody ShoppingCartEntryRequest request
    ) {
        return new ResponseEntity<>(
                new ShoppingCartResponse(shoppingCartService.addProductToShoppingCart(id, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/remove")
    public void deleteProductFromShoppingCart(@PathVariable("id") Long id,
                                              @RequestBody ProductIdRequest request) {
        shoppingCartService.deleteProductFromShoppingCart(id, request);
    }
}
