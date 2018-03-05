package com.consultitnow.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "categoryPriceId", "equipmentTypeId" }))
public class CategoryPriceEquipementTypes implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryPriceId", referencedColumnName="id")
	private CategoryPrice categoryPrice;
	
	
	@ManyToOne
	@JoinColumn(name="equipmentTypeId", referencedColumnName="id")
	private EquipmentType equipmentType;
	
	public CategoryPriceEquipementTypes() {
		// TODO Auto-generated constructor stub
	}

}
