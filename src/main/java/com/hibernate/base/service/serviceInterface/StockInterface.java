package com.hibernate.base.service.serviceInterface;

import com.hibernate.base.model.Ingredient;
import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 16.07.2016.
 */
public interface StockInterface {
    @Transactional
    void save(Stock stock);

    @Transactional
    Stock load(Long id);

    @Transactional
    List<Stock> findAll();

    @Transactional
    void remove(Stock stock);

    @Transactional
    void removeAll();

    @Transactional
    Stock findByName(String name);

    @Transactional
    void addOneIngredient(Ingredient ingredient);
}

