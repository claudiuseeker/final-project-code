package ro.fasttrackit.curs23.finalprojectcode.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.service.PizzaService;

@RestController
@RequestMapping("api/pizzas")
public class PizzaApiController {

    private final PizzaService service;


    public PizzaApiController(PizzaService service) {
        this.service = service;
    }

    @PostMapping
    Pizza addTransaction(@RequestBody Pizza pizza) {
        return service.add(pizza);
    }

    @PutMapping("{id}")
    Pizza replacePizza(@PathVariable int id, @RequestBody Pizza pizza) {
        return service.replace(id, pizza);
    }
    @DeleteMapping("{id}")
    Pizza deletePizza(@PathVariable int id) {
        return service.delete(id)
                .orElse(null);
    }
}
