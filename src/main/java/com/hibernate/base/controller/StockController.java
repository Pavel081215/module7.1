package com.hibernate.base.controller;

import com.hibernate.base.dao.StockDao;
import com.hibernate.base.dao.hibernate.HIngredientDao;
import com.hibernate.base.dao.hibernate.HStockDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Ingredient;
import com.hibernate.base.model.OrderName;
import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 10.07.2016.
 */
public class StockController {
    private HStockDao stockDao;
    private HIngredientDao hIngredientDao;

    public void sethIngredientDao(HIngredientDao hIngredientDao) {
        this.hIngredientDao = hIngredientDao;
    }

    public void setStockDao(HStockDao stockDao) {
        this.stockDao = stockDao;
    }


    @Transactional
    public void createStoke(List<String> ingredient) {
        Stock stock = new Stock();
        stock.setName("Common");
        stock.setIngredients( createIngredient(ingredient));
        stockDao.save(stock);


    }
    @Transactional
    private List<Ingredient> createIngredient(List<String> ingredirnt) {
        List<Ingredient> result = new ArrayList<>();
        for (String ingredientName : ingredirnt) {
            result.add(hIngredientDao.findByName(ingredientName));
        }
        return result;
    }

    @Transactional
    public List<Stock> getAllOrders(){
        return stockDao.findAll();
    }

    @Transactional
    public  void print ( ){
        getAllOrders().forEach(System.out::println);
    }

    @Transactional
    public void remove(){
        stockDao.removeAll();

    }


}
