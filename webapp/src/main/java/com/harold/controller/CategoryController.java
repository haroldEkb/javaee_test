package com.harold.controller;

import com.harold.entity.Category;
import com.harold.persist.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Inject
    private CategoryRepository categoryRepository;

    private Category category;
    private List<Category> categoryList;

    public Category getProduct() {
        return category;
    }

    public void setProduct(Category product) {
        this.category = product;
    }

    public List<Category> getAllCategories() {
        return categoryList;
    }

    public String createCategory() {
        this.category = new Category();
        return "/edit_category.xhtml?faces-redirect=true";
    }

    public String saveCategory() {
        if (category.getId() == null) {
            categoryRepository.insert(category);
        } else {
            categoryRepository.update(category);
        }
        return "/categories.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) {
        logger.info("Deleting Category");
        categoryRepository.delete(category.getId());
    }

    public String editProduct(Category category) {
        this.category = category;
        return "/edit_category.xhtml?faces-redirect=true";
    }

    public void preloadCategoryList(ComponentSystemEvent event){
        this.categoryList = categoryRepository.findAll();
    }
}
