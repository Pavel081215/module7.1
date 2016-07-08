package com.hibernate.base.dao;


import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public interface DishDao {

    @Transactional
    void save(Dish dish);
    @Transactional
    Employee load (Long id);
    @Transactional
    List<Dish> findAll ();
    @Transactional
    void remove(Dish dish);
}
