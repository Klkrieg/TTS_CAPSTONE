package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.DataField;
import com.cpr.codingparkrangers.model.Request;
import com.cpr.codingparkrangers.model.ResponseWrapper;
import com.cpr.codingparkrangers.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ParkController {

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/parks/{park}")
    public String getParksInState(@PathVariable("park") String parkCode, Model model){
        ResponseWrapper responseWrapper = responseService.callByPark("parks", parkCode);
        DataField[] data = responseWrapper.getData();
        System.out.println(data[0].getDescription());
        for(Map<String, String> image: data[0].getImages()){
            System.out.println(image.get("url"));
        }
        model.addAttribute("park", data[0]);

        //model.addAttribute("request", new Request());
        return "park";
    }

}
