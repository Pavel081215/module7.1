package com.hibernate.base;

import com.hibernate.base.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private StockController stonecontroller;
    private IngredientController ingredientcontroller;
    private MenuController menucontroller;

    public void setMenucontroller(MenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    public void setStonecontroller(StockController stonecontroller) {
        this.stonecontroller = stonecontroller;
    }

    public void setIngredientcontroller(IngredientController ingredientcontroller) {
        this.ingredientcontroller = ingredientcontroller;
    }

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
            stonecontroller.remove();
            dishController.removeAll();

            ingredientcontroller.removeAll();


        }
        if (saveInit) {
            ingredientcontroller.createIngredient();


            employeeController.createEmployee();

            dishController.createDish();

            List<String> dishes2 = new ArrayList<>();
            dishes2.add("Soup");
            dishes2.add("Compot");
            orderController.createOrder("Natasha", dishes2);
            List<String> dishes = new ArrayList<>();
            dishes.add("Plov");
            dishes.add("Compot");
            orderController.createOrder("Natasha", dishes);
            orderController.print();
            employeeController.printWaiter();
            List<String> ingredients = new ArrayList<>();
            ingredients.add("cabbage");
            ingredients.add("tomatoes");
            stonecontroller.createStoke(ingredients);

            menucontroller.createMenu();

        }



    }
}
