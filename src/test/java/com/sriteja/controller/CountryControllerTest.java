package com.sriteja.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sriteja.bean.Country;
import com.sriteja.service.ICountryService;


@WebMvcTest(CountryController.class)
public class CountryControllerTest {

	@MockBean
	private ICountryService iCountryServiceMock;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateCountryData() throws Exception {
		System.out.println("========");

		// endpoint url
		String endpointUrl = "/country/api/create-country";

		/**
		 * request body below is the Java Object, this Object we need to convert into
		 * JSON object to Convert Java Object into JSON object we need to use Object
		 * Mappers This Object Mapper class having some method to convert JSON to Java
		 * Object and Java Object to JSON Object. 1. Java Object to JSON Object -
		 * writeValueAsString(javaObjectName) 2. JSON to Java Object -
		 * readValue(jsonobjectName, javaobjectName)
		 * 
		 **/
		Country country = new Country();
		country.setCountryName("India");
		country.setCountryCode("+91");
		country.setCountryCurrency("Rupees");
		country.setCountryCapital("Dhilli");

		// methods calling - Post method
		mockMvc.perform(post(endpointUrl).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(country))).andExpect(status().isOk()).andDo(print())
				.andReturn();
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCountryDetails() throws Exception {

		// response object
		Country country = new Country();
		country.setCountryName("US");
		country.setCountryCapital("Donbos");
		country.setCountryCode("+1");
		country.setCountryCurrency("$");

		String getEndPointURL = "/country/api/get-country-details";
		
		//Country countryDetails =  iCountryService.getCountryDetails();
		when(iCountryServiceMock.getCountryDetails()).thenReturn(country);
	
		
		// method calling - get method
		MockHttpServletResponse getResponse = mockMvc
				.perform(get(getEndPointURL).accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andReturn()
				.getResponse();
		
		String response = getResponse.getContentAsString();
		Country countryDetails = objectMapper.readValue(response, Country.class);
		System.out.println("Country Details======"+countryDetails);
		Assert.assertEquals(country.getCountryName(), countryDetails.getCountryName());	//assertEquals(objExpected, objActual);  
	}

}
