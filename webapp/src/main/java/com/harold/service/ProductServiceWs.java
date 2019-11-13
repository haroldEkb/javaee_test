package com.harold.service;

import com.harold.entity.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {
    @WebMethod
    List<Product> findAll();

    @WebMethod
    void insert(Product product);

    @WebMethod
    void delete(Product product);

    @WebMethod
    Product findById(Integer id);

    @WebMethod
    Product findByTitle(String title);

    @WebMethod
    List<Product> findAllByCategoryId(Integer categoryId);
}
