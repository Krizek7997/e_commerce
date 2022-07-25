package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.model.ShoppingCartEntry;
import com.krizan.e_commerce.repository.ShoppingCartEntryRepository;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.ShoppingCartEntryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartEntryServiceImpl implements ShoppingCartEntryService {

    private final ShoppingCartEntryRepository shoppingCartEntryRepository;
    private final ProductService productService;

    @Override
    public ShoppingCartEntry getShoppingCartEntryById(Long id) {
        return shoppingCartEntryRepository.findShoppingCartEntryById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public ShoppingCartEntry addShoppingCartEntry(ShoppingCartEntryRequest request, ShoppingCart shoppingCart) {
        Product product = productService.getProductById(request.getProductId());
        Integer amount = request.getQuantity();
        ShoppingCartEntry shoppingCartEntry = new ShoppingCartEntry(product, amount, shoppingCart);
        return shoppingCartEntryRepository.save(shoppingCartEntry);
    }

    @Override
    public void deleteShoppingCartEntry(Long id) {
        ShoppingCartEntry shoppingCartEntry = getShoppingCartEntryById(id);
        shoppingCartEntryRepository.delete(shoppingCartEntry);
    }
}
