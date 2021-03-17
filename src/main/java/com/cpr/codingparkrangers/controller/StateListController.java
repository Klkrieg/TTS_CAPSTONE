package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.DataField;
import com.cpr.codingparkrangers.model.Request;
import com.cpr.codingparkrangers.model.ResponseWrapper;
import com.cpr.codingparkrangers.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StateListController {

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/stateList")
    public String getParksInState(Request request, Model model){

        model.addAttribute("request", new Request());

        return "stateList";
    }

    @PostMapping(value = "/stateList")
    public String searchParksInState(Request request, Model model){

        // Convert state code into name to display using a method in responseservice
        // Add that to model

        String stateName = responseService.getStateName(request.getStateCode());
        model.addAttribute("stateName", stateName);


        ResponseWrapper responseWrapper = responseService.callByState("parks", request.getStateCode());

        model.addAttribute("parksInfo", responseWrapper.getData());
        // Checking
        System.out.println(request.stateCode);
        System.out.println(responseWrapper);
        for(DataField park : responseWrapper.getData()) {
            System.out.println(park.getFullName());
        }
        return "stateList";
    }

}
