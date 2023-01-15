package com.sriteja.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sriteja.model.Country;
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
		//country.setCountryCapital("Dhilli");

		// methods calling - Post method
		mockMvc.perform(post(endpointUrl).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(country))).andExpect(status().isOk()).andDo(print())
				.andReturn();
	}


	@Test
	public void testGetCountryDetails() throws Exception {

		String countryName = "India";
		Country countryDetails = new Country();
		countryDetails.setCountryName("India");
		countryDetails.setCountryCaptital("Dhilli");
		countryDetails.setCountryCode("+91");
		countryDetails.setCountryCurrency("Rupees");
		countryDetails.setCountryId(21);
		//Country countryDetails =  iCountryService.getCountryDetails(countryName);//method calling
		//when() or given() is using to get the data from mock objects
		when(iCountryServiceMock.getCountryDetails(countryName)).thenReturn(countryDetails);
		
		String getRequestURL = "/country/api/get-country-details";
		//@GetMapping("/get-country-details")
		//public Country getCountryDetails(@RequestParam String countryName) {
		MockHttpServletResponse getResponse = mockMvc.perform(get(getRequestURL)
				.param("countryName", countryName))
			   .andExpect(status().isOk()) //status code 200
			   .andDo(print())
			   .andReturn()
			   .getResponse();
		String result = getResponse.getContentAsString();
		Country countryResponse = objectMapper.readValue(result, Country.class);
		//assertEquals(expected, actual);
		assertEquals(countryName, countryResponse.getCountryName());
		
	}

}
