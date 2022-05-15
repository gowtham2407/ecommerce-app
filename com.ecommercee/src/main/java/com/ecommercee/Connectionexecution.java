package com.ecommercee;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionexecution   {
	
	public static Connection initiateDbConnection() {
		
		String Drivername = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "Ecommerce";
		String dbUsername = "root";
		String dbPassword = "king@123";

		Connection connection = null;
		
		try {

		    Class.forName(Drivername);
		    connection = DriverManager.getConnection(dbUrl + dbName, dbUsername, dbPassword);

		} catch (Exception e) {

		    e.printStackTrace();
		}

		return connection;
	    }

}
