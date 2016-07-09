package com.hibernate.base;

import com.hibernate.base.controller.DishController;
import com.hibernate.base.controller.EmployeeController;
import com.hibernate.base.controller.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    private boolean removeInit;

    private boolean saveInit;

    public void setRemoveInit(boolean removeInit) {
        this.removeInit = removeInit;
    }

    public void setSaveInit(boolean saveInit) {
        this.saveInit = saveInit;
    }

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
        if (removeInit) {
            orderController.remove();
            employeeController.removeAll();
            dishController.removeAll();
        }
        if (saveInit) {
            employeeController.createEmployee();
            dishController.createDish();
            List<String> dishes2 = new ArrayList<>();
            dishes2.add("Soup");
            dishes2.add("Compot");
            orderController.createOrder("Natasha", dishes2);
            List<String> dishes = new ArrayList<>();
            dishes.add("Plov");
            dishes.add("Compot");
            orderController.createOrder("Pavel", dishes);
            orderController.print();
        }


    }
}
