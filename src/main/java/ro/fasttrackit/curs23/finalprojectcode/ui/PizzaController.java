package ro.fasttrackit.curs23.finalprojectcode.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs23.finalprojectcode.model.Customer;
import ro.fasttrackit.curs23.finalprojectcode.service.PizzaService;

@Controller
@RequestMapping("pizzas")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service){
        this.service=service;
    }

    @GetMapping
    String getPizzaPage(Model model, @RequestParam(required = false) Integer showPizza ) {

        model.addAttribute("pizzas", service.getAll());
        if(showPizza!=null){
            model.addAttribute("pizzaDetails", service.getPizzas(showPizza)
                    .orElse(null));
        }
        return "pizzas";
    }

}
