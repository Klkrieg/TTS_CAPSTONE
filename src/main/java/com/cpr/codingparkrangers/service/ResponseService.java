package com.cpr.codingparkrangers.service;

import com.cpr.codingparkrangers.model.ResponseWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        String upperStateCode = stateCode.toUpperCase();
        System.out.println(upperStateCode);
        Map<String, String> states = new HashMap<String, String>();
            states.put("Alabama","AL");
            states.put("Alaska","AK");
            states.put("Arizona","AZ");
            states.put("Arkansas","AR");
            states.put("California","CA");
            states.put("Colorado","CO");
            states.put("Connecticut","CT");
            states.put("Delaware","DE");
            states.put("District Of Columbia","DC");
            states.put("Florida","FL");
            states.put("Georgia","GA");
            states.put("Hawaii","HI");
            states.put("Idaho","ID");
            states.put("Illinois","IL");
            states.put("Indiana","IN");
            states.put("Iowa","IA");
            states.put("Kansas","KS");
            states.put("Kentucky","KY");
            states.put("Louisiana","LA");
            states.put("Maine","ME");
            states.put("Maryland","MD");
            states.put("Massachusetts","MA");
            states.put("Michigan","MI");
            states.put("Minnesota","MN");
            states.put("Mississippi","MS");
            states.put("Missouri","MO");
            states.put("Montana","MT");
            states.put("Nebraska","NE");
            states.put("Nevada","NV");
            states.put("New Hampshire","NH");
            states.put("New Jersey","NJ");
            states.put("New Mexico","NM");
            states.put("New York","NY");
            states.put("Newfoundland","NF");
            states.put("North Carolina","NC");
            states.put("North Dakota","ND");
            states.put("Ohio","OH");
            states.put("Oklahoma","OK");
            states.put("Oregon","OR");
            states.put("Pennsylvania","PA");
            states.put("Rhode Island","RI");
            states.put("South Carolina","SC");
            states.put("South Dakota","SD");
            states.put("Tennessee","TN");
            states.put("Texas","TX");
            states.put("Utah","UT");
            states.put("Vermont","VT");
            states.put("Virginia","VA");
            states.put("Washington","WA");
            states.put("West Virginia","WV");
            states.put("Wisconsin","WI");
            states.put("Wyoming","WY");

            for (Map.Entry<String, String> entry : states.entrySet()) {
                if (Objects.equals(upperStateCode, entry.getValue())) {
                    return entry.getKey();
                }
            }
            return null;
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
