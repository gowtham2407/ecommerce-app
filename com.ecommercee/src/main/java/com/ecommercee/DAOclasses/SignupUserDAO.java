package com.ecommercee.DAOclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommercee.Connectionexecution;

import BeanClasses.SignupBean;


public class SignupUserDAO {
	public int processSignupRequest(SignupBean signupBean) {

		int i=0;

		String Insert_Query = "INSERT INTO users VALUES(?, ?,?,?,?)";
		Connection connection = Connectionexecution.initiateDbConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(Insert_Query);
			ps.setString(1, signupBean.email);
			ps.setString(2 ,signupBean.username);
			ps.setString(3, signupBean.mobile);
		    ps.setString(4 ,signupBean.password);
            ps.setString(5,signupBean.typeofuser);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
