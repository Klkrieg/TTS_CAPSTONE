//package com.cpr.codingparkrangers.service;
//
//import com.cpr.codingparkrangers.model.Request;
//import com.cpr.codingparkrangers.repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RequestService {
//
//    private RequestRepository requestRepository;
//
//    @Autowired
//    public RequestService(RequestRepository requestRepository) {
//        this.requestRepository = requestRepository;
//    }
//
//    public String findStateCode(Request request) {
//        return request.getStateCode();
//    }
//
//}
