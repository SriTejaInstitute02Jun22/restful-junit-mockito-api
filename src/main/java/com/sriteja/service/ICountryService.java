package com.sriteja.service;

import com.sriteja.bean.Company;
import com.sriteja.model.Country;


public interface ICountryService {

	
	public void crateCountryData(Country country);//method creation

	public Country getCountryDetails(String countryName);//method creation
	
	public Company getCompanyDetails();//method creation

}
