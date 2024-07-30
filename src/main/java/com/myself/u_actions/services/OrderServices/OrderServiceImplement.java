package com.myself.u_actions.services.OrderServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myself.u_actions.models.Order;
import com.myself.u_actions.repositories.OrderRepository;

public class OrderServiceImplement implements OrderService {

  @Autowired
  OrderRepository orderRepository;
  @Override
  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  @Override
  public Order getOrderByID(Long id) {
    Order order = orderRepository.findById(id).get();
    return order;
  }

  @Override
  public void saveOrder(Order order) {
    orderRepository.save(order);
  }

  @Override
  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }

}
