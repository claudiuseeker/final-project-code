package ro.fasttrackit.curs23.finalprojectcode.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs23.finalprojectcode.model.Customer;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.service.PizzaService;

import java.util.List;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service){
        this.service=service;
    }


    @GetMapping
    String getTransactionsPage(Model model){
        model.addAttribute("message", "Hello Pizza");
        model.addAttribute("user", new Customer(1, "Ana", 34));
        model.addAttribute("transactions", service.getAll());
        return "pizzas";
    }


}
