package com.harold.service;

import com.harold.entity.Product;
import com.harold.persist.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "com.harold.service.ProductServiceWs", serviceName = "ProductServiceWsImpl")
public class ProductServiceWsImpl implements ProductServiceWs {

    @EJB
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product.getId());
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
