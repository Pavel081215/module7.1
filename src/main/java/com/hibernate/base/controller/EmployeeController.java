package com.hibernate.base.controller;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.dao.hibernate.HOrderNameDao;
import com.hibernate.base.model.Cook;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Position;
import com.hibernate.base.dao.hibernate.HEmployeeDao;
import com.hibernate.base.model.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */


public class EmployeeController {

    private HOrderNameDao hOrderDao;

    public void sethOrderDao(HOrderNameDao hOrderDao) {
        this.hOrderDao = hOrderDao;
    }

    private EmployeeDao hEmployeeDao;

    public void sethEmployeeDao(EmployeeDao hEmployeeDao) {
        this.hEmployeeDao = hEmployeeDao;
    }

    @Transactional
    public void createEmployee() {
        Set<Employee> employeeSet = new HashSet<>(hEmployeeDao.findAll());
        Employee employee = new Waiter();
        employee.setName("Pavel");
        employee.setPhoneNumber("102333");
        employee.setPosition(Position.senior_waiter);
        employee.setSurname("Zag");
        employee.setSalary(20000.0F);

        if (!employeeSet.contains(employee)) {
            hEmployeeDao.save(employee);
        }

        Employee employee1 = new Employee();
        employee1.setName("Natasha");
        employee1.setPhoneNumber("3331023");
        employee1.setPosition(Position.cleaner);
        employee1.setSurname("Zagreb");
        employee1.setSalary(50000.0F);
        if (!employeeSet.contains(employee1)) {
            hEmployeeDao.save(employee1);

        }

        Employee employee3 = new Cook();
        employee3.setName("Ivan");
        employee3.setPhoneNumber("388585023");
        employee3.setPosition(Position.cook);
        employee3.setSurname("Popov");
        employee3.setSalary(70000.0F);
        if (!employeeSet.contains(employee3)) {
            hEmployeeDao.save(employee3);

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
    public void removeAll() {
        hEmployeeDao.removeAll();
    }

    @Transactional
    public void printWaiter() {
        getAllEmployee().forEach(System.out::println);
    }


}
