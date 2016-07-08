package com.hibernate.base.dao;

import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.OrderName;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public interface OrderNameDao {
    @Transactional
    void save(OrderName orderName);
    @Transactional
    Employee load (Long id);
    @Transactional
    List<OrderName> findAll ();
    @Transactional
    void remove(OrderName orderName);
}
