package com.harold.service;

import com.harold.entity.Order;
import com.harold.persist.OrderRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class OrderService implements Serializable {

    @Inject
    private OrderRepository orderRepository;

    public Order findById(int i) {
        return orderRepository.findById(i);
    }

    public void insert(Order order) {
        orderRepository.insert(order);
    }

    public void update(Order order) {
        orderRepository.update(order);
    }

    public void delete(Integer id) {
        orderRepository.delete(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
