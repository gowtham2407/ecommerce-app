package com.ecommercee.SignupAndLoginFunctions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ecommercee.DAOclasses.ProductsDAO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import BeanClasses.ProductBean;

@WebServlet("/getProducts")
public class FetchProduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		LinkedList<ProductBean> productBeanArray = new LinkedList<>();
		ProductsDAO productsDAO = new ProductsDAO();
		productBeanArray = productsDAO.getAllProducts();
		JSONArray js = new JSONArray();
		for (ProductBean productBean : productBeanArray) {
			String jsonInString = new Gson().toJson(productBean);
			JSONObject mJSONObject = new JSONObject(jsonInString);
			js.put(mJSONObject);
		}
		System.out.println(js.toString());
		response.setContentType("application/json");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		writer.append(js.toString());
		writer.close();

	}

}
