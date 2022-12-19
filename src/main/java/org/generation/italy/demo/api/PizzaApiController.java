package org.generation.italy.demo.api;


import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/1/pizza")
@CrossOrigin("*")
public class PizzaApiController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/all")
	public List<Pizza> getPizzas() {
		
		return pizzaService.findAll();
	}
	
	@PostMapping("/update/{id}")
	public Pizza updatePizza(
			@PathVariable("id") int id,
			@Valid @RequestBody Pizza pizza
			) {
		
		pizzaService.save(pizza);

		return pizzaService.getPizzaById(id).get();
	}
}
