package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DbConnection;
import com.models.Airlines;

public class AirLinesDAO {

	private Connection conObj = null;
	private PreparedStatement psObj = null;
	public AirLinesDAO()
	{
		conObj = DbConnection.getConnection();
	}
	
	public void AddAirLines(Airlines aObj)
	{
		try {
			psObj = conObj.prepareStatement("Insert into f_airlines(name) values(?)");
			psObj.setString(1, aObj.getAirName());
			psObj.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public List<Airlines> ShowAll()
	{
		List<Airlines>  airList = new ArrayList<Airlines>();
		Airlines  aObj = null;
		try {
			psObj = conObj.prepareStatement("select * from f_airlines");
			ResultSet  rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				aObj = new Airlines();
				aObj.setAidId(rsObj.getInt("id"));
				aObj.setAirName(rsObj.getString("name"));
				airList.add(aObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return airList;
	}
}
