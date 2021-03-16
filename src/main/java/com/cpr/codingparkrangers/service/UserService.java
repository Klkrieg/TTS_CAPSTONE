package com.cpr.codingparkrangers.service;

import com.cpr.codingparkrangers.model.User;
import com.cpr.codingparkrangers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

//  @Autowired
//  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
//    this.userRepository = userRepository;
//    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//  }

  public User findByUsername(String username){
    return userRepository.findByUsername(username);
  }
  public User saveNewUser(User user){
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(1);
    return userRepository.save(user);
  }

  public User getLoggedInUser(){
    String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
    return findByUsername(loggedInUser);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = findByUsername(username);
    if(user == null) throw new UsernameNotFoundException("Username not found.");
    return user;
  }
}
