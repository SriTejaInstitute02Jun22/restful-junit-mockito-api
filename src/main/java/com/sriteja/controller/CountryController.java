package com.sriteja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	@PostMapping("/create-country")
	public void createCountryData(@RequestBody Country country) {
		logger.info("Country Details in Controller :: "+country);
		iCountryService.crateCountryData(country); //method calling
		
	}

	
}
