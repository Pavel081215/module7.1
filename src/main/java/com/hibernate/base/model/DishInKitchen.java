package com.hibernate.base.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 17.07.2016.
 */


@Entity
@Table(name = "dishinkitchen")
public class DishInKitchen {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id"  )
    private long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee  cook;


    @ManyToOne
    @JoinColumn(name = "dishes_id")
    private Dish dishes_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getCook() {
        return cook;
    }

    public void setCook(Employee cook) {
        this.cook = cook;
    }

    public Dish getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Dish dishes_id) {
        this.dishes_id = dishes_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishInKitchen that = (DishInKitchen) o;

        if (cook != null ? !cook.equals(that.cook) : that.cook != null) return false;
        return !(dishes_id != null ? !dishes_id.equals(that.dishes_id) : that.dishes_id != null);

    }

    @Override
    public int hashCode() {
        int result = cook != null ? cook.hashCode() : 0;
        result = 31 * result + (dishes_id != null ? dishes_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DishInKitchen{");
        sb.append("id=").append(id);
        sb.append(", cook=").append(cook);
        sb.append(", dishes_id=").append(dishes_id);
        sb.append('}');
        return sb.toString();
    }
}
