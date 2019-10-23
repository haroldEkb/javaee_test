package com.harold.controller;

import com.harold.persist.Product;
import com.harold.persist.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

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

    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    public Product getAnyProduct() throws SQLException {
        System.out.println(productRepository.findById(1).getTitle());
        return productRepository.findById(1);
    }

    public String createProduct() {
        this.product = new Product();
        return "/edit_product.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/products.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        logger.info("Deleting Product");
        productRepository.delete(product.getId());
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/edit_product.xhtml?faces-redirect=true";
    }
}
