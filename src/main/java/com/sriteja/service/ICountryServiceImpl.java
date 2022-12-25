package com.sriteja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sriteja.bean.Country;

@Service
public class ICountryServiceImpl implements ICountryService{

	private static final Logger logger = LoggerFactory.getLogger(ICountryServiceImpl.class);
	
	@Override
	public void crateCountryData(Country country) {
		logger.info("Country Details in Service :: "+country);
		
	}

}
