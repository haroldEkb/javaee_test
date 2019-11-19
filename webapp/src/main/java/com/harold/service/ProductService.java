package com.harold.service;

import com.harold.entity.Product;
import com.harold.persist.ProductRepository;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
@PermitAll
public class ProductService implements Serializable {

    @Inject
    private ProductRepository productRepository;

    public Product findById(int i) {
        return productRepository.findById(i);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @RolesAllowed(value = "ADMIN")
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @RolesAllowed(value = "ADMIN")
    public void insert(Product product) {
        productRepository.insert(product);
    }
}
