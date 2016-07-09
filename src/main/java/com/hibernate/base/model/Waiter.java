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
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter {\n");
        sb.append("    id = ").append(getId()).append("\n");
        sb.append("    name = ").append(getName()).append("\n");
        sb.append("    surname = ").append(getSurname()).append("\n");
        sb.append("    order {\n");
        orderNames.forEach(orderName -> sb.append("          ").append(orderName).append("\n"));
        sb.append("     {\n");
        sb.append("{\n");
        return sb.toString();
    }
}
