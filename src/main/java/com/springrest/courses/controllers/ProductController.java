package com.springrest.courses.controllers;

import com.springrest.courses.entity.Product;
import com.springrest.courses.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        try{
            List<Product> products = this.productService.getProducts();
            /*if(products == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }*/
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Exception in GET:/products: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
