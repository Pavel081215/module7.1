package com.hibernate.base.dao;

import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 10.07.2016.
 */
public interface MenuDao {
    @Transactional
    void save(Menu menu);

    @Transactional
    Employee load(Long id);

    @Transactional
    List<Menu> findAll();

    @Transactional
    void remove(Menu menu);

    @Transactional
    void removeAll();

    @Transactional
    Menu findByName(String name);
}
