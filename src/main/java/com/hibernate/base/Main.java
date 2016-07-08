package com.hibernate.base;

import com.hibernate.base.controller.DishController;
import com.hibernate.base.controller.EmployeeController;
import com.hibernate.base.controller.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();
        employeeController.getAllEmployee().forEach(System.out::println);
        dishController.getAllDashes().forEach(System.out::println);
    }
}
