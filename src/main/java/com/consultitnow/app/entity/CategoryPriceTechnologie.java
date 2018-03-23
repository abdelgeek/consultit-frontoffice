package com.consultitnow.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "categoryPriceId", "equipmentTechnologieId" }))
public class CategoryPriceTechnologie implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="categoryPriceId")
	private CategoryPrice categoryPrice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="equipmentTechnologieId")
	private EquipmentTechnologie equipmentTechnologie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public CategoryPrice getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(CategoryPrice categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	public CategoryPriceTechnologie() {
		// TODO Auto-generated constructor stub
	}

}
