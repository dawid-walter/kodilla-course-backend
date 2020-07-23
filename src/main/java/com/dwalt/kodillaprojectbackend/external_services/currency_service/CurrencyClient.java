package com.dwalt.kodillaprojectbackend.external_services.currency_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyClient {
    private RestTemplate restTemplate;

    @Autowired
    public CurrencyClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Double> getRates() {
        Currency forObject = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=PLN", Currency.class);
        return forObject.getRates();
    }
}

