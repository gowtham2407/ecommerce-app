package com.ecommercee.SignupAndLoginFunctions;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommercee.Connectionexecution;
import com.ecommercee.DAOclasses.LoginUserDAO;

import BeanClasses.LoginBean;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/SignupAndLoginUser/LoginUser.jsp").forward(request, response);

	}
	
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	LoginBean lb= new LoginBean(request.getParameter("mobile"),request.getParameter("password"));
String typeofuser = null;
	System.out.println(request.getParameter("password"));
	int result=0;
	LoginUserDAO lud=new LoginUserDAO();
	if (request.getParameter("action").equals("1")) {
	typeofuser="Buyer";
	}else if(request.getParameter("action").equals("2")) {
		typeofuser="Seller";
	}
	request.setAttribute("type", typeofuser);	
	System.out.println(typeofuser);
	
	request.getRequestDispatcher("/WEB-INF/main/mainpage.jsp").forward(request, response);
	
	/*
	 * try { result =lud.processLoginUser(lb); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * if(result>=1) { System.out.println("Logged successfully " +
	 * request.getParameter("password") + result ); } else {
	 * System.out.println("Login Failed"); }
	 */

	}

}
