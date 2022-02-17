package com.zakem.RecipeCatalog.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="INGREDIENT")
public class Ingredient {

	@Id
	@Column(name="NAME")
	String name;
	
	@Column(name="MILCHIG_FLEISHIG_STATUS")
	String milchigFleishigStatus;
	
	@Column(name="ALLERGY")
	String allergy;
}
