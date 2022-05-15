package com.ecommercee.DAOclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommercee.Connectionexecution;

public class SpecsDAO {

	public ArrayList<String> processRequestSpecs(String category) throws SQLException {
		Connection connection = Connectionexecution.initiateDbConnection();
		String Query = "SELECT specs from meta where category=?";
		
			PreparedStatement ps =connection.prepareStatement(Query);
			ps.setString(1,category );
		ResultSet rs=ps.executeQuery();
		ArrayList<String> arr= new ArrayList<>();
		while (rs.next()){
			  
			
			  String temp=rs.getString("specs");
			  arr.add(temp);
			 
		   }
		
		
		return arr;
		
	}

}
