package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
import java.util.stream.Collectors; 


@RestController
class CoolCarController {
	private CarRepository repository;
	
	public CoolCarController(CarRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/cool-cars")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> coolCars() {
		return repository.findAll().stream()
				.filter(this::isCool)
				.collect(Collectors.toList());
	}
	
	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") &&
				!car.getName().equals("Triumph Stage") &&
				!car.getName().equals("FordPinto") &&
				!car.getName().equals("Yugo GV"); 
	}
}