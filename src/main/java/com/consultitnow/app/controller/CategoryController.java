package com.consultitnow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultitnow.app.dao.ICategoryDao;
import com.consultitnow.app.dao.ICountryDao;
import com.consultitnow.app.entity.Agency;
import com.consultitnow.app.entity.Category;
import com.consultitnow.app.entity.Country;
import com.consultitnow.model.CategoryModel;
import com.consultitnow.model.CategoryResult;

@RestController
public class CategoryController {

	@Autowired
	private ICategoryDao categorieDao;
	@Autowired
	private ICountryDao countryDao;

	@RequestMapping(value = "/findCategories")
	public List<Category> findAll() {
		return categorieDao.findAll();
	}

	// save a new category
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public CategoryResult save(CategoryModel categoryModel) {

		System.out.println(categoryModel.toString());

		// 1-cree un objet CategoryResult qui va retourner les données a la vue

		CategoryResult result = new CategoryResult();
		result.setIsValid(false);
		result.setCategory(null);

		// 2- recuperer les données de la vue

		Long id = categoryModel.getId();
		String categoryName = categoryModel.getCategoryName();
		Double categoryPrice = categoryModel.getCategoryPrice();
		String country = categoryModel.getCountry();

		if (country.isEmpty() || categoryName.isEmpty() || categoryPrice == null) {
			result.setMessage("Erreur: Renseignez tous les champs");
			System.out.println("Erreur:  renseigner tous les champs");
		} else {

			// 4- sinon verifie si la category existe

			// 4- sinon verifie si le pays existe

			if (id != null) {
				if (categorieDao.findById(id) != null) {

					Country c = countryDao.findByCountryName(country);

					Category category = new Category(id, categoryName, categoryPrice, c);

					categorieDao.save(category);
					result.setIsValid(true);
					result.setCategory(category);

					result.setMessage("Succes: Category modifiée avec succes");

					System.out.println("Succes: Category modifiée avec succes");

				} else {
					result.setMessage("Erreur: Cette categorie n'existe pas");
					result.setIsValid(false);
					System.out.println("Erreur:   Cette categorie n'existe pas");
				}
			} else {

				if (categorieDao.findByCategoryName(categoryName) == null) {

					Country c = countryDao.findByCountryName(country);

					Category category = new Category(id, categoryName, categoryPrice, c);

					System.out.println(category.toString());
					categorieDao.save(category);
					result.setIsValid(true);
					result.setCategory(category);

					result.setMessage("Succes: Agence enregistrée avec succes");

					System.out.println("Succes: Agence enregistrée avec succes");
				} else {
					result.setMessage("Erreur: Cette agence existe déja");
					System.out.println("Erreur:   Cette agence existe déja");
					result.setIsValid(false);
				}
			}

		}

		return result;
	}

}
