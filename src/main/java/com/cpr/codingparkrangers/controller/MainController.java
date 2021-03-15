package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.Park;
import com.cpr.codingparkrangers.model.Request;
import com.cpr.codingparkrangers.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    ParkService parkService;

    @GetMapping
    public String mainPage(Model model){
        return "index";
    }

    @PostMapping(value = "/")
    public String getGeneralInfo(Request request, Model model){
        System.out.println(request.getParkCode());
        Park park = parkService.getGeneralInfo(request.getParkCode());
        System.out.println(park);
        model.addAttribute("park", park);
        return "index";
    }



}
