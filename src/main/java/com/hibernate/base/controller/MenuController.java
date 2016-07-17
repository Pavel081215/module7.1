package com.hibernate.base.controller;

import com.hibernate.base.dao.hibernate.HDishDao;
import com.hibernate.base.dao.hibernate.HMenuDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class MenuController {

    private HMenuDao hMenuDao;

    private HDishDao hDishDao;

    private OrderController orderController;

    public void sethMenuDao(HMenuDao hMenuDao) {
        this.hMenuDao = hMenuDao;
    }

    public void sethDishDao(HDishDao hDishDao) {
        this.hDishDao = hDishDao;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @Transactional
    public void createMenu() {
        List<String> dish = new ArrayList<>();
        dish.add("Soup");
        dish.add("Plov");
        Menu menu = new Menu();
        menu.setName("Super");
        menu.setDishs(createDishes(dish));
        hMenuDao.save(menu);
    }


    @Transactional
    public List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(hDishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return hMenuDao.findAll();
    }

    @Transactional
    public void print() {
        getAllMenu().forEach(System.out::println);
    }

    @Transactional
    public void removeAll() {
        hMenuDao.removeAll();

    }

}
