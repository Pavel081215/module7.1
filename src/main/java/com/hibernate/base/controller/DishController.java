package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.hibernate.HDishDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.DishCategory;
import com.hibernate.base.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */
public class DishController {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
    @Transactional
    public void createDish() {
        Set<Dish> dishSet = new HashSet<>(dishDao.findAll());

        Dish dish = new Dish();
        dish.setName("Plov");
        dish.setDishCategory(DishCategory.second);
        dish.setPrice("300");
        dish.setWeigth(200.0F);
        if (!dishSet.contains(dish)) {
            dishDao.save(dish);
        }


        Dish dish1 = new Dish();
        dish1.setName("Soup");
        dish1.setDishCategory(DishCategory.first);
        dish1.setPrice("400");
        dish1.setWeigth(200.0F);
        if (!dishSet.contains(dish1)) {
            dishDao.save(dish1);
        }


        Dish dish2 = new Dish();
        dish2.setName("Compot");
        dish2.setDishCategory(DishCategory.third);
        dish2.setPrice("500");
        dish2.setWeigth(900.0F);
        if (!dishSet.contains(dish2)) {
            dishDao.save(dish2);
        }
    }

    public List<Dish> getAllDashes(){
        return dishDao.findAll();
    }

    public Dish getDishByName(String name){
        return dishDao.findByName(name);
    }
}
