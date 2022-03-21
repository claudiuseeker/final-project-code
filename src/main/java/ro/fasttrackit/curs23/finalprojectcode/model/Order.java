package ro.fasttrackit.curs23.finalprojectcode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;

    public Order(){
    }
    public Order( String name, String description) {
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
