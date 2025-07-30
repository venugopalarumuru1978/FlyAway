package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DbConnection;
import com.models.BookingHistory;
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
	
	public List<BookingHistory>  HistoryBasedOnMemberID(int cid)
	{
		List<BookingHistory>  bhList = new ArrayList<BookingHistory>();
		BookingHistory bhObj = null;
		try {
			psObj = conObj.prepareStatement("SELECT C.CUS_NAME, C.PHONE, C.EMAIL,  B.BK_DATE, B.BK_SOURCE, B.BK_DEST, B.BK_AIR_Name, B.BK_TKT_AMT \r\n"
					+ "FROM  CUSTOMER AS C INNER JOIN BOOKINGS AS B\r\n"
					+ "ON B.CID = C.CUS_ID WHERE B.CID = ?");
			psObj.setInt(1, cid);
			ResultSet  rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				bhObj = new BookingHistory();
				bhObj.setCname(rsObj.getString("CUS_NAME"));
				bhObj.setPhone(rsObj.getString("PHONE"));
				bhObj.setEmail(rsObj.getString("EMail"));
				bhObj.setBdate(rsObj.getString("BK_DATE"));
				bhObj.setSource(rsObj.getString("BK_SOURCE"));
				bhObj.setDest(rsObj.getString("BK_DEST"));
				bhObj.setAirname(rsObj.getString("BK_AIR_Name"));
				bhObj.setAmt(rsObj.getFloat("BK_TKT_AMT"));
				bhList.add(bhObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return bhList;
	}
}
