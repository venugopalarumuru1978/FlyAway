package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DbConnection;
import com.models.Airports;

public class AirportsDAO {

	private Connection conObj = null;
	private PreparedStatement psObj = null;
	
	public AirportsDAO()
	{
		conObj = DbConnection.getConnection();
	}
	
	public void AddAirports(Airports apObj)
	{
		try {
			psObj = conObj.prepareStatement("Insert into AIRPORTS values(?,?,?,?)");
			psObj.setString(1, apObj.getAp_code());
			psObj.setString(2, apObj.getAp_name());
			psObj.setString(3, apObj.getCity());
			psObj.setString(4, apObj.getCountry());
			psObj.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public List<Airports>  ShowAll()
	{
		List<Airports>  airportList = new ArrayList<Airports>();
		Airports apObj = null;
		try {
			psObj = conObj.prepareStatement("Select * from Airports");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				apObj = new Airports();
				apObj.setAp_code(rsObj.getString("AP_CODE"));
				apObj.setAp_name(rsObj.getString("AP_NAME"));
				apObj.setCity(rsObj.getString("CITY"));
				apObj.setCountry(rsObj.getString("COUNTRY"));
				
				airportList.add(apObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return airportList;
	}
}
