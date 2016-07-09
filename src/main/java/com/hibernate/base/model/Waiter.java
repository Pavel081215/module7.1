package com.hibernate.base.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {



    @OneToMany()
    @JoinColumn(name = "employee_id")

    private List<OrderName> orderNames;

    public List<OrderName> getOrderNames() {
        return orderNames;
    }

    public void setOrderNames(List<OrderName> orderNames) {
        this.orderNames = orderNames;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Waiter{");
        sb.append('}');
        return sb.toString();
    }
}
