package com.zakem.RecipeCatalog.controller;

import java.util.Optional;

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
	
	RecipeRepository recipeRepository;
	
	public RecipeController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
		Optional<Recipe> recipeOptional = this.recipeRepository.findByName(recipe.getName());
		if (recipeOptional.isPresent()) {
			return ResponseEntity.badRequest().body(null);
		}
		
		if (recipe.getId().equals(null)) {
			return ResponseEntity.badRequest().body(null);
		}
		
		Recipe newRecipe = this.recipeRepository.save(recipe);
		return ResponseEntity.ok(newRecipe);		
		
	}

}
