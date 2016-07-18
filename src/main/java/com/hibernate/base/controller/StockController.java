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
    public void createStoke() {
        Stock stock = new Stock();
        stock.setQuantity(10l);
        stock.setCost(200l);
        stock.setNameIngredient(hIngredientDao.findByName(IngredientName.cucumber));
        stockServiceImp.save(stock);


        Stock stock1 = new Stock();
        stock1.setQuantity(20l);
        stock1.setCost(300l);
        stock1.setNameIngredient(hIngredientDao.findByName(IngredientName.sugar));
        stockServiceImp.save(stock1);

        Stock stock2 = new Stock();
        stock2.setQuantity(50l);
        stock2.setCost(700l);
        stock2.setNameIngredient(hIngredientDao.findByName(IngredientName.onion));
        stockServiceImp.save(stock2);


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
