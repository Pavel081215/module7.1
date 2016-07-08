package com.hibernate.base.controller;

import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Position;
import com.hibernate.base.dao.hibernate.HEmployeeDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pavel on 08.07.2016.
 */


public class EmployeeController {


private HEmployeeDao hEmployeeDao;

    public void sethEmployeeDao(HEmployeeDao hEmployeeDao) {
        this.hEmployeeDao = hEmployeeDao;
    }

    @Transactional
    public void createEmployee(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Pavel");
        employee.setPhoneNumber("102");
        employee.setPosition(Position.senior_waiter);
        employee.setSurname("Zag");
        employee.setSalary(20000.0F);

        hEmployeeDao.save(employee);

    }



}
