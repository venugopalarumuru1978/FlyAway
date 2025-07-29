package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.DbConnection;
import com.models.Bookings;

public class BookingsDAO {

	private Connection conObj = null;
	private PreparedStatement  psObj =  null;
	
	public BookingsDAO()
	{
		conObj = DbConnection.getConnection();
	}
	
	public void AddBookings(Bookings  bk)
	{
		try {
			psObj = conObj.prepareStatement("Insert into Bookings(CID, BK_DATE, BK_SOURCE, BK_DEST, BK_AIR_Name, BK_TKT_AMT)values(?,?,?,?,?,?)");
			psObj.setInt(1, bk.getCid());
			psObj.setString(2, bk.getBkDate());
			psObj.setString(3, bk.getSource());
			psObj.setString(4,bk.getDest());
			psObj.setString(5, bk.getAirname());
			psObj.setFloat(6, bk.getAmt());
			psObj.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
