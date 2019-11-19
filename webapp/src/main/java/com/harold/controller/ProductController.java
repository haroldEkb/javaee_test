package com.harold.controller;

import com.harold.entity.Product;
import com.harold.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Interceptors({com.harold.util.Logger.class})
public class ProductController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductService productService;

    private Product product;
    private List<Product> productList;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public String createProduct() {
        this.product = new Product();
        return "/edit_product.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/products.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        logger.info("Deleting Product");
        productService.delete(product.getId());
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/edit_product.xhtml?faces-redirect=true";
    }

    public void preloadProductList(ComponentSystemEvent event){
        this.productList = productService.findAll();
    }
}
