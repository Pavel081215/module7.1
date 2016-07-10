package com.hibernate.base.dao;

import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Ingredient;

import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IngredientDao {
    @Transactional
    void save(Ingredient ingredient);

    @Transactional
    Employee load(Long id);

    @Transactional
    List<Ingredient> findAll();

    @Transactional
    void remove(Ingredient ingredient);

    @Transactional
    void removeAll();

    @Transactional
    Ingredient findByName(String name);
}
