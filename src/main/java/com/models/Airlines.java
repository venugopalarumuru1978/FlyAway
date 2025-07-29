package com.models;

/*
 * CREATE TABLE `f_airlines` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

 */
public class Airlines {

	private int AidId;
	private String AirName;
	
	public int getAidId() {
		return AidId;
	}
	public void setAidId(int aidId) {
		AidId = aidId;
	}
	public String getAirName() {
		return AirName;
	}
	public void setAirName(String airName) {
		AirName = airName;
	}
	
	
}
