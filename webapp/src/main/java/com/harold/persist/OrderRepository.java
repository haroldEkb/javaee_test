package com.harold.persist;

import com.harold.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class OrderRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            if (this.findAll().isEmpty()) {
                for (int i = 0; i < 9; i++) {
                    this.insert(new Order(Order.Status.CREATED, 100.0*i, "no_address"));
                }
            }
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }

    @TransactionAttribute
    public void insert(Order order) {
        entityManager.persist(order);
    }

    @TransactionAttribute
    public void update(Order order) {
        entityManager.merge(order);
    }

    @TransactionAttribute
    public void delete(int id) {
        Order order = findById(id);

        if (order != null) {
            entityManager.remove(order);
        }
    }

    public Order findById(int id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> findAll() {
        return entityManager.createQuery("from Order", Order.class).getResultList();
    }
}
