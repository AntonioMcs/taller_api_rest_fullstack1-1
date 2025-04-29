package com.profecarlos.tallerapirest.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profecarlos.tallerapirest.restapi.model.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(){
        return "Se listan todos los productos del fortnite";
    }

    @GetMapping("/products")
    public String getProduct (@PathVariable Long id){

        return "haz obtenido el producto con el id " + id;

    }

    @GetMapping("/product/{id}")
    public Product getProduct (@PathVariable long id){

        return new Product (id,"",2.000);
        
    }



}
