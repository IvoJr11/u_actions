package com.myself.u_actions.controllers;

import com.myself.u_actions.models.Role;
import com.myself.u_actions.services.UserServices.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.myself.u_actions.models.User;
import com.myself.u_actions.services.UserServices.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.myself.u_actions.Utils.Utils;


@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @GetMapping("/all")
  public ResponseEntity<Object> getALlUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @GetMapping("/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    try {
      User user = userService.getUserByEmail(email);
      return new ResponseEntity<>(user, HttpStatus.FOUND);
    } catch (UserNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register(@RequestParam String name, @RequestParam String email,
                                         @RequestParam String password, @RequestParam String country,
                                         @RequestParam String role) {
    if(name.isEmpty()) {
      return new ResponseEntity<>("Name cannot be empty", HttpStatus.BAD_REQUEST);
    }
    if(email.isEmpty()) {
      return new ResponseEntity<>("Email cannot be empty", HttpStatus.BAD_REQUEST);
    }
    if(password.isEmpty()) {
      return new ResponseEntity<>("Password cannot be empty", HttpStatus.BAD_REQUEST);
    }
    if(country.isEmpty()) {
      return new ResponseEntity<>("Country cannot be empty", HttpStatus.BAD_REQUEST);
    }
    if(role.isEmpty()) {
      return new ResponseEntity<>("Role cannot be empty", HttpStatus.BAD_REQUEST);
    }
    if(!Utils.enumContains(Role.class, role)) {
      return new ResponseEntity<>("Invalid role", HttpStatus.BAD_REQUEST);
    }

    try {
      if(userService.getUserByEmail(email) != null) {
        return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
      }
    } catch (UserNotFoundException ignored) {
    }

    User newUser = new User(name, email, passwordEncoder.encode(password), country, Role.valueOf(role.toUpperCase()));
    userService.saveUser(newUser);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{email}")
  public ResponseEntity<Object> deleteUser(@PathVariable String email) {
    try {
      userService.getUserByEmail(email);
      userService.deleteUser(email);
      return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    } catch (UserNotFoundException e) {
      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
  }
}
