package ro.fasttrackit.curs23.finalprojectcode.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepository repository;

    public PizzaService(PizzaRepository repository){
        this.repository=repository;
    }

    public List<Pizza> getAll(){
        return repository.findAll();
    }

    public Optional<Pizza> getPizzas(Integer id) {
        return  repository.findById(id);
    }

    public Pizza add(Pizza pizza) {
        return repository.save(pizza);
    }

    public Optional<Pizza> delete(int id) {
        Optional<Pizza> toDelete= repository.findById(id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Pizza replace(int id, Pizza pizza) {
        pizza.setId(id);
        return repository.save(pizza);
    }
}

