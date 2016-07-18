package com.hibernate.base.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock")

public class Stock {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "name")
    private Ingredient nameIngredient;
    @Column(name = "cost")
    private long cost;
    @Column(name = "quantity")
    private long quantity;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ingredient getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(Ingredient nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stock{");
        sb.append("id=").append(id);
        sb.append(", nameIngredient=").append(nameIngredient);
        sb.append(", cost=").append(cost);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return !(nameIngredient != null ? !nameIngredient.equals(stock.nameIngredient) : stock.nameIngredient != null);

    }

    @Override
    public int hashCode() {
        return nameIngredient != null ? nameIngredient.hashCode() : 0;
    }
}



