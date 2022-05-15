package com.ecommercee.DAOclasses;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.ecommercee.Connectionexecution;

import BeanClasses.LoginBean;
import BeanClasses.ProductBean;

public class ProductsDAO {

	public int brandId;
	public int productId;
	public int specsId;

	public ArrayList<ProductBean> processProductsListing() throws SQLException {

		String QUERY = "SELECT productsname,price,discount from productsdata";

		Connection connection = Connectionexecution.initiateDbConnection();
		PreparedStatement ps = connection.prepareStatement(QUERY);

		ResultSet rs = ps.executeQuery();

		ArrayList<ProductBean> products = new ArrayList<>();
		String productname = null;

		int price;
		int discount;
		while (rs.next()) {

			productname = rs.getString("productname");
			price = rs.getInt("price");
			discount = rs.getInt("discount");

		}
		return products;

	}

	public int addNewProduct(HttpServletRequest request) {
		Map<String, String[]> reqBodyMap = request.getParameterMap();
		HashMap<String, String> specsMap = new HashMap<>();
		for (Map.Entry mapElement : reqBodyMap.entrySet()) {
			String key = (String) mapElement.getKey();
			String[] value = ((String[]) mapElement.getValue());
			System.out.println(key + " : " + value[0]);
			if (key.contains("spec")) {
				String[] spec = key.split("=");
				specsMap.put(spec[1], value[0]);
			}
		}
		String checkBrand = "select * from brand where brandname=? AND category=?";
		Connection connection = Connectionexecution.initiateDbConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(checkBrand);
			ps.setString(1, request.getParameter("brandName"));
			ps.setString(2, request.getParameter("category"));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.brandId = rs.getInt("brandid");
			} else {
				String insertNewBrand = "INSERT INTO brand values (?, ?, DEFAULT)";
				ps = connection.prepareStatement(insertNewBrand, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, request.getParameter("category"));
				ps.setString(2, request.getParameter("brandName"));
				int resultToInsertNewBrand = ps.executeUpdate();
				System.out.println("result of insert query -- " + resultToInsertNewBrand);
				if (resultToInsertNewBrand == 1) {
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						System.out.println("brandID of newly insereted -- " + rs.getInt(1));
						this.brandId = rs.getInt(1);
					}
				}
			}
			System.out.println("finally the brand ID" + this.brandId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String checkProduct = "select * from product where brandid=? AND productname=?";

		try {
			ps = connection.prepareStatement(checkProduct);
			ps.setInt(1, this.brandId);
			ps.setString(2, request.getParameter("productName"));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.productId = rs.getInt("productid");
			} else {
				String insertNewProduct = "INSERT INTO product values (?, DEFAULT, ?, ?)";
				ps = connection.prepareStatement(insertNewProduct, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, brandId);
				ps.setString(2, request.getParameter("productName"));
				ps.setString(3, request.getParameter("productDesc"));
				int resultToInsertNewProduct = ps.executeUpdate();
				if (resultToInsertNewProduct == 1) {
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						this.productId = rs.getInt(1);
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String checkSpecs = "select * from specsstorage where value=?";

		try {
			System.out.println("specsMap ------" + specsMap);
			ps = connection.prepareStatement(checkSpecs);
			ps.setString(1, specsMap.toString());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				this.specsId = rs.getInt("specsid");
			} else {
				String insertNewSpecs = "INSERT INTO specsstorage values (?, DEFAULT)";
				ps = connection.prepareStatement(insertNewSpecs, Statement.RETURN_GENERATED_KEYS);
				System.out.println(specsMap.toString());
				ps.setString(1, specsMap.toString());
				int resultToInsertNewSpecs = ps.executeUpdate();
				if (resultToInsertNewSpecs == 1) {
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						this.specsId = rs.getInt(1);
					}
				}
			}

			System.out.println("specsId --- " + specsId);
			// use properties to restore the map
//			Properties props = new Properties();
//			try {
//				props.load(new StringReader(strMap.substring(1, strMap.length() - 1).replace(", ", "\n")));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}       
//			Map<String, String> map2 = new HashMap<String, String>();
//			for (Map.Entry<Object, Object> e : props.entrySet()) {
//			    map2.put((String)e.getKey(), (String)e.getValue());
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String checkProductsData = "select * from productsdata where productid=? AND sellermobile=? AND specsid=?";
		try {
			ps = connection.prepareStatement(checkProductsData);
			ps.setInt(1, productId);
			ps.setString(2, request.getParameter("sellerMob"));
			ps.setInt(3, specsId);
			ResultSet rs = ps.executeQuery();
			int updatedquantity = 0;
			if (rs.next()) {
				updatedquantity = rs.getInt("updatedquantity") + Integer.parseInt(request.getParameter("updatedCount"));
				ps = connection.prepareStatement(
						"update productsdata set updatedquantity=? where productid=? AND sellermobile=? AND specsid=?");
				ps.setInt(1, updatedquantity);
				ps.setInt(2, productId);
				ps.setString(3, request.getParameter("sellerMob"));
				ps.setInt(4, specsId);
				int updateCountInProductTable = ps.executeUpdate();
				System.out.println("product inserted into product table" + updateCountInProductTable);
			} else {
				String insertNewProductData = "Insert into productsdata values(?,?,?,?,?,?,DEFAULT)";
				ps = connection.prepareStatement(insertNewProductData);
				ps.setInt(1, productId);
				ps.setInt(2, Integer.parseInt(request.getParameter("updatedCount")));
				ps.setString(3, request.getParameter("sellerMob"));
				ps.setInt(4, this.specsId);
				ps.setInt(5, Integer.parseInt(request.getParameter("price")));
				ps.setInt(6, Integer.parseInt(request.getParameter("discount")));
				int insertNewProduct = ps.executeUpdate();
				System.out.println("product inserted into product table" + insertNewProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public LinkedList<ProductBean> getAllProducts() {
		LinkedList<ProductBean> productBeanArray = new LinkedList<>();
		Connection connection = Connectionexecution.initiateDbConnection();
		String getAllProductsQuery = "select productsdata.productid, product.productname, productsdata.updatedquantity, productsdata.sellermobile, productsdata.price, productsdata.discount, productsdata.inventoryid, brand.brandname, brand.category, product.productdesc, specsstorage.value from productsdata inner join product on productsdata.productid = product.productid inner join specsstorage on productsdata.specsid = specsstorage.specsid inner join brand on product.brandid = brand.brandid ";
		try {
			PreparedStatement ps = connection.prepareStatement(getAllProductsQuery);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductBean productBean = new ProductBean();
				productBean.setProductName(rs.getString("productname"));
				productBean.setBrandName(rs.getString("brandname"));
				productBean.setUpdatedQuantity(rs.getInt("updatedquantity"));
				productBean.setSellerMobile(rs.getString("sellermobile"));
				productBean.setPrice(rs.getInt("price"));
				productBean.setDiscount(rs.getInt("discount"));
				productBean.setInventoryId(rs.getInt("inventoryid"));
				productBean.setCategory(rs.getString("category"));
				productBean.setProductDesc(rs.getString("productdesc"));

				// used properties to restore the map
				Properties props = new Properties();
				String specsMapStr = rs.getString("value");

				try {
					props.load(
							new StringReader(specsMapStr.substring(1, specsMapStr.length() - 1).replace(", ", "\n")));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				HashMap<String, String> map2 = new HashMap<String, String>();
				for (Entry<Object, Object> e : props.entrySet()) {
					map2.put((String) e.getKey(), (String) e.getValue());
				}
				productBean.setSpecsMap(map2);
				productBeanArray.push(productBean);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productBeanArray;

	}

}
