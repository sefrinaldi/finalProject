package com.sefrinaldi.finaljavabe.database.service;

import com.sefrinaldi.finaljavabe.database.model.Customer;
import com.sefrinaldi.finaljavabe.database.model.Prabayar;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public Customer[] getPostWithUrlParameters(Long id) {
        String url = String.format("http://localhost:8090/api/customer/invoice/%s", id);
        return this.restTemplate.getForObject(url, Customer[].class, id);
    }

    public String createPost(Prabayar prabayar) {
        String url = "http://localhost:8090/api/customer/order";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Integer> map = new HashMap<>();
        map.put("id", prabayar.getId());
        map.put("orderId", prabayar.getOrderId());
        map.put("token", prabayar.getToken());

        // build the request
        HttpEntity<Map<String, Integer>> entity = new HttpEntity<>(map, headers);

        // send POST request
        return restTemplate.postForObject(url, entity, String.class);
    }
}
