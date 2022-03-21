package ro.fasttrackit.curs23.finalprojectcode.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private PizzaSize size;

    @ElementCollection
    private List<PizzaToppings> extraToppings;

    @ManyToOne
    private Order order;

    public Pizza(){
    }

    public Pizza(Order order, String name, PizzaSize size, List<PizzaToppings> extraToppings){
        this.order=order;
        this.name=name;
        this.size=size;
        this.extraToppings=extraToppings;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<PizzaToppings> getExtraToppings() {
        return extraToppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", extraToppings=" + extraToppings +
                ", order=" + order +
                '}';
    }
}
