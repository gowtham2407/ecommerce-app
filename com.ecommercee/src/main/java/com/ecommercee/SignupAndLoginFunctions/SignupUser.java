package com.ecommercee.SignupAndLoginFunctions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommercee.DAOclasses.SignupUserDAO;

import BeanClasses.SignupBean;


@WebServlet("/signupUser")
public class SignupUser extends HttpServlet {


	

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			  request.getRequestDispatcher("/WEB-INF/SignupAndLoginUser/SignupUser.jsp").
			  forward(request, response);
			 
			
			
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String typeofuser = null;
		if (request.getParameter("action").equals("1")) {
			typeofuser="buyers";
		}else if(request.getParameter("action").equals("2")) {
			typeofuser="sellers";
		}
		

		SignupBean signupBean = new SignupBean(request.getParameter("username"),request.getParameter("email"), request.getParameter("mobile"), 
				request.getParameter("password"), typeofuser);
		
		
		SignupUserDAO sign= new SignupUserDAO();
		int result=sign.processSignupRequest(signupBean);
			if(result>=1) {
				System.out.println("success");
				request.getRequestDispatcher("/WEB-INF/SignupAndLoginUser/LoginUser.jsp").forward(request,response);
			}else {
				System.out.println("failed");
			}

		}

	}

