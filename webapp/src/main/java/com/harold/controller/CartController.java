package com.harold.controller;

import com.harold.entity.Product;
import com.harold.util.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.Map;

@Named
@SessionScoped
@Interceptors({com.harold.util.Logger.class})
public class CartController implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(CartController.class);

    @Inject
    private Cart cart;

    public void addProduct(Product product){
        cart.addProduct(product);
    }

    public void decreaseProductCount(Product product){
        cart.decreaseProductCount(product);
    }

    public void removeProduct(Product product){
        cart.removeProduct(product);
    }

    public Map<Product, Integer> getAllProducts(){
        return cart.getProductMap();
    }
}
