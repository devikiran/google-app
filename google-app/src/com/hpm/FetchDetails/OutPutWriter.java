package com.hpm.FetchDetails;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hpm.db.ConnectionGetter;

public class OutPutWriter {
	static BufferedWriter out;
	public static String getInnerTable() {
		return " <table border=\"1\"  width=\"100%\"> \n\r  <tr><!-- Row 1 --> \n\r <td>userName</td> \n\r  <td>Title</td> \n\r <td>DeviceName</td> \n\r <td>Comment</td> \n\r <td>Date</td>\n\r <td>Rating</td></tr> \n\r ";
	}
	
	public static String getHeader()
	{
		return "<!DOCTYPE html>  <html lang=\"en\"> \n\r  <head>  \n\r  <title>Report</title> \n\r  </head>  \n\r  <body> \n\r";
	}
	public static String getOuterTable(){
		
		
		String outerTable= " <table border=\"1\"  width=\"100%\"> \n\r  <tr><!-- Row 1 --> \n\r <td><b>AppName</b></td> \n\r  <td><b>Ratings<b></td> \n\r <td><b>Downloads</b></td> \n\r <td><b>Updated Date<b></td>\n\r ";
		
		return outerTable;
		
	}
	
	public static String getInnerHeader()
	{
		String innerHeader="<table border='1'  width='100%' > \n\r <tr><!-- Row 1 --> \n\r <td><b>UserName</b>  </td>  \n\r <td><b>Title</b></td> <td><b>Device</b></td> <td><b>Comment</b></td> <td><b>Posted Date</b></td><td><b>Rating</b></td> </b> </tr> <tr><tr> \n\r";
		return innerHeader;
	}
	
	

	public static void main(String[] args) {
		try {
			
			 out = new BufferedWriter(new FileWriter("com.tour.pgatour.html"));
			out.write(getHeader());
			out.newLine();
			out.append(getOuterTable());
			//out.append(getAppData("com.july.cbssports.activity"));
			//out.append(getAppData("com.july.cricinfo"));
			//out.append(getAppData("com.trimble.allsportle"));
			//out.append(getAppData("air.mobileplayer.novisign.com"));
			//out.append(getAppData("com.july.indya"));
			out.append(getAppData("com.tour.pgatour"));
			
			out.append(getInnerHeader());
			
			
			out.append(getCommentsOutput("2013-1-21"));
			
		//System.out.println(getHeader());
		//System.out.println(getOuterTable());
		//System.out.println(getAppData("com.july.cbssports.activity"));
		//System.out.println(getInnerTable());
		//getCommentsOutput("2013-1-21");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static String setCommentData(String userName,String Title,String Device,String Comment,Date date,Double Rating)
	{
		String userData="<tr> \n\r <td>"+userName+"</td>  \n\r<td>"+Title +"</td>  \n\r <td>"+ Device+"</td>  \n\r <td>"+ Comment+"</td> <td>"+ date+"</td>  <td>"+ Rating+"</td> </tr>";
		//System.out.println(userData);
		try {
			out.append(userData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userData;
	}
	public static String getCommentsOutput(String date) throws Exception
	{	
		Connection con=null;
		ResultSet rs=null;
		String val=null;
	
		try
		{
		con=ConnectionGetter.get();
		String select="select * from commentdetails where postedDate <?";
		//String select="select * from appdetails where Name='com.july.cricinfo'";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,date);
		
		rs=stmt.executeQuery();
		
		while(rs.next())
		{
			 val=setCommentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(6),rs.getDouble(7));
			 System.out.println(val);
			 
			 
			}
		}
		catch (IllegalArgumentException | SQLException e) {
			
			throw e;
			
		}
		
		return val;
	}
	public static String getAppData(String appName) throws Exception
	{
		Connection con=null;
		ResultSet rs=null;
		String appDetails = null;
		try
		{
		con=ConnectionGetter.get();
		String select="select * from appdetails where Name=?";
		//String select="select * from appdetails where Name='com.july.cricinfo'";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,appName);
		
		rs=stmt.executeQuery();
		
		while(rs.next())
		{
			 appDetails=setAppData(rs.getString(1),rs.getDouble(9),rs.getString(3),rs.getDate(11),"2013-01-21");
		}
		}
		catch (IllegalArgumentException | SQLException e) {
			
			throw e;
			
		}
		return appDetails;
	}
	
	public static String setAppData(String appName,Double Rating,String Downloads,Date updatedDate,String inputDate) throws Exception
	{
		String userData="<tr> \n\r <td>"+appName+"</td>  \n\r<td>"+Rating +"</td>  \n\r <td>"+ Downloads+"</td>  \n\r <td>"+ updatedDate+"</td> \n\r <td> </table>";/*+ getCommentsOutput(inputDate)+"</td> </tr>";*/
		//System.out.println(userData);
		return userData;
	}
}
