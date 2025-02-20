package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Order;
import org.example.service.OrderServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@RequiredArgsConstructor

public class OrderController {
    final OrderServices orderServices;

    @PostMapping("/Order-add")
    public void addOrder(@RequestBody Order Order){
        orderServices.addOrder(Order);
    }

    @GetMapping("/Order-search-by-id/{id}")
    public Order searchOrder(@PathVariable String id){
        Order Order = orderServices.searchByID(id);
        System.out.println(Order);
        return Order;
    }

    @GetMapping("/Order-search-by-name/{name}")
    public List<Order> searchByName(@PathVariable String name){
        return orderServices.searchByName(name);
    }

    @PutMapping("/Order-update")
    public void updateOrder(@RequestBody Order Order){
        orderServices.updateOrder(Order);
    }

    @DeleteMapping("/Order-Delete/{id}")
    public void deleteOrder(@PathVariable String id){
        orderServices.deleteOrder(id);
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrder(){
       return orderServices.getAll();
    }
}
