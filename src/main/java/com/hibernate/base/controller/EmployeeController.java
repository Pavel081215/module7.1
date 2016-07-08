package com.hibernate.base.controller;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Position;
import com.hibernate.base.dao.hibernate.HEmployeeDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */


public class EmployeeController {


    private EmployeeDao employeeDao;

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void createEmployee() {
        Set<Employee> employeeSet = new HashSet<>(employeeDao.findAll());
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Pavel");
        employee.setPhoneNumber("102333");
        employee.setPosition(Position.senior_waiter);
        employee.setSurname("Zag");
        employee.setSalary(20000.0F);
        if (!employeeSet.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }


}
