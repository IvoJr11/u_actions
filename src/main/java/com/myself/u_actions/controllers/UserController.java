package com.myself.u_actions.controllers;

import com.myself.u_actions.models.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.myself.u_actions.models.User;
import com.myself.u_actions.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

  @GetMapping("/email")
  public ResponseEntity<User> getUserByEmail(@RequestParam String userEmail) {
    User user = userService.getUserByEmail(userEmail);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.FOUND);
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register(@RequestParam String name, @RequestParam String email,
                                         @RequestParam String password, @RequestParam String country) {
    System.out.println(name + " " + email + " " + password + " " + country);
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

    User newUser = new User(name, email, passwordEncoder.encode(password), country, Role.INVERSTOR);
    userService.saveUser(newUser);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/owo")
  public String owo() {
    return "owo";
  }

}
