package com.harold.controller;

import com.harold.entity.Order;
import com.harold.persist.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class OrderController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Inject
    private OrderRepository orderRepository;

    private Order order;
    private List<Order> orderList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public String createOrder() {
        this.order = new Order();
        return "/edit_order.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        if (order.getId() == null) {
            orderRepository.insert(order);
        } else {
            orderRepository.update(order);
        }
        return "/orders.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) {
        logger.info("Deleting order");
        orderRepository.delete(order.getId());
    }

    public String editOrder(Order order) {
        this.order = order;
        return "/edit_order.xhtml?faces-redirect=true";
    }

    public void preloadOrderList(ComponentSystemEvent event){
        this.orderList = orderRepository.findAll();
    }
}
