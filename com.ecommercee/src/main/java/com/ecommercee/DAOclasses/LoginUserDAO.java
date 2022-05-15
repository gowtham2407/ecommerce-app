package com.ecommercee.DAOclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommercee.Connectionexecution;

import BeanClasses.LoginBean;

public class LoginUserDAO {
	
	public int processLoginUser(LoginBean lb) throws SQLException {
	int i=0;
	
	String QUERY = "SELECT password from users WHERE mobile= ?";
	Connection connection = Connectionexecution.initiateDbConnection();
	PreparedStatement ps= connection.prepareStatement(QUERY);
	ps.setString(1,lb.getMobile() );
	ResultSet rs = ps.executeQuery();
	
	String password = null;
	  while (rs.next()){
		  
		    password=rs.getString("password");
		   
		
	   }
	  System.out.println(password + " " + lb.getPassword());
	if(password.equals(lb.getPassword())) {
		i=1;
	}
	else {
		i=0;
	}
	return i;
	
	}
}
