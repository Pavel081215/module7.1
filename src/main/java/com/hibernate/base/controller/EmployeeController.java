package com.hibernate.base.controller;

import com.hibernate.base.dao.EmployeeDao;
import com.hibernate.base.dao.hibernate.HOrderNameDao;
import com.hibernate.base.model.Cook;
import com.hibernate.base.model.Employee;
import com.hibernate.base.model.Position;
import com.hibernate.base.dao.hibernate.HEmployeeDao;
import com.hibernate.base.model.Waiter;
import com.hibernate.base.service.EmployeeServiceImp;
import com.hibernate.base.service.serviceInterface.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 08.07.2016.
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    public void setEmployeeServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }
    /*  private EmployeeInterface employeeInterface;

    public void setEmployeeInterface(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }*/


    public void createEmployee() {
     /*   Set<Employee> employeeSet = new HashSet<>(hEmployeeDao.findAll());
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

        }*/

    }

    @RequestMapping({"/listEmployee"})
    public ModelAndView listEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(employeeServiceImp.findAll());
        ModelAndView modelView = new ModelAndView("employee/listEmployee");
        modelView.addObject("listEmployees", employees);
        return modelView;
    }


    public List<Employee> getAllEmployee() {
        return employeeServiceImp.findAll();
    }


    public Employee getEmployeeByNama(String name) {
        return employeeServiceImp.findByName(name);
    }


    public void removeAll() {
        employeeServiceImp.removeAll();
    }


    public void printWaiter() {
        getAllEmployee().forEach(System.out::println);
    }


}
