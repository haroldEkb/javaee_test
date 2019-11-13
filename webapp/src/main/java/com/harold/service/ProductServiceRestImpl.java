package com.harold.service;

import com.harold.entity.Product;
import com.harold.persist.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ProductServiceRestImpl implements ProductServiceRest {

    @EJB
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Response insert(Product product) {
        productRepository.insert(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response delete(Integer integer) {
        productRepository.delete(integer);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public List<Product> findAllByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }
}
