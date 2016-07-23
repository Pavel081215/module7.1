package com.hibernate.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel on 22.07.2016.
 */
@Controller
public class HomeController {

    /*public HomeController() {
    }

    @RequestMapping({"/order"})
    public String visitHome() {
        return "order";
    }

    @RequestMapping({"/admin"})
    public String visitAdmin() {
        return "admin";
    }

    @RequestMapping({"/staff"})
    public String visitStaff() {
        return "staff";
    }

    @RequestMapping({"/ingredients"})
    public String visitIngredients() {
        return "ingredients";
    }

    @RequestMapping({"/dish"})
    public String visitDish() {
        return "dish/dishes";
    }
*/
    @RequestMapping({"/start"})
    public String visitStart() {
        return "start";
    }
}
