package com.sriteja.bean;

import java.io.Serializable;

public class Country implements Serializable{

	//attributes
	private String countryName;
	private String countryCode;
	private String countryCurrency;
	private String countryCapital;
	
	//setter and gettre methods
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", countryCode=" + countryCode + ", countryCurrency="
				+ countryCurrency + ", countryCapital=" + countryCapital + "]";
	}
	
	
	
}
