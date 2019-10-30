package com.harold.persist;

import com.harold.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    @Transactional
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

    @Transactional
    public void insert(Order order) {
        entityManager.persist(order);
    }

    @Transactional
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Transactional
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
