package com.location24x7.ecommerce.inventory.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.location24x7.ecommerce.inventory.dto.Product;
import com.location24x7.ecommerce.inventory.service.ProductService;

@Path("/api/product")
@Component
public class ProductController {

    @Autowired
    private ProductService productService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("productId") Long productId) {
        return productService.getProduct(productId);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

}
