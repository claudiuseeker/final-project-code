package ro.fasttrackit.curs23.finalprojectcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs23.finalprojectcode.model.Pizza;

public interface PizzaRepository extends JpaRepository <Pizza, Integer> {
}
