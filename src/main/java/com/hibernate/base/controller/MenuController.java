package com.hibernate.base.controller;

import com.hibernate.base.dao.hibernate.HDishDao;
import com.hibernate.base.dao.hibernate.HMemuDao;
import com.hibernate.base.dao.hibernate.HOrderNameDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class MenuController {

    private HMemuDao hmenudao;

    private HDishDao hdishdao;

    public void setHdishdao(HDishDao hdishdao) {
        this.hdishdao = hdishdao;
    }

    public void setHmenudao(HMemuDao hmenudao) {
        this.hmenudao = hmenudao;
    }

    private OrderController controllerOrders;

    public void setControllerMenu(OrderController controllerOrders) {
        this.controllerOrders = controllerOrders;
    }

    @Transactional
    public void createMenu() {
        List<String> dish = new ArrayList<>();
        dish.add("Soup");
        dish.add("Plov");
        Menu menu = new Menu();
        menu.setName("Super");
        menu.setDishs(createDishes(dish));
        hmenudao.save(menu);
    }


    @Transactional
    public List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(hdishdao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return hmenudao.findAll();
    }

    @Transactional
    public void print() {
        getAllMenu().forEach(System.out::println);
    }

    @Transactional
    public void removeAll() {
        hmenudao.removeAll();

    }

}
