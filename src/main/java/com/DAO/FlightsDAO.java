package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connection.DbConnection;
import com.models.Flights;

public class FlightsDAO {

	private Connection conObj = null;
	private PreparedStatement psObj = null;
	
	public FlightsDAO()
	{
		conObj = DbConnection.getConnection();
	}
	
	public void AddFlights(Flights fgts)
	{
		try {
			psObj = conObj.prepareStatement("Insert into Flights(F_ID, F_NAME, AIRLINE_CODE, SOURCE, DESTINATION, TKT_PRICE, SEATS) VALUES(?,?,?,?,?,?,?)");
			psObj.setString(1, fgts.getFid());
			psObj.setString(2, fgts.getFname());
			psObj.setInt(3, fgts.getAircode());
			psObj.setString(4, fgts.getSource());
			psObj.setString(5, fgts.getDestination());
			psObj.setFloat(6, fgts.getTktprice());
			psObj.setInt(7, fgts.getSeats());
			psObj.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public List<Flights> ShowAll()
	{
		List<Flights>  flightList = new ArrayList<Flights>();
		Flights flight = null;
		try {
			psObj = conObj.prepareStatement("select * from Flights");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				flight = new Flights();
				flight.setFid(rsObj.getString("F_ID"));
				flight.setFname(rsObj.getString("F_NAME"));
				flight.setSource(rsObj.getString("SOURCE"));
				flight.setDestination(rsObj.getString("DESTINATION"));
				flight.setAircode(rsObj.getInt("AIRLINE_CODE"));
				flight.setTktprice(rsObj.getFloat("TKT_PRICE"));
				flight.setSeats(rsObj.getInt("SEATS"));
				flightList.add(flight);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
		return flightList;
	}
	
	public List<String>  getAirportNames()
	{
		List<String>  ApNames = new ArrayList<String>();		
		try {
			psObj = conObj.prepareStatement("select * from Airports");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				String apname = rsObj.getString("CITY");
				ApNames.add(apname);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
		return ApNames;		
	}
	
	public Map<Integer, String> getAirlines()
	{
		Map<Integer, String>  airlinesMap = new HashMap<Integer,String>();
		
		try {
			psObj = conObj.prepareStatement("select * from f_airlines");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				airlinesMap.put(rsObj.getInt("ID"), rsObj.getString("NAME"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
		return airlinesMap;
	}
	
	public List<Flights> SearchFlights(String source, String dest)
	{
		List<Flights>  flightList = new ArrayList<Flights>();
		Flights flight = null;
		try {
			psObj = conObj.prepareStatement("select * from Flights where source=? and destination=?");
			psObj.setString(1, source);
			psObj.setString(2, dest);
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				flight = new Flights();
				flight.setFid(rsObj.getString("F_ID"));
				flight.setFname(rsObj.getString("F_NAME"));
				flight.setSource(rsObj.getString("SOURCE"));
				flight.setDestination(rsObj.getString("DESTINATION"));
				flight.setAircode(rsObj.getInt("AIRLINE_CODE"));
				flight.setTktprice(rsObj.getFloat("TKT_PRICE"));
				flight.setSeats(rsObj.getInt("SEATS"));
				flightList.add(flight);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
		return flightList;
	}

	public Flights SearchFlightsBasedOnID(String fid)
	{		
		Flights flight = null;
		try {
			psObj = conObj.prepareStatement("select * from Flights where F_ID=?");
			psObj.setString(1, fid);			
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				flight = new Flights();
				flight.setFid(rsObj.getString("F_ID"));
				flight.setFname(rsObj.getString("F_NAME"));
				flight.setSource(rsObj.getString("SOURCE"));
				flight.setDestination(rsObj.getString("DESTINATION"));
				flight.setAircode(rsObj.getInt("AIRLINE_CODE"));
				flight.setTktprice(rsObj.getFloat("TKT_PRICE"));
				flight.setSeats(rsObj.getInt("SEATS"));				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
		return flight;
	}
}
