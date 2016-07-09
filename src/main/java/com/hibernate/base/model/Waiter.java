package com.hibernate.base.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
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
