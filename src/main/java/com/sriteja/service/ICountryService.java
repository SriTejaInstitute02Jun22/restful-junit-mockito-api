package com.sriteja.service;

import com.sriteja.bean.Company;
import com.sriteja.bean.Country;

public interface ICountryService {

	
	public void crateCountryData(Country country);//method creation

	public Country getCountryDetails();
	
	public Company getCompanyDetails();

}
