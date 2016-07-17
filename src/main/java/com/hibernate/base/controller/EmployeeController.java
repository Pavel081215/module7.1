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


    private EmployeeDao hEmployeeDao;

    public void sethEmployeeDao(HEmployeeDao hEmployeeDao) {
        this.hEmployeeDao = hEmployeeDao;
    }

    @Transactional
    public void createEmployee() {
        Set<Employee> employeeSet = new HashSet<>(hEmployeeDao.findAll());
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Pavel");
        employee.setPhoneNumber("102333");
        employee.setPosition(Position.senior_waiter);
        employee.setSurname("Zag");
        employee.setSalary(20000.0F);
        if (!employeeSet.contains(employee)) {
            hEmployeeDao.save(employee);
        }

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Natasha");
        employee1.setPhoneNumber("3331023");
        employee1.setPosition(Position.cleaner);
        employee1.setSurname("Zagreb");
        employee1.setSalary(50000.0F);
        if (!employeeSet.contains(employee1)) {
            hEmployeeDao.save(employee1);

        }
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return hEmployeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByNama(String name) {
        return hEmployeeDao.findByName(name);
    }

    @Transactional
    public void removeAll(){
        hEmployeeDao.removeAll();
    }

    @Transactional
    public void printWaiter(){
        getAllEmployee().forEach(System.out::println);
    }


}
