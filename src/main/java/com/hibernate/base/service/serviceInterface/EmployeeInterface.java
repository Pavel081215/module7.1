package com.hibernate.base.service.serviceInterface;

import com.hibernate.base.model.DishInKitchen;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 22.07.2016.
 */
public interface EmployeeInterface {

    @Transactional
    void save(Employee employee);

    @Transactional
    Stock load(Long id);

    @Transactional
    List<Employee> findAll();

    @Transactional
    void remove(Employee employee);

    @Transactional
    void removeAll();

    @Transactional
    Employee findByName(String name);


}
