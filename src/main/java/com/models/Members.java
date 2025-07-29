package com.models;
/*
 * CREATE TABLE CUSTOMER(CUS_ID INT PRIMARY KEY auto_increment, 
CUS_NAME VARCHAR(30), 
PHONE VARCHAR(15), 
EMAIL VARCHAR(100), 
PSWD  VARCHAR(20),
LOCATION VARCHAR(20));
 */
public class Members {

	private int cusid;
	private String cusname;
	private String phone, email, location, pswd;
	
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
