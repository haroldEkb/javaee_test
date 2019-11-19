package com.harold.service;

import com.harold.entity.Product;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Local
@Path("product-service")
public interface ProductServiceRest {
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findAll();

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Product findById(@PathParam("id") Integer id);

    @GET
    @Path("title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    Product findByTitle(@PathParam("title") String title);

    @GET
    @Path("category/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findAllByCategoryId(@PathParam("categoryId") Integer categoryId);

    @POST
    @Path("add")
    Response insert(Product product);

    @DELETE
    @Path("delete/{id}")
    Response delete(@PathParam("id") Integer id);
}
