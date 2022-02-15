package com.zakem.RecipeCatalog.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zakem.RecipeCatalog.object.Recipe;
import com.zakem.RecipeCatalog.repository.RecipeRepository;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	RecipeRepository recipeRepository;
	
	public RecipeController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
		Optional<Recipe> recipeOptional = this.recipeRepository.findByName(recipe.getName());
		if (recipeOptional.isPresent()) {
			logger.info("A recipe called {} already exists", recipe.getName());
			return ResponseEntity.badRequest().body(null);
		}
		
		Recipe newRecipe = this.recipeRepository.save(recipe);
		logger.info("Added new recipe {}", recipe.getName());
		return ResponseEntity.ok(newRecipe);		
		
	}

}
