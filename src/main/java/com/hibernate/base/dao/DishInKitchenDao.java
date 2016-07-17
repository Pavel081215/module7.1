package com.hibernate.base.dao;

import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 18.07.2016.
 */
public interface DishInKitchenDao {
    @Transactional
    void save(DishInKitchen dishInKitchen);

    @Transactional
    Stock load(Long id);

    @Transactional
    List<DishInKitchen> findAll();

    @Transactional
    void remove(DishInKitchen dishInKitchen);

    @Transactional
    void removeAll();

    @Transactional
    Stock findByName(String name);
}
