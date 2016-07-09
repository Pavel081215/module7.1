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

    private OrderNameDao orderNameDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }


    public void setOrderNameDao(OrderNameDao orderNameDao) {
        this.orderNameDao = orderNameDao;
    }

    @Transactional
    public void createOrder(String waiterName, List<String> dishes) {
        OrderName orderName = new OrderName();
        orderName.setWaiter(employeeDao.findByName(waiterName));
        orderName.setDishes(createDishes(dishes));
        orderName.setTable_number(2);
        orderName.setTime(new Date());

        orderNameDao.save(orderName);


    }
    @Transactional
    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public List<OrderName> getAllOrders(){
        return orderNameDao.findAll();
    }

    @Transactional
    public  void print ( ){

       getAllOrders().forEach(System.out::println);
    }

}
