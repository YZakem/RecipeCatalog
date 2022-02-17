package com.zakem.RecipeCatalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zakem.RecipeCatalog.object.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
	
	List<Recipe> findByCookTimeLessThanEqual(Integer cookTime);
	
	Optional<Recipe> findByName(String name);
	
}