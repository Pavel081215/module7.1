package com.hibernate.base.controller;

import com.hibernate.base.dao.hibernate.HIngredientDao;
import com.hibernate.base.model.*;
import com.hibernate.base.service.StockServiceImp;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 10.07.2016.
 */
public class StockController {


    private StockServiceImp stockServiceImp;

    public void setStockServiceImp(StockServiceImp stockServiceImp) {
        this.stockServiceImp = stockServiceImp;
    }

    private HIngredientDao hIngredientDao;

    public void sethIngredientDao(HIngredientDao hIngredientDao) {
        this.hIngredientDao = hIngredientDao;
    }


    @Transactional
    public void createStoke(List<IngredientName> ingredient) {
        Stock stock = new Stock();
        stock.setName("Common");
        stock.setIngredients(createIngredient(ingredient));
        stockServiceImp.save(stock);


    }

    @Transactional
    private List<Ingredient> createIngredient(List<IngredientName> ingredirnt) {
        List<Ingredient> result = new ArrayList<>();
        for (IngredientName ingredientName : ingredirnt) {
            result.add(hIngredientDao.findByName(ingredientName));
        }
        return result;
    }

    @Transactional
    public List<Stock> getAllStock() {
        return stockServiceImp.findAll();
    }

    @Transactional
    public void print() {
        System.out.println("printVVVV");
        getAllStock().forEach(System.out::println);
    }

    @Transactional
    public void remove() {
        stockServiceImp.removeAll();
    }

    @Transactional
    public void addOneIngredient(Ingredient ingredient) {
        stockServiceImp.addOneIngredient(ingredient);

    }


}
