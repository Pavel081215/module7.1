package com.hibernate.base.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Pavel on 10.07.2016.
 */
@Entity

@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private IngredientName name;
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

    public IngredientName getName() {
        return name;
    }

    public void setName(IngredientName name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (cost != that.cost) return false;
        if (quantity != that.quantity) return false;
        return name == that.name;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", cost=").append(cost);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
