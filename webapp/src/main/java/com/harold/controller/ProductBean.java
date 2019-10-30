package com.harold.controller;

import com.harold.entity.Product;
import com.harold.persist.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class ProductBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductRepository productRepository;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() throws SQLException {
        logger.debug("Product info");
//        this.product = productRepository.findById(1);
//        products.add(product);
//        logger.debug(product.getTitle());
        return productRepository.findAll();
    }
}
