package com.harold.persist;

import com.harold.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            if (this.findAll().isEmpty()) {
                for (int i = 0; i < 9; i++) {
                    this.insert(new Product(i, "Apple" + i, 100*i));
                }
            }
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }

    @Transactional
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void delete(int id) {
        Product product = findById(id);

        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }
}
