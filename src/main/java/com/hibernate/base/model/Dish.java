package com.hibernate.base.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "dish")
public class Dish {

    public Dish() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_category")
    private DishCategory dishCategory;

    @Column(name = "price")
    private String price;

    @Column(name = "weigth")
    private Float weigth;

    /*@ManyToMany()
    @JoinTable(
            name = "ingredient_to_dish",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;*/

    @ElementCollection
    @CollectionTable(name = "recipes", joinColumns = @JoinColumn(name = "dish_id"))
    @MapKeyJoinColumn(name = "ingredient_id")
    @Column(name = "count")
    private Map<Ingredient, Long> recipes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Float getWeigth() {
        return weigth;
    }

    public void setWeigth(Float weigth) {
        this.weigth = weigth;
    }

    public Map<Ingredient, Long> getRecipes() {
        return recipes;
    }

    public void setRecipes(Map<Ingredient, Long> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (dishCategory != dish.dishCategory) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        if (weigth != null ? !weigth.equals(dish.weigth) : dish.weigth != null) return false;
        return !(recipes != null ? !recipes.equals(dish.recipes) : dish.recipes != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dishCategory != null ? dishCategory.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weigth != null ? weigth.hashCode() : 0);
        result = 31 * result + (recipes != null ? recipes.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dishCategory=").append(dishCategory);
        sb.append(", price='").append(price).append('\'');
        sb.append(", weigth=").append(weigth);
        sb.append(", recipes=").append(recipes);
        sb.append('}');
        return sb.toString();
    }
}
