package com.ecommercee.SignupAndLoginFunctions;

import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ecommercee.Connectionexecution;
import com.ecommercee.DAOclasses.ProductsDAO;
import com.ecommercee.DAOclasses.SpecsDAO;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxResultset;

@WebServlet("/addProducts")
public class AddProducts extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/addproducts/addproducts.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> arr = new ArrayList<>();
		String category;
		category = request.getParameter("category");
		SpecsDAO sd = new SpecsDAO();

		try {
			arr = sd.processRequestSpecs(category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		JSONObject obj = new JSONObject();
		obj.put("specs", arr);
		response.setStatus(200);
		System.out.println(obj.get("specs"));
		writer.append(obj.toString());
		writer.close();

	}

}
