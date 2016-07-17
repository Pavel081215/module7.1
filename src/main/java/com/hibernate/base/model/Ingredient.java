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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return name == that.name;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append('}');
        return sb.toString();
    }
}
