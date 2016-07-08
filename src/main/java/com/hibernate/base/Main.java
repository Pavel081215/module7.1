package com.hibernate.base;

import com.hibernate.base.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private EmployeeController employeeController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();
    }
}
