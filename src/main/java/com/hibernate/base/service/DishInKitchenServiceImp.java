package com.hibernate.base.service;

import com.hibernate.base.dao.DishInKitchenDao;
import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Stock;
import com.hibernate.base.service.serviceInterface.DishInKitchenInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 18.07.2016.
 */
public class DishInKitchenServiceImp implements DishInKitchenInterface {

    private DishInKitchenDao dishInKitchenDao;

    public void setDishInKitchenDao(DishInKitchenDao dishInKitchenDao) {
        this.dishInKitchenDao = dishInKitchenDao;
    }
    @Transactional
    @Override
    public void save(DishInKitchen dishInKitchen) {
        dishInKitchenDao.save(dishInKitchen);
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
