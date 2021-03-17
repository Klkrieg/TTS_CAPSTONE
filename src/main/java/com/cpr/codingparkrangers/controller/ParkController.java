package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.Request;
import com.cpr.codingparkrangers.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParkController {

    @Autowired
    ResponseService responseService;

    @PostMapping(value = "/stateList/park}")
    public String getParksInState(Request request, Model model){


        model.addAttribute("request", new Request());
        return "park";
    }

}
