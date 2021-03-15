package com.cpr.codingparkrangers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Park {

    private Map<String, String> activities;
    private Map<String, String> addresses;
    private Map<String, String> contacts;
    private String description;
    private String designation;
    private String directionsInfo;
    private String directionsUrl;
    private Map<String, String> entranceFees;
    private Map<String, String> entrancePasses;
    private String fullName;
    private String id;
    private Map<String, String> images;
    private String latLong;
    private String latitude;
    private String longitude;
    private String name;
    private Map<String, String> operatingHours;
    private String parkCode;
    private String states;
    private Map<String, String> topics;
    private String url;
    private String weatherInfo;


}
