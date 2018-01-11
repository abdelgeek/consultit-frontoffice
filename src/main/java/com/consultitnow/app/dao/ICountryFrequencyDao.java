package com.consultitnow.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultitnow.app.entity.CountryFrequencyBand;

public interface ICountryFrequencyDao extends JpaRepository<CountryFrequencyBand, Long> {

}
