package com.springrest.courses.service;

import com.springrest.courses.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Product> getProducts() {
        String url = "https://dummyjson.com/products/";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("Response from dummy data : {}",response);
        return null;
    }
}
