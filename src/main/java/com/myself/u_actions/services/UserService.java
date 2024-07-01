package com.myself.u_actions.services;

import com.myself.u_actions.models.User;

public interface UserService {
  User getUserByEmail(String email);
}
