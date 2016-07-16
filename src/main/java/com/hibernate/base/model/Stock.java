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

    @ManyToMany()
    @JoinTable(
            name = "ingredient_to_stock",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stock{");
        sb.append("id=").append(id);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}



