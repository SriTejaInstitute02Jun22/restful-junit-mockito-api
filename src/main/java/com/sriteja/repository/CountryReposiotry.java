package com.sriteja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sriteja.model.Country;

@Repository
public interface CountryReposiotry extends JpaRepository<Country, Integer>{

	//select * from country_details cd where cd.name='US';
	@Query(value = "select * from country_details cd where cd.name=:name",nativeQuery = true)
	public Country findByCountryName(@Param("name") String countryName);

}
