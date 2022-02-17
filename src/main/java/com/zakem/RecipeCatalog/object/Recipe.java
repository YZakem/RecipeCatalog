package com.zakem.RecipeCatalog.object;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="RECIPE")
public class Recipe {
	
	@Id
	@Column(name="NAME")
	String name;
	
	@Column(name="COOK_TIME")
	Integer cookTime;
	
	@Column(name="INGREDIENTS")
	@ElementCollection
	List<Ingredient> ingredients;
	
	@Column(name="MILCHIG_FLEISHIG_STATUS")
	String milchigFleishigStatus;
	
	@Column(name="COURSE")
	String course;
	
	@Column(name="ALLERGY_STATUS")
	@ElementCollection
	List<String> allergyStatus;
	
}