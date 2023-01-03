package com.sriteja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * this call is connecting to db to perform some business login in the database based on Country
 * @Entity	- It can use to connect to db and create the Country table in database. It should required 
 * @Table	- To create the table name with specific name
 * @Column	- To create the column name with specific name
 * @Id		- It can use to create the primary key into db table. we cann't create the table without primary key, it should required
 * @GenerateValue - It can use to auto-generate the primary key values into database.
 * 
 * **/
@Entity
@Table(name = "COUNTRY_DETAILS")
public class Country {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;	//this is auto generate values, this is primary in the database table
	
	@Column(name = "NAME")
	private String countryName;
	
	@Column(name = "CAPTITAL")
	private String countryCaptital;
	
	@Column(name = "CODE")
	private String countryCode;
	
	@Column(name = "CURRENCY")
	private String countryCurrency;
	
	//setter and getter methods
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCaptital() {
		return countryCaptital;
	}
	public void setCountryCaptital(String countryCaptital) {
		this.countryCaptital = countryCaptital;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryCurrency() {
		return countryCurrency;
	}
	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryCaptital="
				+ countryCaptital + ", countryCode=" + countryCode + ", countryCurrency=" + countryCurrency + "]";
	}
	
	
	
}
