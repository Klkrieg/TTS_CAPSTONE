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

    public ResponseWrapper callByState(String apiCategory, String stateCode) {
        String url = "https://developer.nps.gov/api/v1/" + apiCategory + "?stateCode=" +
                stateCode + "&api_key=" + apiKey;
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

    public String getStateName(String stateCode) {

        System.out.println("State code is" + stateCode);
        if(stateCode.equals("az")) {
            System.out.println("Arizona");
            return "Arizona";
        } else {
            return "null";
        }
    }

    public ResponseWrapper callByPark(String apiCategory, String parkCode) {
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
