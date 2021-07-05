package com.harold.persist;

import com.harold.entity.Role;
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
public class RoleRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            if (this.findAll().isEmpty()) {
                this.insert(new Role("ADMIN"));
                this.insert(new Role("GUEST"));
                this.insert(new Role("MANAGER"));
            }
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }

    @TransactionAttribute
    public void insert(Role role) {
        entityManager.persist(role);
    }

    @TransactionAttribute
    public void update(Role role) {
        entityManager.merge(role);
    }

    @TransactionAttribute
    public void delete(int id) {
        Role role = findById(id);

        if (role != null) {
            entityManager.remove(role);
        }
    }

    public Role findById(int id) {
        return entityManager.find(Role.class, id);
    }

    public List<Role> findAll() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
}
