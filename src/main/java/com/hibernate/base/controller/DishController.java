package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.IngredientDao;
import com.hibernate.base.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        Dish dish = new Dish();
        Map<Ingredient,Long> recipes = new HashMap<>();
        recipes.put(hIngredientDao.findByName(IngredientName.sugar),900l);
        recipes.put(hIngredientDao.findByName(IngredientName.cucumber),900l);
        recipes.put(hIngredientDao.findByName(IngredientName.onion),1000l);
       /* recipes.put(hIngredientDao.findByName(IngredientName.tomatoes),400l);
        recipes.put(hIngredientDao.findByName(IngredientName.beef),500l);*/
        dish.setName("Plov");
        dish.setWeigth(1000.0F);
        dish.setPrice("6000");
        dish.setDishCategory(DishCategory.second);
        dish.setRecipes(recipes);
        hDishDao.save(dish);



       /* Dish dish1 = new Dish();
        Map<Ingredient,Long> recipes1 = new HashMap<>();
        recipes1.put(hIngredientDao.findByName(IngredientName.sugar),1000l);
        recipes1.put(hIngredientDao.findByName(IngredientName.salmon),2000l);
        recipes1.put(hIngredientDao.findByName(IngredientName.cabbage),3000l);
        recipes1.put(hIngredientDao.findByName(IngredientName.tomatoes),4000l);
        recipes1.put(hIngredientDao.findByName(IngredientName.beef),5000l);
        dish1.setName("Soup");
        dish1.setWeigth(7000.0F);
        dish1.setPrice("1000");
        dish1.setDishCategory(DishCategory.third);
        dish1.setRecipes(recipes1);
        hDishDao.save(dish1);


        Dish dish2 = new Dish();
        Map<Ingredient,Long> recipes2 = new HashMap<>();
        recipes2.put(hIngredientDao.findByName(IngredientName.sugar),1000l);
        recipes2.put(hIngredientDao.findByName(IngredientName.salmon),2000l);
        recipes2.put(hIngredientDao.findByName(IngredientName.cabbage),3000l);
        recipes2.put(hIngredientDao.findByName(IngredientName.tomatoes),4000l);
        recipes2.put(hIngredientDao.findByName(IngredientName.beef),5000l);
        dish2.setName("Compot");
        dish2.setWeigth(70000.0F);
        dish2.setPrice("15000");
        dish2.setDishCategory(DishCategory.first);
        dish2.setRecipes(recipes2);
        hDishDao.save(dish2);*/


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
