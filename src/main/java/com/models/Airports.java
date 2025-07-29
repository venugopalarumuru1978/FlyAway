package com.models;
/*
 * CREATE TABLE AIRPORTS(
AP_CODE VARCHAR(10) PRIMARY KEY, 
AP_NAME VARCHAR(50), 
CITY  VARCHAR(20),
COUNTRY VARCHAR(20)
);
 */
public class Airports {

	private String ap_code;
	private String ap_name;
	private String city;
	private String country;
	public String getAp_code() {
		return ap_code;
	}
	public void setAp_code(String ap_code) {
		this.ap_code = ap_code;
	}
	public String getAp_name() {
		return ap_name;
	}
	public void setAp_name(String ap_name) {
		this.ap_name = ap_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
