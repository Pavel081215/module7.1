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
    private StockController stoneController;
    private IngredientController ingredientController;
    private MenuController menuController;
    private DishInKitchenController dishInKitchenController;

    public void setDishInKitchenController(DishInKitchenController dishInKitchenController) {
        this.dishInKitchenController = dishInKitchenController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setStoneController(StockController stoneController) {
        this.stoneController = stoneController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
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


    public void setRemoveInit(boolean removeInit) {
        this.removeInit = removeInit;
    }

    public void setSaveInit(boolean saveInit) {
        this.saveInit = saveInit;
    }

    private boolean removeInit;

    private boolean saveInit;


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        if (removeInit) {
            orderController.remove();
            employeeController.removeAll();
            stoneController.remove();
            menuController.removeAll();
            dishController.removeAll();
            ingredientController.removeAll();

        }
        if (saveInit) {

            ingredientController.createIngredient();
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
            menuController.createMenu();
            ingredientController.createIngredient();
            stoneController.createStoke();
        }

        dishInKitchenController.createDishInKitchen();


    }

}
