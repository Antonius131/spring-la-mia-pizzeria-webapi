package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll() {
		
		return pizzaRepo.findAll();
	}
	
	public void save(Pizza pizza) {
		
		pizzaRepo.save(pizza);
	}
	
	public Optional<Pizza> getPizzaById(int id) {
		return pizzaRepo.findById(id);
	}
}
