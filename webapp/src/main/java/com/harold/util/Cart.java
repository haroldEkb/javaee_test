package com.harold.util;

import com.harold.entity.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Stateful
public class Cart implements Serializable {
    private Map<Product, Integer> productMap;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    @PostConstruct
    public void init() {
        productMap = new LinkedHashMap<>();
        productMap.put(new Product(1, "qwe", 123), 2);
        productMap.put(new Product(2, "asd", 456), 4);
        productMap.put(new Product(3, "zxc", 743), 10);
    }

    public void addProduct(Product product) {
        totalPrice += product.getCost();
        if (productMap.containsKey(product)){
            productMap.merge(product, 1, Integer::sum);
        } else {
            productMap.put(product, 1);
        }
    }

    public void decreaseProductCount(Product product){
        Integer count = productMap.get(product);
        if (count > 1){
            productMap.merge(product, -1, Integer::sum);
        } else {
            productMap.remove(product);
        }
        recalculate();
    }

    public void removeProduct(Product product) {
        productMap.remove(product);
        recalculate();
    }

    public void clear() {
        productMap.clear();
        totalPrice = 0.0;
    }

    private void recalculate() {
        totalPrice = 0.0;
        productMap.keySet().forEach(p -> totalPrice += p.getCost());
    }
}
