package com.springrest.courses.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.courses.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Product> getProducts() {
        String uri = "https://dummyjson.com/products/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = null;
        List<Product> list;
        try {
            responseEntity = restTemplate.getForEntity(uri, String.class);
        } catch (Exception serviceUnavailableException) {
            log.error("Error while fetching data : {}", serviceUnavailableException);
        }

        if (responseEntity != null) {
            String response = responseEntity.getBody();
            log.info("Response from dummy api :{}", response);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(response);
                JsonNode products = jsonNode.get("products");
                list = new ArrayList<>();
                products.forEach(product -> {
                    list.add(new Product(Long.parseLong(product.get("id").asText()), product.get("title").asText(),
                            product.get("description").asText(), product.get("price").asInt(), product.get("category").asText()));
                });
                return list;

            } catch (Exception e){
                log.error("Exception is : {}", e);
            }
        }
        return null;
    }
}
