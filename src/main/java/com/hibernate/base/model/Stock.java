package com.hibernate.base.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    public Stock() {

    }

    public Stock(Ingredient ingredient) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

   /* @ManyToMany()
    @JoinTable(
            name = "ingredient_to_stock",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;*/

    @Column(name = "name")
    private String name;

 /*   @Column(name = "cost")
    private long cost;
    @Column(name = "quantity")
    private long quantity;*/


}



