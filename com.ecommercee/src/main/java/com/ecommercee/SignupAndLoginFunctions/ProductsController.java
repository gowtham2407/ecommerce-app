package com.ecommercee.SignupAndLoginFunctions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommercee.DAOclasses.ProductsDAO;

import BeanClasses.ProductBean;

@WebServlet("/mainPage")
public class ProductsController extends HttpServlet {

	ArrayList<ProductBean> products = new ArrayList<>();
	ArrayList<ProductBean> products2 = new ArrayList<>();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductsDAO pdao = new ProductsDAO();

		try {
			products2 = pdao.processProductsListing();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("products", products2);

		request.getRequestDispatcher("/WEB-INF/addproducts/addproducts.jsp").forward(request, response);

	}

}
