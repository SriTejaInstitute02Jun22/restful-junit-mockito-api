package com.sriteja.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sriteja.model.Country;
import com.sriteja.repository.CountryReposiotry;

@ExtendWith(MockitoExtension.class)
public class ICountryServiceImplTest {

	
	@Mock
	private CountryReposiotry countryReposiotryMock;
	
	@InjectMocks
	private ICountryServiceImpl iCountryServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetCountryDetails() throws Exception{
		
		String countryName = "India";
		Country country = new Country();
		country.setCountryName("India");
		country.setCountryCode("+91");
		country.setCountryCurrency("Rupees");
		//Country country = countryReposiotry.findByCountryName(countryName);
		when(countryReposiotryMock.findByCountryName(countryName)).thenReturn(country);
		
		Country response = iCountryServiceImpl.getCountryDetails(countryName);
		//assertEquals(expected, actual);
		assertEquals(countryName, response.getCountryName());
		
	}
	
	//@Ignore
	/*@Disabled("Do not run in a lower environment")
	@Test
	public void testCrateCountryData() throws Exception{
		
		Country country = new Country();
		country.setCountryName("India");
		country.setCountryCode("+91");
		country.setCountryCurrency("Rupees");
		country.setCountryCaptital("Dhili");
		country.setCountryId(241);
		//countryReposiotry.save(country);
		/**
		 * test cases for which is return type void 
		 * we need to use below method to write the void return type
		 * doNothing() - this is used when we don't want any return 
		 * doThrow()   - this is used if you want throw any exception 
		 * doAnswer()  - this is used when we don't want any return 
		 * 
		 * */
	//	when(countryReposiotryMock.save(country)).thenReturn(country);
		//verify(countryReposiotryMock, times(1)).save(country);
		//verify(countryReposiotryMock).save(country);
		//iCountryServiceImpl.crateCountryData(country);
		//verify(this.iCountryServiceImpl).save(country);
		//assertEquals(iCountryServiceImpl.crateCountryData(country));
	//}


}
