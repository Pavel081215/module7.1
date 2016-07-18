package com.hibernate.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Pavel on 18.07.2016.
 */
@Entity
@Table(name = "recipes")
public class Recipes {
    @Id
    @Column(name = "dish_id")
    private long dish_id;
    @Column(name = "ingredient_id")
    private long ingredient_id;
    @Column(name = "count")
    private long count;

}
