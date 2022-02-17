package com.zakem.RecipeCatalog.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zakem.RecipeCatalog.object.Ingredient;
import com.zakem.RecipeCatalog.repository.IngredientRepository;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@PostMapping("/add")
	public ResponseEntity<?> addIngredient(@RequestBody Ingredient ingredient){
		Optional<Ingredient> ingredientOptional = this.ingredientRepository.findByName(ingredient.getName());
		if (ingredientOptional.isPresent()) {
			logger.info("Adding ingredient {} failed because already exists", ingredient.getName());
			return ResponseEntity.badRequest().body(null);
		}
		
		Ingredient newIngredient = this.ingredientRepository.save(ingredient);
		logger.info("Added new ingredient {}", newIngredient.getName());
		return ResponseEntity.ok(newIngredient);
	}

}
