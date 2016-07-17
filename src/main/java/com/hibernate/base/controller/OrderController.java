package com.hibernate.base.controller;

import com.hibernate.base.dao.DishDao;
import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.dao.OrderNameDao;
import com.hibernate.base.model.Dish;
import com.hibernate.base.model.OrderName;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public class OrderController {

    private OrderNameDao hOrderDao;
    private EmployeeDao hEmployeeDao;
    private DishDao hDishDao;

    public void sethEmployeeDao(EmployeeDao hEmployeeDao) {
        this.hEmployeeDao = hEmployeeDao;
    }

    public void sethDishDao(DishDao hDishDao) {
        this.hDishDao = hDishDao;
    }


    public void sethOrderDao(OrderNameDao hOrderDao) {
        this.hOrderDao = hOrderDao;
    }

    @Transactional
    public void createOrder(String waiterName, List<String> dishes) {
        OrderName orderName = new OrderName();
        orderName.setWaiter(hEmployeeDao.findByName(waiterName));
        orderName.setDishes(createDishes(dishes));
        orderName.setTable_number(2);
        orderName.setTime(new Date());

        hOrderDao.save(orderName);


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
    public List<OrderName> getAllOrders(){
        return hOrderDao.findAll();
    }

    @Transactional
    public  void print ( ){
       getAllOrders().forEach(System.out::println);
    }

    @Transactional
    public void remove(){
        hOrderDao.removeAll();

    }

}
