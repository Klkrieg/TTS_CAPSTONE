package com.cpr.codingparkrangers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    //For retrieving from API
    private String apiCategory;
    public String stateCode;
    private String parkCode;

}