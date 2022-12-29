package com.sriteja.bean;

public class Company {

	private String companyName;
	private String companyEmail;
	private String companyMobile;
	private String companyLocation;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyMobile() {
		return companyMobile;
	}
	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}
	public String getCompanyLocation() {
		return companyLocation;
	}
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyEmail=" + companyEmail + ", companyMobile="
				+ companyMobile + ", companyLocation=" + companyLocation + "]";
	}
	
	
}
