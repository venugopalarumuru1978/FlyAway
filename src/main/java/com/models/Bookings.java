package com.models;
/*
 * CREATE TABLE BOOKINGS(
BK_ID INT PRIMARY KEY auto_increment,
CID INT, 
BK_DATE VARCHAR(20),
BK_SOURCE  VARCHAR(20),
BK_DEST VARCHAR(20),
BK_AIR_Name VARCHAR(30), 
BK_TKT_AMT FLOAT);
 */
public class Bookings {
	private int bkid;
	private int cid;
	private String bkDate;
	private String source, dest,airname;
	private float amt;
	
	public int getBkid() {
		return bkid;
	}
	public void setBkid(int bkid) {
		this.bkid = bkid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBkDate() {
		return bkDate;
	}
	public void setBkDate(String bkDate) {
		this.bkDate = bkDate;
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
