package com.dwalt.kodillaprojectbackend.external_services.currency_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CurrencyController {
    private final CurrencyClient currencyClient;

    @GetMapping()
    public ResponseEntity<Map<String, Double>> getEuroPricePerDay() {
        Map<String, Double> nbpRates = currencyClient.getRates();
        return new ResponseEntity<>(nbpRates, HttpStatus.OK);
    }
}
