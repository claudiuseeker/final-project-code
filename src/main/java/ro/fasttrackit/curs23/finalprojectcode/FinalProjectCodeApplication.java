package ro.fasttrackit.curs23.finalprojectcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaOrder;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaSize;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaToppings;
import ro.fasttrackit.curs23.finalprojectcode.repository.PizzaOrderRepository;
import ro.fasttrackit.curs23.finalprojectcode.repository.PizzaRepository;

import java.util.List;

@SpringBootApplication
public class FinalProjectCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectCodeApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(PizzaRepository repository, PizzaOrderRepository orderRepository){
		return args->{

			orderRepository.save(new PizzaOrder("claudiu", "cu de toate"));
			orderRepository.save(new PizzaOrder("bogdan", "fara branza"));

			List<PizzaOrder> listOfOrders = orderRepository.findAll();
			repository.saveAll(List.of(
					new Pizza(listOfOrders.get(0),"Margherita", PizzaSize.GRANDE, 35,List.of(PizzaToppings.SALAMI,PizzaToppings.PEPPER)),
					new Pizza(listOfOrders.get(1),"Capriciosa", PizzaSize.MEDIUM,39, List.of(PizzaToppings.PEPPER,PizzaToppings.GORGONZOLA)),
					new Pizza(listOfOrders.get(0),"Prosciutto e funghi", PizzaSize.SMALL,45, List.of(PizzaToppings.PARMEZAN, PizzaToppings.SPINACH)),
					new Pizza(listOfOrders.get(0),"Quattro stagionni", PizzaSize.GRANDE,31, List.of(PizzaToppings.SPINACH, PizzaToppings.GORGONZOLA))
			));
		};
	}
}
