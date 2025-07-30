package com.models;
/*
 * SELECT C.CUS_NAME, C.PHONE, C.EMAIL,  B.BK_DATE, B.BK_SOURCE, B.BK_DEST, B.BK_AIR_Name, B.BK_TKT_AMT 
FROM  CUSTOMER AS C INNER JOIN BOOKINGS AS B
ON B.CID = C.CUS_ID WHERE B.CID = 1;
 */
public class BookingHistory {

	private String cname, phone, email, bdate, source, dest, airname;
	private float amt;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getAirname() {
		return airname;
	}
	public void setAirname(String airname) {
		this.airname = airname;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	
	
	
}
