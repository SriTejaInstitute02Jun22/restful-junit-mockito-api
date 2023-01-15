package com.sriteja.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sriteja.model.Country;

/**
 * This call is writing JUnit test cases for DAO layer 
 * we need to use @DataJpaTest Annotation to write the JUnit test cases for Repository Layer
 * Or @Transactional − To mark repository to do CRUD Operation capable.
 * Spring Boot provides the @DataJpaTest annotation to test the persistence layer components that will autoconfigure in-memory embedded databases 
 * and scan for @Entity classes and Spring Data JPA repositories. 
   The @DataJpaTest annotation doesn’t load other Spring beans (@Components, @Controller, @Service, and annotated beans) into ApplicationContext.
   Head over to the test package. Let's create a repository package inside a base package "test.net.javaguides.springboot". 
 * **/
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class CountryReposiotryTest {

	@Autowired
	private CountryReposiotry countryReposiotryMock;
	
	@Test
	public void testFindByCountryName() throws Exception{
		System.out.println("===test====");
		
		Country country = new Country();
		country.setCountryId(23);
		country.setCountryName("US");
		country.setCountryCaptital("DK City");
		country.setCountryCode("+1");
		country.setCountryCurrency("Doller");
		
		String countryName = "US";
		Country response = countryReposiotryMock.findByCountryName(countryName);
		System.out.println("Country Response Object form DB ======"+response);
		//assertEquals(expected, actual);
		assertEquals(country.getCountryName(), response.getCountryName());
	}

}
