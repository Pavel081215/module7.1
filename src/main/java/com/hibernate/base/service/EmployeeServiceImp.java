package com.hibernate.base.service;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Stock;
import com.hibernate.base.service.serviceInterface.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 22.07.2016.
 */
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeInterface {

    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    @Override
    public void save(Employee employee) {

    }

    @Transactional
    @Override
    public Stock load(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Transactional
    @Override
    public void remove(Employee employee) {

    }

    @Transactional
    @Override
    public void removeAll() {

    }

    @Override
    public Employee findByName(String name) {
        return null;
    }
}
