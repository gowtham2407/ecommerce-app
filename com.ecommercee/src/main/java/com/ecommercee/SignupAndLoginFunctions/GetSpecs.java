package com.ecommercee.SignupAndLoginFunctions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommercee.DAOclasses.ProductsDAO;

@WebServlet("/addspecs")
public class GetSpecs extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		 
		ProductsDAO productsDAO = new ProductsDAO();
		productsDAO.addNewProduct(request);
		
	}

}
