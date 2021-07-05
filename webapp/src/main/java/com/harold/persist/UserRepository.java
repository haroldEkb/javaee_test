package com.harold.persist;

import com.harold.entity.User;
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
public class UserRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            if (this.findAll().isEmpty()) {
                for (int i = 0; i < 9; i++) {
                    this.insert(new User("User" + i, String.valueOf(100*i)));
                }
            }
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }

    @TransactionAttribute
    public void insert(User user) {
        entityManager.persist(user);
    }

    @TransactionAttribute
    public void update(User user) {
        entityManager.merge(user);
    }

    @TransactionAttribute
    public void delete(int id) {
        User user = findById(id);

        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User findByLogin(String login) {
        return entityManager.find(User.class, login);
    }
}
