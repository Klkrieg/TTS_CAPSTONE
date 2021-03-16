package com.cpr.codingparkrangers.model;

import lombok.Data;

@Data
public class ResponseWrapper {

    private String total;
    private DataField[] data;
    private String limit;
    private String start;

}


