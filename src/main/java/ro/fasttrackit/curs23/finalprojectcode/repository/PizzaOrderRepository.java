package ro.fasttrackit.curs23.finalprojectcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs23.finalprojectcode.model.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {
}
