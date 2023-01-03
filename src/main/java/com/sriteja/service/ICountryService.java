package com.sriteja.service;

import com.sriteja.bean.Company;
import com.sriteja.model.Country;


public interface ICountryService {

	
	public void crateCountryData(Country country);//method creation

	public Country getCountryDetails();
	
	public Company getCompanyDetails();

}
