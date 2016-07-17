package com.hibernate.base.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Pavel on 17.07.2016.
 */
@Entity
public class Cook extends Employee {


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<DishInKitchen> orderNames;

    public List<DishInKitchen> getOrderNames() {
        return orderNames;
    }

    public void setOrderNames(List<DishInKitchen> orderNames) {
        this.orderNames = orderNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cook cook = (Cook) o;

        return !(orderNames != null ? !orderNames.equals(cook.orderNames) : cook.orderNames != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderNames != null ? orderNames.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cook{");
        sb.append("orderNames=").append(orderNames);
        sb.append('}');
        return sb.toString();
    }
}
