package com.hibernate.base.service;


import com.hibernate.base.dao.hibernate.HStockDao;
import com.hibernate.base.model.Ingredient;
import com.hibernate.base.model.Stock;
import com.hibernate.base.service.serviceInterface.StockInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockServiceImp implements StockInterface {

    private HStockDao stockDao;

    public void setStockDao(HStockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Transactional
    @Override

    public void save(Stock stock) {
        List<Stock> stocks = stockDao.findAll();
        if (stocks.isEmpty()) {
            stockDao.save(stock);
        } else {
            boolean temp = false;
            for (Stock stock1 : stocks) {
                if (stock1.equals(stock)) {
                    temp = true;
                }
            }
            if (temp) {
                for (Stock stock1 : stocks) {
                    if (stock1.equals(stock)) {
                        long temp1 = stock.getQuantity() + stock1.getQuantity();
                        stock1.setQuantity(temp1);
                        stock1.setCost(stock.getCost());
                        stockDao.save(stock1);
                    }
                }
            } else {
                stockDao.save(stock);
            }
        }
    }

    @Transactional
    @Override
    public Stock load(Long id) {
        return stockDao.load(id);
    }

    @Transactional
    @Override
    public List<Stock> findAll() {
        return stockDao.findAll();
    }

    @Transactional
    @Override
    public void remove(Stock stock) {
        stockDao.remove(stock);

    }

    @Transactional
    @Override
    public void removeAll() {
        stockDao.removeAll();

    }

    @Transactional
    @Override
    public Stock findByName(String name) {
        return stockDao.findByName(name);
    }

    @Transactional
    @Override
    public void addOneIngredient(Ingredient ingredient) {


    }
}
