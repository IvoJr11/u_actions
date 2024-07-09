package com.myself.u_actions.services.implement;


import java.util.List;

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
  public List<User> getAllUsers() {
      return userRepository.findAll();
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email)
      .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
  }

  @Override
  public void deleteUser(String email) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    userRepository.delete(user);
  }

}
