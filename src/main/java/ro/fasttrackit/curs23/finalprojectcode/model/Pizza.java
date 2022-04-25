package ro.fasttrackit.curs23.finalprojectcode.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private PizzaSize size;
    private int price;

    @ElementCollection
    private List<PizzaToppings> toppings;

    @ManyToOne
    private PizzaOrder order;

    public Pizza(){
    }

    public Pizza(PizzaOrder order, String name, PizzaSize size, int price, List<PizzaToppings> toppings){
        this.order=order;
        this.name=name;
        this.size=size;
        this.price=price;
        this.toppings=toppings;
    }

    public PizzaOrder getOrder() {
        return order;
    }

    public void setOrder(PizzaOrder order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public List<PizzaToppings> getToppings() {
        return toppings;
    }

    public String printToppings(){
        return String.join(",", toppings.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }

}
