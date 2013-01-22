package com.hpm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionGetter {
	
	public static Connection get() throws IllegalArgumentException
	{
		
		String driverName = "com.mysql.jdbc.Driver";
		String userid  = "root";
		String password="";
		String url = "jdbc:mysql://localhost:3306/applications";
		Connection con=null;
		try {
			Class.forName(driverName);
			con =  DriverManager.getConnection(url,userid,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new IllegalArgumentException("database connection is not got");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new IllegalArgumentException("database connection is not got");
		}
		if( con != null)
			System.out.println("connection got");
		return con;
	
		
	}

}
