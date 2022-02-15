package com.zakem.RecipeCatalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zakem.RecipeCatalog.object.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	Optional<Ingredient> findByName(String name);
	
	List<Ingredient> findByAllergyIsNull();
	List<Ingredient> findByAllergyIsNotNull();
}
