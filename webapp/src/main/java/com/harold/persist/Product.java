package com.harold.persist;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class Product {

    private Integer id;

    @NotNull(message = "Поле не должно быть пустым")
    private String title;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0,message = "Цена должна быть неотрицательной")
    private Integer cost;

    public Product() {
    }

    public Product(Integer id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
