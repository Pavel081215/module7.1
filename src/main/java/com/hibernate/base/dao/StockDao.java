package com.hibernate.base.dao;

import com.hibernate.base.model.Dish;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.OrderName;
import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockDao {
    @Transactional
    void save(Stock stock);

    @Transactional
    Employee load(Long id);

    @Transactional

    List<Stock> findAll();

    @Transactional
    void remove(Stock stock);

    @Transactional
    void removeAll();

    @Transactional
    Stock findByName(String name);
}
