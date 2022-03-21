package ro.fasttrackit.curs23.finalprojectcode.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository repository;

    public PizzaService(PizzaRepository repository){
        this.repository=repository;
    }

    public List<Pizza> getPizzas(){
        return repository.findAll();
    }
}

