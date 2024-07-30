package com.myself.u_actions.services.OrderServices;

import java.util.List;

import com.myself.u_actions.models.Order;

public interface OrderService {
  List<Order> getAll();
  Order getOrderByID(Long id);
  void saveOrder(Order order);
  void deleteOrder(Long id);
}
