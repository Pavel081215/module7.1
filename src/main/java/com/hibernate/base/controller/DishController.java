package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.IngredientDao;
import com.hibernate.base.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */
public class DishController {

    private DishDao hDishDao;
    private IngredientDao hIngredientDao;

    public void sethIngredientDao(IngredientDao hIngredientDao) {
        this.hIngredientDao = hIngredientDao;
    }

    public void sethDishDao(DishDao hDishDao) {
        this.hDishDao = hDishDao;
    }
    @Transactional
    public void createDish() {
        Set<Dish> dishSet = new HashSet<>(hDishDao.findAll());

        List <IngredientName> ingredients1 = new ArrayList<>();
        ingredients1.add(IngredientName.carrot);
        ingredients1.add(IngredientName.salt);

        List <IngredientName> ingredients2 = new ArrayList<>();
        ingredients2.add(IngredientName.sugar);
        ingredients2.add(IngredientName.pork);
        ingredients2.add(IngredientName.onion);

        List <IngredientName> ingredients3 = new ArrayList<>();
        ingredients3.add(IngredientName.cucumber);

        Dish dish = new Dish();
        dish.setName("Plov");
        dish.setDishCategory(DishCategory.second);
        dish.setIngredients(createIngredient(ingredients1));
        dish.setPrice("300");
        dish.setWeigth(200.0F);
        if (!dishSet.contains(dish)) {
            hDishDao.save(dish);
        }


        Dish dish1 = new Dish();
        dish1.setName("Soup");
        dish1.setDishCategory(DishCategory.first);
        dish1.setIngredients(createIngredient(ingredients2));
        dish1.setPrice("400");
        dish1.setWeigth(200.0F);
        if (!dishSet.contains(dish1)) {
            hDishDao.save(dish1);
        }


        Dish dish2 = new Dish();
        dish2.setName("Compot");
        dish2.setDishCategory(DishCategory.third);
        dish2.setIngredients(createIngredient(ingredients3));
        dish2.setPrice("500");
        dish2.setWeigth(900.0F);
        if (!dishSet.contains(dish2)) {
            hDishDao.save(dish2);
        }
    }

    private List<Ingredient> createIngredient(List <IngredientName> ingredients) {
        List<Ingredient> result = new ArrayList<>();
        for (IngredientName ingredientName : ingredients) {
            result.add(hIngredientDao.findByName(ingredientName));
        }
        return result;
    }

    @Transactional
    public List<Dish> getAllDashes(){
        return hDishDao.findAll();
    }
    @Transactional
    public Dish getDishByName(String name){
        return hDishDao.findByName(name);
    }
    @Transactional
    public void removeAll(){
        hDishDao.removeAll();
    }
}
