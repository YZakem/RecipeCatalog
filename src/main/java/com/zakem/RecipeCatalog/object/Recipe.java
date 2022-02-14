package com.zakem.RecipeCatalog.object;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="RECIPE")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="COOK_TIME")
	Integer cookTime;
	
	@Column(name="INGREDIENTS")
	List<String> ingredients;
	
	@Column(name="MILCHIG_FLEISHIG_STATUS")
	String milchigFleishigStatus;
	
	@Column(name="COURSE")
	String course;
	
}