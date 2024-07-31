package com.myself.u_actions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.myself.u_actions.dtos.CreateOrderDTO;
import com.myself.u_actions.models.Order;
import com.myself.u_actions.models.User;
import com.myself.u_actions.services.OrderServices.OrderService;
import com.myself.u_actions.services.UserServices.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/order")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<Order>> getAll() {
    return ResponseEntity.ok(orderService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOrderByID(@PathVariable Long id) {
    if(id <= 0) {
      return new ResponseEntity<>("ID cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(orderService.getOrderByID(id));
  }

  @PostMapping("/create")
  public ResponseEntity<Object> createOrder(@RequestBody CreateOrderDTO orderDTO, Authentication authentication) {
    User user = userService.getUserByEmail(authentication.getName());
    if(user == null) {
      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    if(orderDTO.getQuantity() <= 0) {
      return new ResponseEntity<>("Quantity cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    if(orderDTO.getPrice() <= 0) {
      return new ResponseEntity<>("Price cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    if(orderDTO.getState() == null) {
      return new ResponseEntity<>("State cannot be null", HttpStatus.BAD_REQUEST);
    }
    if(orderDTO.getTransactions() == null) {
      return new ResponseEntity<>("Transactions cannot be null", HttpStatus.BAD_REQUEST);
    }
    if(orderDTO.getOrderStocks() == null) {
      return new ResponseEntity<>("OrderStocks cannot be null", HttpStatus.BAD_REQUEST);
    }
    Order order = new Order(orderDTO.getQuantity(), orderDTO.getPrice(), orderDTO.getState(), user, orderDTO.getTransactions(), orderDTO.getOrderStocks());
    orderService.saveOrder(order);
    return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
    if(id <= 0 | id == null) {
      return new ResponseEntity<>("ID cannot be 0 or negative", HttpStatus.BAD_REQUEST);
    }
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
  }
}
