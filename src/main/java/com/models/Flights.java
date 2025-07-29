package com.models;
/*
 * CREATE TABLE FLIGHTS(
SNO INT PRIMARY KEY auto_increment, 
F_ID  VARCHAR(10),
F_NAME VARCHAR(20),
AIRLINE_CODE INT, 
SOURCE VARCHAR(20), 
DESTINATION VARCHAR(20), 
TKT_PRICE FLOAT, 
SEATS INT
);
 */
public class Flights {

	private int sno;
	private String fid;
	private String fname;
	private int aircode;
	private String source;
	private String destination;
	private float tktprice;
	private int seats;

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAircode() {
		return aircode;
	}
	public void setAircode(int aircode) {
		this.aircode = aircode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getTktprice() {
		return tktprice;
	}
	public void setTktprice(float tktprice) {
		this.tktprice = tktprice;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
