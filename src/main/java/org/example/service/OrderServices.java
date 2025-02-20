package org.example.service;

import org.example.dto.Order;

import java.util.List;

public interface OrderServices {

    void addOrder(Order Order);
    Order searchByID(String id);
    void updateOrder(Order Order);

    void deleteOrder(String id);
    List<Order> getAll();
    List<Order> searchByName(String name);
}
