package com.krizan.e_commerce.service.impl;

import com.krizan.e_commerce.dto.request.ShoppingCartEntryRequest;
import com.krizan.e_commerce.exception.IllegalOperationException;
import com.krizan.e_commerce.exception.NotFoundException;
import com.krizan.e_commerce.model.Product;
import com.krizan.e_commerce.model.ShoppingCart;
import com.krizan.e_commerce.repository.ShoppingCartRepository;
import com.krizan.e_commerce.service.api.ProductService;
import com.krizan.e_commerce.service.api.ShoppingCartEntryService;
import com.krizan.e_commerce.service.api.ShoppingCartService;
import com.krizan.e_commerce.utils.Amount;
import com.krizan.e_commerce.utils.ProductIdRequest;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;
    private final ShoppingCartEntryService shoppingCartEntryService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductService productService, ShoppingCartEntryService shoppingCartEntryService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
        this.shoppingCartEntryService = shoppingCartEntryService;
    }

    @Override
    public ShoppingCart getShoppingCartById(Long shoppingCartId) throws NotFoundException {
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByShoppingCartId(shoppingCartId);
        if (shoppingCart == null) {
            throw new NotFoundException();
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart addShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(Long shoppingCartId) throws NotFoundException {
        ShoppingCart shoppingCart = getShoppingCartById(shoppingCartId);
        shoppingCartRepository.delete(shoppingCart);
    }

    @Override
    public ShoppingCart addProductToShoppingCart(Long shoppingCartId, ShoppingCartEntryRequest request) throws NotFoundException, IllegalOperationException {
        ShoppingCart shoppingCart = getShoppingCartById(shoppingCartId);
        Product product = productService.getProductById(request.getProductId());
        if (product.getQuantity() - request.getQuantity() < 0) {
            throw new IllegalOperationException();
        }
        shoppingCart.getProducts().add(shoppingCartEntryService.addShoppingCartEntry(request));
        productService.removeProductQuantity(product.getProductId(), new Amount(request.getQuantity()));
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteProductFromShoppingCart(Long shoppingCartId, ProductIdRequest request) throws NotFoundException, IllegalOperationException {
        ShoppingCart shoppingCart = getShoppingCartById(shoppingCartId);
        Product product = productService.getProductById(request.getProductId());
        for (var entry: shoppingCart.getProducts()) {
            if (entry.getProduct().getProductId() != null
                    && entry.getProduct().getProductId().equals(request.getProductId())) {
                shoppingCartEntryService.deleteShoppingCartEntry(entry.getId());
                productService.addProductQuantity(product.getProductId(), new Amount(entry.getAmount()));
            }
        }
    }
}
