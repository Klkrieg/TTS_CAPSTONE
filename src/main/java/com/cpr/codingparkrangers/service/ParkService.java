package com.cpr.codingparkrangers.service;

import com.cpr.codingparkrangers.model.Park;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ParkService {

    @Value("${api_key}")
    private String apiKey;

    public Park getGeneralInfo(String parkCode) {
        String url = "https://developer.nps.gov/api/v1/parks?parkCode=" +
                parkCode + "&api_key=" + apiKey;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, Park.class);
        }
        catch (HttpClientErrorException ex) {
            Park park = new Park();
            park.setName("error");
            return park;
        }
    }
}
