package com.harold.persist;

import com.harold.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Stateless
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

    @TransactionAttribute
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @TransactionAttribute
    public void update(Product product) {
        entityManager.merge(product);
    }

    @TransactionAttribute
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

    public List<Product> findByPriceBetween(Double min, Double max){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        Predicate predicate = cb.between(root.get("cost"), min, max);
        criteriaQuery.select(root).where(predicate);
        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
