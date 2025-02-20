package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Order;
import org.example.entity.OrderEntity;
import org.example.repository.OrderRepository;
import org.example.service.OrderServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceimpl implements OrderServices {
    final OrderRepository OrderRepository;
    final ModelMapper modelMapper;

    @Override
    public void addOrder(Order Order) {
        OrderRepository.save(modelMapper.map(Order, OrderEntity.class));
    }

    @Override
    public Order searchByID(String id) {
        return modelMapper.map(OrderRepository.findById(id), Order.class);
    }

    @Override
    public void updateOrder(Order Order) {
        OrderRepository.save(modelMapper.map(Order, OrderEntity.class));
    }

    @Override
    public void deleteOrder(String id) {
        OrderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        List<Order> OrderList = new ArrayList<>();
        List<OrderEntity> all = OrderRepository.findAll();

        all.forEach(OrderEntity -> {
            OrderList.add(modelMapper.map(OrderEntity, Order.class));
        });

        return OrderList;
    }

    @Override
    public List<Order> searchByName(String name) {
        List<OrderEntity> byName = OrderRepository.findByName(name);
        List<Order> OrderList = new ArrayList<>();
        byName.forEach(OrderEntity -> {
            OrderList.add(modelMapper.map(OrderEntity, Order.class));
        });

        return OrderList;
    }
}
