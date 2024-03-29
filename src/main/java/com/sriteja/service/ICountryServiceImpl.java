package com.sriteja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sriteja.bean.Company;
import com.sriteja.model.Country;
import com.sriteja.repository.CountryReposiotry;

@Service
public class ICountryServiceImpl implements ICountryService{

	private static final Logger logger = LoggerFactory.getLogger(ICountryServiceImpl.class);
	
	/**
	 * creating the DI(dependency injection) to DAO layer interface
	 * CountryReposiotry countryReposiotry = new CountryReposiotry();
	 * */
	@Autowired
	private CountryReposiotry countryReposiotry;
	
	@Override
	public void crateCountryData(Country country) {
		logger.info("Country Details in Service :: "+country);
		countryReposiotry.save(country);
		
	}

	@Override
	public Country getCountryDetails(String countryName) {
		
		Country country = countryReposiotry.findByCountryName(countryName);
		
		return country;
	}

	@Override
	public Company getCompanyDetails() {
		
		//create the Company Object
		Company company = new Company();
		company.setCompanyName("IBM");
		company.setCompanyEmail("ramesh@ibm.com");
		company.setCompanyMobile("+91232323");
		company.setCompanyLocation("Hyderabad");
		
		return company;
	}

}
