package com.myself.u_actions.services.implement;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.u_actions.models.User;
import com.myself.u_actions.repositories.UserRepository;
import com.myself.u_actions.services.UserService;

@Service
public class UserServiceImplement implements UserService{

  @Autowired
  UserRepository userRepository;
  
  @Override
  public User getUserByEmail(String email) {
    User user = userRepository.findByEmail(email)
      .orElseThrow(() -> new NoSuchElementException("User not found with email: " + email));
    return user;  
  }

}
