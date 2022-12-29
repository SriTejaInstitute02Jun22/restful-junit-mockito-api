package com.sriteja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sriteja.bean.Company;
import com.sriteja.bean.Country;
import com.sriteja.service.ICountryService;

@RestController
@RequestMapping("/country/api")
public class CountryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
			
	//creating the DI(dependency injection) to service layer interface
	//ICountryService iCountryService = new ICountryServiceImpl();
	@Autowired
	private ICountryService iCountryService; 
	
	
	/**
	 * crating the new country object
	 * @param country
	 * 
	 * **/
	@PostMapping("/create-country")
	public void createCountryData(@RequestBody Country country) {
		logger.info("Country Details in Controller :: "+country);
		iCountryService.crateCountryData(country); //method calling
		
	}
	
	/**
	 * get the country details
	 * @return Country
	 * */
	@GetMapping("/get-country-details")
	public Country getCountryDetails() {
		Country countryDetails =  iCountryService.getCountryDetails();//method calling
		
		//new calling controller to service layer 
		//get the Company details
		Company companyDetails = iCountryService.getCompanyDetails();//method calling
		logger.info("Company Details in Controller :: "+companyDetails);
		return countryDetails;
	}

	
	
}
