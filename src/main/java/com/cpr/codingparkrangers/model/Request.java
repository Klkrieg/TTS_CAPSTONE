package com.cpr.codingparkrangers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    //For retrieving from API
    private String apiCategory;
    public String stateCode;
    private String parkCode;

}