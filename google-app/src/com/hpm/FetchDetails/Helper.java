package com.hpm.FetchDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.hpm.db.ConnectionGetter;



public class Helper {

	
	public String[] commentDetials(String data)
	{
		String[] details=data.split("[\\r\\n]+");
		
		
		
		
		return details;
	}
	
	public String[] userDeatilsplit(String mainValue)
	{
		String values[]=mainValue.split("-");
		
		return values;
	}
	
	
	public  Date getDate(String value)
	{
		
		java.sql.Date date = null;
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy");
		
		
			date = new java.sql.Date(sdf.parse(value).getTime());
			System.out.println(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}
	

	public  int generateAppId()
	{
	

	Random random = new Random();
	int randomInt = random.nextInt();
	System.out.println("random integer:" + Math.abs(randomInt));

	
	return Math.abs(randomInt);
		
		
		
	
		
	}
	
	public double generateRating(String rating)
	{
		System.out.println("aaa  "+rating);
		String aa[]=rating.split(" ");
		return Double.parseDouble(aa[1]);
		
	}
	public static void main(String...args)
	{
		try {
			//getAppID("com.july.cricinfo");
			getOutput("2013-01-18");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//generateAppId();
		//System.out.println(a);
	}
	public int getAppID(String appName) throws Exception
	{

		Connection con=null;
		ResultSet rs=null;
	
		int appid=0;
		try
		{
		con=ConnectionGetter.get();
		String select="select * from appdetails where Name=?";
		//String select="select * from appdetails where Name='com.july.cricinfo'";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,appName);
		
		rs=stmt.executeQuery();
		
		if(rs.next())
		{
		appid=Integer.parseInt(rs.getString(8));
		System.out.println(appid);
		}
		}
		catch (IllegalArgumentException | SQLException e) {
			
			throw e;
			
		}
		return appid;
		
	}
	public static void getOutput(String date) throws Exception
	{	TablePojo tableDetails=new TablePojo();
		Connection con=null;
		ResultSet rs=null;
	
		int appid=0;
		try
		{
		con=ConnectionGetter.get();
		String select="select * from commentdetails where postedDate =?";
		//String select="select * from appdetails where Name='com.july.cricinfo'";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,date);
		
		rs=stmt.executeQuery();
		
		while(rs.next())
		{
			
		//String userName=rs.getString(1);
		tableDetails.setUsername(rs.getString(1));
		tableDetails.setTitle(rs.getString(2));
		tableDetails.setDevice(rs.getString(3));
		tableDetails.setComment(rs.getString(5));
		tableDetails.setDate(rs.getDate(6));
		tableDetails.setRating(rs.getDouble(7));
		
		
		
		}
		}
		catch (IllegalArgumentException | SQLException e) {
			
			throw e;
			
		}
		
		
	}
	
	

}
