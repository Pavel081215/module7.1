package com.hibernate.base.dao;

import com.hibernate.base.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 08.07.2016.
 */
public interface EmployeeDao {
    @Transactional
    void save(Employee employee);
    @Transactional
    Employee load (Long id);
    @Transactional
    List<Employee> findAll ();
}
