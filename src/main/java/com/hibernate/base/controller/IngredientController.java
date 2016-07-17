package com.hibernate.base.controller;

import com.hibernate.base.dao.hibernate.HIngredientDao;
import com.hibernate.base.model.*;
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
        ingredient.setName(IngredientName.tomatoes);

        if (!ingredients.contains(ingredient)) {
            hIngredientDao.save(ingredient);
        }

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName(IngredientName.pork);
        if (!ingredients.contains(ingredient3)) {
            hIngredientDao.save(ingredient3);
        }

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName(IngredientName.salt);
        if (!ingredients.contains(ingredient1)) {
            hIngredientDao.save(ingredient1);
        }

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName(IngredientName.onion);
        if (!ingredients.contains(ingredient2)) {
            hIngredientDao.save(ingredient2);
        }

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName(IngredientName.beef);
        if (!ingredients.contains(ingredient4)) {
            hIngredientDao.save(ingredient4);
        }

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setName(IngredientName.cabbage);
        if (!ingredients.contains(ingredient5)) {
            hIngredientDao.save(ingredient5);
        }

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setName(IngredientName.carrot);
        if (!ingredients.contains(ingredient6)) {
            hIngredientDao.save(ingredient6);
        }

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setName(IngredientName.cucumber);
        if (!ingredients.contains(ingredient7)) {
            hIngredientDao.save(ingredient7);
        }

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setName(IngredientName.salmon);
        if (!ingredients.contains(ingredient8)) {
            hIngredientDao.save(ingredient8);
        }
        Ingredient ingredient9 = new Ingredient();
        ingredient9.setName(IngredientName.sugar);
        if (!ingredients.contains(ingredient9)) {
            hIngredientDao.save(ingredient9);
        }
    }
    @Transactional
    public List<Ingredient> getAllDashes(){
        return hIngredientDao.findAll();
    }
    @Transactional
    public Ingredient getIngredientByName(IngredientName  name){
        return hIngredientDao.findByName(name);
    }
    @Transactional
    public void removeAll(){
        hIngredientDao.removeAll();
    }

    @Transactional
    public void print (IngredientName name){
        System.out.println(getIngredientByName(name));
    }


}
