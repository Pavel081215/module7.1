package com.hibernate.base.service;

import com.hibernate.base.dao.DishInKitchenDao;
import com.hibernate.base.dao.hibernate.HStockDao;
import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Ingredient;
import com.hibernate.base.model.Stock;
import com.hibernate.base.service.serviceInterface.DishInKitchenInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pavel on 18.07.2016.
 */
public class DishInKitchenServiceImp implements DishInKitchenInterface {

    private DishInKitchenDao dishInKitchenDao;

    private HStockDao stockDao;

    public void setStockDao(HStockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void setDishInKitchenDao(DishInKitchenDao dishInKitchenDao) {
        this.dishInKitchenDao = dishInKitchenDao;
    }

    @Transactional
    @Override
    public void save(DishInKitchen dishInKitchen) {
        Map<Ingredient, Long> recipes = dishInKitchen.getDishes_id().getRecipes();
        List<Stock> stocks = stockDao.findAll();

        Map<Ingredient, Boolean> test = new HashMap<>();


        for (Map.Entry<Ingredient, Long> entry : recipes.entrySet()) {
            Ingredient key = entry.getKey();
            Long value = entry.getValue();

            test.put(key, false);

            for (Stock stock : stocks) {
                if (stock.getNameIngredient().getName().equals(key.getName())) {
                    if (stock.getQuantity() >= value) {
                        test.remove(key);
                        test.put(key, true);
                    }
                }
            }
        }
        boolean checkStockAvailability = true;

        for (Map.Entry<Ingredient, Boolean> entry : test.entrySet()) {
            Ingredient key = entry.getKey();
            Boolean value = entry.getValue();
            if (value == false) {
                checkStockAvailability = false;
            }
        }

        if (checkStockAvailability) {

            dishInKitchenDao.save(dishInKitchen);

            for (Map.Entry<Ingredient, Long> entry : recipes.entrySet()) {
                Ingredient key = entry.getKey();
                Long value = entry.getValue();
                for (Stock stock : stocks) {
                    if (stock.getNameIngredient().getName().equals(key.getName())) {
                        stock.setQuantity(stock.getQuantity() - value);
                        stockDao.save(stock);
                    }
                }
            }
        } else {
            System.out.println("Enough ingredients");
        }
    }

    @Transactional
    @Override
    public Stock load(Long id) {
        return dishInKitchenDao.load(id);
    }

    @Transactional
    @Override
    public List<DishInKitchen> findAll() {
        return dishInKitchenDao.findAll();
    }

    @Transactional
    @Override
    public void remove(DishInKitchen dishInKitchen) {
        dishInKitchenDao.remove(dishInKitchen);
    }

    @Transactional
    @Override
    public void removeAll() {
        dishInKitchenDao.removeAll();
    }

    @Transactional
    @Override
    public Stock findByName(String name) {
        return dishInKitchenDao.findByName(name);
    }
}
