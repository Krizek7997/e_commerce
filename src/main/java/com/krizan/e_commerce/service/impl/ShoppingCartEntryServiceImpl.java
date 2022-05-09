package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.model.ShoppingCartEntry;
import com.krizan.e_commerce.repository.ShoppingCartEntryRepository;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.ShoppingCartEntryService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartEntryServiceImpl implements ShoppingCartEntryService {

    private final ShoppingCartEntryRepository shoppingCartEntryRepository;
    private final ProductService productService;

    public ShoppingCartEntryServiceImpl(ShoppingCartEntryRepository shoppingCartEntryRepository, ProductService productService) {
        this.shoppingCartEntryRepository = shoppingCartEntryRepository;
        this.productService = productService;
    }

    @Override
    public ShoppingCartEntry getShoppingCartEntryById(Long id) throws NotFoundException {
        ShoppingCartEntry shoppingCartEntry = shoppingCartEntryRepository.getShoppingCartEntryById(id);
        if (shoppingCartEntry == null) {
            throw new NotFoundException();
        }
        return shoppingCartEntryRepository.save(shoppingCartEntry);
    }

    @Override
    public ShoppingCartEntry addShoppingCartEntry(ShoppingCartEntryRequest request) throws NotFoundException {
        Product product = productService.getProductById(request.getProductId());
        Integer amount = request.getQuantity();
        ShoppingCartEntry shoppingCartEntry = new ShoppingCartEntry(product, amount);
        return shoppingCartEntryRepository.save(shoppingCartEntry);
    }

    @Override
    public void deleteShoppingCartEntry(Long id) throws NotFoundException {
        ShoppingCartEntry shoppingCartEntry = getShoppingCartEntryById(id);
        shoppingCartEntryRepository.delete(shoppingCartEntry);
    }
}
