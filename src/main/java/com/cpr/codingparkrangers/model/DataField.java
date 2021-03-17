package com.cpr.codingparkrangers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataField {

    //Articles
    private String listingDescription;

    //Parks
    private Map<String, String>[] activities;
    private String fullName;
    private String description;

    //test
    private Map<String, String>[] images;



}
