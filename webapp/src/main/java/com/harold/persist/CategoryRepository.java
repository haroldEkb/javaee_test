package com.harold.persist;

import com.harold.entity.Category;
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
public class CategoryRepository implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            if (this.findAll().isEmpty()) {
                for (int i = 0; i < 9; i++) {
                    this.insert(new Category("Category" + i));
                }
            }
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }

    @Transactional
    public void insert(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void delete(int id) {
        Category category = findById(id);

        if (category != null) {
            entityManager.remove(category);
        }
    }

    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }
}

