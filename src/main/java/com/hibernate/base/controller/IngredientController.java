package com.hibernate.base.controller;

import com.hibernate.base.dao.hibernate.HIngredientDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.DishCategory;
import com.hibernate.base.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 10.07.2016.
 */
public class IngredientController {
    private HIngredientDao hIngredientDao;

    public void sethIngredientDao(HIngredientDao hIngredientDao) {
        this.hIngredientDao = hIngredientDao;
    }
    @Transactional
    public void createIngredient() {
        Set<Ingredient> ingredients = new HashSet<>(hIngredientDao.findAll());

        Ingredient ingredient = new Ingredient();
        ingredient.setName("cabbage");
        if (!ingredients.contains(ingredient)) {
            hIngredientDao.save(ingredient);
        }

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("potato");
        if (!ingredients.contains(ingredient)) {
            hIngredientDao.save(ingredient3);
        }

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("tomatoes");
        if (!ingredients.contains(ingredient)) {
            hIngredientDao.save(ingredient1);
        }

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("garlic");
        if (!ingredients.contains(ingredient)) {
            hIngredientDao.save(ingredient2);
        }




    }
    @Transactional
    public List<Ingredient> getAllDashes(){
        return hIngredientDao.findAll();
    }
    @Transactional
    public Ingredient getIngredientByName(String name){
        return hIngredientDao.findByName(name);
    }
    @Transactional
    public void removeAll(){
        hIngredientDao.removeAll();
    }
}
