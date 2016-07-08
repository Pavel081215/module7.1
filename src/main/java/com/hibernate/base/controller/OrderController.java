package com.hibernate.base.controller;

import com.hibernate.base.dao.OrderNameDao;

/**
 * Created by Pavel on 08.07.2016.
 */
public class OrderController {
     private OrderNameDao orderNameDao;

    public void setOrderNameDao(OrderNameDao orderNameDao) {
        this.orderNameDao = orderNameDao;
    }
}
