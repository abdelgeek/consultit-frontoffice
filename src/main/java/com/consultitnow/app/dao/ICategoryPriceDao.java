package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.CategoryPrice;
import com.consultitnow.app.entity.EquipmentTechnologie;
import com.consultitnow.app.entity.EquipmentType;

public interface ICategoryPriceDao extends JpaRepository<CategoryPrice,Long >{

	
	public CategoryPrice findByAgencyAndPriceEquipementTypesEquipmentType(Agency agency, EquipmentType equipmentType);

	
	public CategoryPrice findByAgencyAndPriceEquipementTechEquipmentTechnologie(Agency agency, EquipmentTechnologie eqTechnologie);
	
	public CategoryPrice findByAgencyAndConcernEncryptionFeature(Agency agency, Boolean hasEncryptionFeature );
	
	public CategoryPrice findByAgency(Agency agency);

}
