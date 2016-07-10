package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.IngredientDao;
import com.hibernate.base.dao.hibernate.HDishDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.DishCategory;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */
public class DishController {

    private DishDao dishDao;
    private IngredientDao hIngredientDao;

    public void sethIngredientDao(IngredientDao hIngredientDao) {
        this.hIngredientDao = hIngredientDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
    @Transactional
    public void createDish() {
        Set<Dish> dishSet = new HashSet<>(dishDao.findAll());
        List <String> ingredients1 = new ArrayList<>();
        ingredients1.add("cabbage");
        ingredients1.add("potato");
        List <String> ingredients2 = new ArrayList<>();
        ingredients2.add("cabbage");
        ingredients2.add("tomatoes");
        ingredients2.add("garlic");
        List <String> ingredients3 = new ArrayList<>();
        ingredients3.add("potato");

        Dish dish = new Dish();
        dish.setName("Plov");
        dish.setDishCategory(DishCategory.second);
        dish.setIngredients(createIngredient(ingredients1));
        dish.setPrice("300");
        dish.setWeigth(200.0F);
        if (!dishSet.contains(dish)) {
            dishDao.save(dish);
        }


        Dish dish1 = new Dish();
        dish1.setName("Soup");
        dish1.setDishCategory(DishCategory.first);
        dish1.setIngredients(createIngredient(ingredients2));
        dish1.setPrice("400");
        dish1.setWeigth(200.0F);
        if (!dishSet.contains(dish1)) {
            dishDao.save(dish1);
        }


        Dish dish2 = new Dish();
        dish2.setName("Compot");
        dish2.setDishCategory(DishCategory.third);
        dish2.setIngredients(createIngredient(ingredients3));
        dish2.setPrice("500");
        dish2.setWeigth(900.0F);
        if (!dishSet.contains(dish2)) {
            dishDao.save(dish2);
        }
    }

    private List<Ingredient> createIngredient(List <String> ingredients) {
        List<Ingredient> result = new ArrayList<>();
        for (String ingredientName : ingredients) {
            result.add(hIngredientDao.findByName(ingredientName));
        }
        return result;
    }

    @Transactional
    public List<Dish> getAllDashes(){
        return dishDao.findAll();
    }
    @Transactional
    public Dish getDishByName(String name){
        return dishDao.findByName(name);
    }
    @Transactional
    public void removeAll(){
        dishDao.removeAll();
    }
}
