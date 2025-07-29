package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DbConnection;
import com.models.Members;

public class MemberDAO {

	
	private Connection conObj = null;
	private PreparedStatement psObj = null;
	
	public MemberDAO()
	{	
		conObj = DbConnection.getConnection();
	}
	
	public void AddMember(Members memObj)
	{
		try {
			psObj = conObj.prepareStatement("Insert into customer(CUS_NAME, PHONE, EMAIL, PSWD, LOCATION) values(?,?,?,?,?)");
			psObj.setString(1, memObj.getCusname());
			psObj.setString(2, memObj.getPhone());
			psObj.setString(3, memObj.getEmail());
			psObj.setString(4, memObj.getPswd());
			psObj.setString(5, memObj.getLocation());
			psObj.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public List<Members> ShowAll()
	{
		List<Members>  memList = new ArrayList<Members>();
		Members  mem = null;
		try {
			psObj = conObj.prepareStatement("select * from customer");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				mem = new Members();
				mem.setCusid(rsObj.getInt("CUS_ID"));
				mem.setCusname(rsObj.getString("CUS_NAME"));
				mem.setPhone(rsObj.getString("PHONE"));
				mem.setEmail(rsObj.getString("EMAIL"));
				mem.setPswd(rsObj.getString("PSWD"));
				mem.setLocation(rsObj.getString("LOCATION"));
				memList.add(mem);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return memList;
	}
	
	public Members  UserCheck(String email, String pwd)
	{
		Members mem = null;
		try {
			psObj = conObj.prepareStatement("select * from customer where email=? and pswd=?");
			psObj.setString(1,email);
			psObj.setString(2, pwd);
			ResultSet rsObj = psObj.executeQuery();
			
			if(rsObj.next())
			{
				mem = new Members();
				mem.setCusid(rsObj.getInt("CUS_ID"));
				mem.setCusname(rsObj.getString("CUS_NAME"));
				mem.setPhone(rsObj.getString("PHONE"));
				mem.setEmail(rsObj.getString("EMAIL"));
				mem.setPswd(rsObj.getString("PSWD"));
				mem.setLocation(rsObj.getString("LOCATION"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return mem;
	}
	public Members  SearchMember(int cid)
	{
		Members mem = null;
		try {
			psObj = conObj.prepareStatement("select * from customer where cus_id=?");
			psObj.setInt(1, cid);
			ResultSet rsObj = psObj.executeQuery();
			
			if(rsObj.next())
			{
				mem = new Members();
				mem.setCusid(rsObj.getInt("CUS_ID"));
				mem.setCusname(rsObj.getString("CUS_NAME"));
				mem.setPhone(rsObj.getString("PHONE"));
				mem.setEmail(rsObj.getString("EMAIL"));
				mem.setPswd(rsObj.getString("PSWD"));
				mem.setLocation(rsObj.getString("LOCATION"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return mem;
	}
}
