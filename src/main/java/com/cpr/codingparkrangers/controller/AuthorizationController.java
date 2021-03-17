package com.cpr.codingparkrangers.controller;

import com.cpr.codingparkrangers.model.User;
import com.cpr.codingparkrangers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorizationController {
  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String login(){
    return "login";
  }
  @GetMapping("/login-fail")
  public String failedLogin(Model model){
    User newUser = new User();
    model.addAttribute("error", true);
    model.addAttribute("user", newUser);
    return "login";
  }

  @GetMapping("/signup")
  public String signup(Model model){
    User user = new User();
    model.addAttribute("user", user);
    return "signup";
  }

  @PostMapping("/signup")
  public String createNewUser(@Valid User user, BindingResult bindingResult, Model model){
    User userExists = userService.findByUsername(user.getUsername());
    if(userExists != null){
      bindingResult.rejectValue("username", "error.user", "That username is taken.");
      return "signup";
    }
    if(!bindingResult.hasErrors()){
      userService.saveNewUser(user);
      model.addAttribute("success", "Sign up successful");
      return "login";
    }
    return "signup";
  }
}
