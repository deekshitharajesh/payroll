package com.quinnox.payrollServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
	public static final String URL = "database-1.cztudrdlgrxw.ap-south-1.rds.amazonaws.com";
	public static final String user = "admin";
	public static final String password = "Saibaba136";
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException  
	{
		System.out.println("Connecting to  Database...");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, user,password);
		
		if(con.isValid(3))
		{
			System.out.println("Connected to Database.");
		}
		
		return con;
}
}
