package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Ingredient;
import com.hibernate.base.model.IngredientName;
import com.hibernate.base.model.Stock;
import com.hibernate.base.service.DishInKitchenServiceImp;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 18.07.2016.
 */
public class DishInKitchenController {


    private DishInKitchenServiceImp dishInKitchenServiceImp;
    private EmployeeDao hEmployeeDao;
    private DishDao hDishDao;

    public void sethEmployeeDao(EmployeeDao hEmployeeDao) {
        this.hEmployeeDao = hEmployeeDao;
    }

    public void sethDishDao(DishDao hDishDao) {
        this.hDishDao = hDishDao;
    }


    public void setDishInKitchenServiceImp(DishInKitchenServiceImp dishInKitchenServiceImp) {
        this.dishInKitchenServiceImp = dishInKitchenServiceImp;
    }

    @Transactional
    public void createDishInKitchen() {
        DishInKitchen dishInKitchen = new DishInKitchen();
        dishInKitchen.setCook(hEmployeeDao.findByName("Ivan"));
        dishInKitchen.setDishes_id(hDishDao.findByName("Plov"));

        dishInKitchenServiceImp.save(dishInKitchen);

    }

   /* @Transactional
    private List<Ingredient> createIngredient(List<IngredientName> ingredirnt) {
        List<Ingredient> result = new ArrayList<>();
        for (IngredientName ingredientName : ingredirnt) {
            result.add(hIngredientDao.findByName(ingredientName));
        }
        return result;
    }*/

    @Transactional
    public List<DishInKitchen> getAllDishInKitchen() {
        return dishInKitchenServiceImp.findAll();
    }

    @Transactional
    public void print() {
        System.out.println("printVVVV");
        getAllDishInKitchen().forEach(System.out::println);
    }

    @Transactional
    public void remove() {
        dishInKitchenServiceImp.removeAll();
    }


}
