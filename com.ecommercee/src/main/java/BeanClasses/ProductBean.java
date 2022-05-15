package BeanClasses;

import java.util.HashMap;
import java.util.LinkedList;

public class ProductBean {

	String productName;
	String brandName;
	int updatedQuantity;
	String sellerMobile;
	int price;
	int discount;
	int inventoryId;
	String category;
	String productDesc;
	HashMap<String, String> specsMap;
	
	public ProductBean() {}
	
	public ProductBean(String productName, String brandName, int updatedQuantity, String sellerMobile, int price,
			int discount, int inventoryId, String category, String productDesc, HashMap<String, String> specsMap) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.updatedQuantity = updatedQuantity;
		this.sellerMobile = sellerMobile;
		this.price = price;
		this.discount = discount;
		this.inventoryId = inventoryId;
		this.category = category;
		this.productDesc = productDesc;
		this.specsMap = specsMap;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getUpdatedQuantity() {
		return updatedQuantity;
	}

	public void setUpdatedQuantity(int updatedQuantity) {
		this.updatedQuantity = updatedQuantity;
	}

	public String getSellerMobile() {
		return sellerMobile;
	}

	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public HashMap<String, String> getSpecsMap() {
		return specsMap;
	}

	public void setSpecsMap(HashMap<String, String> specsMap) {
		this.specsMap = specsMap;
	}

}