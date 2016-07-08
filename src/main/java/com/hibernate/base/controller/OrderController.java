package com.hibernate.base.controller;

import com.hibernate.base.dao.OrderNameDao;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public class OrderController {
     private OrderNameDao orderNameDao;

    public void setOrderNameDao(OrderNameDao orderNameDao) {
        this.orderNameDao = orderNameDao;
    }


    public void createOrder(String waiterName, List <String> dishes ){

    }
}
