package com.myself.u_actions.services;

import com.myself.u_actions.models.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();
  void saveUser(User user);
  User getUserByEmail(String email);
}
