package com.cpr.codingparkrangers.service;

import com.cpr.codingparkrangers.model.ResponseWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseService {

    @Value("${api_key}")
    private String apiKey;

    public ResponseWrapper getGeneralInfo(String apiCategory, String parkCode) {
        String url = "https://developer.nps.gov/api/v1/" + apiCategory + "?parkCode=" +
                parkCode + "&api_key=" + apiKey;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, ResponseWrapper.class);
        }
        catch (HttpClientErrorException ex) {
            System.out.print(ex);
            return null;
        }
    }


}
