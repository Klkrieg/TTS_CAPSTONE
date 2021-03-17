package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.ResponseWrapper;
import com.cpr.codingparkrangers.model.Request;
import com.cpr.codingparkrangers.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/")
    public String mainPage(Model model){
        model.addAttribute("request", new Request());
        System.out.print("Loaded index");
        return "index";
    }
    @GetMapping(value = "/park")
    public String park(){
        return "park";
    }


//    @PostMapping(value = "/")
//    public String getGeneralInfo(Request request, Model model){
//        ResponseWrapper responseWrapper = responseService.getGeneralInfo(request.getApiCategory(), request.getParkCode());
//
//        // Prints park code and park object
//        System.out.println(request.getParkCode());
//        System.out.println(responseWrapper);
//        System.out.println(responseWrapper.getData());
////
////        model.addAttribute("park", park);
//        return "index";
//    }

}
