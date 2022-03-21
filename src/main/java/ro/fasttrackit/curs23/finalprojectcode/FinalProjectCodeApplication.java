package ro.fasttrackit.curs23.finalprojectcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs23.finalprojectcode.model.Order;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaSize;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaToppings;
import ro.fasttrackit.curs23.finalprojectcode.repository.OrderRepository;
import ro.fasttrackit.curs23.finalprojectcode.repository.PizzaRepository;

import java.util.List;

@SpringBootApplication
public class FinalProjectCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectCodeApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(PizzaRepository repository, OrderRepository orderRepository){
		return args->{

			Order claudiu = orderRepository.save(new Order("claudiu", "cu de toate"));
			Order secondOrder = orderRepository.save(new Order("Csadad", "sdffas"));

			repository.saveAll(List.of(
					new Pizza(claudiu,"Margherita", PizzaSize.GRANDE, List.of(PizzaToppings.SALAMI,PizzaToppings.PEPPER)),
					new Pizza(secondOrder,"Capriciosa", PizzaSize.MEDIUM, List.of(PizzaToppings.PEPPER,PizzaToppings.GORGONZOLA)),
					new  Pizza(claudiu,"Prosciutto e funghi", PizzaSize.SMALL, List.of(PizzaToppings.PARMEZAN, PizzaToppings.SPINACH)),
					new Pizza(claudiu,"Quattro stagionni", PizzaSize.GRANDE, List.of(PizzaToppings.SPINACH, PizzaToppings.GORGONZOLA))
			));
		};
	}
}
