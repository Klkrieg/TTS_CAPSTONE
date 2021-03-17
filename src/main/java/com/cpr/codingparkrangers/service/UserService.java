package com.cpr.codingparkrangers.service;

import com.cpr.codingparkrangers.model.Role;
import com.cpr.codingparkrangers.model.User;
import com.cpr.codingparkrangers.repository.RoleRepository;
import com.cpr.codingparkrangers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService{
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public User findByUsername(String username){
    return userRepository.findByUsername(username);
  }

  public User saveNewUser(User user){
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    Role userRole = roleRepository.findByRole("USER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    return userRepository.save(user);
  }

  public User getLoggedInUser(){
    String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
    return findByUsername(loggedInUser);
  }
}
