/*Bean to store product date*/
package com.springcommerce;

public class Product {
	public Product(){};
	
	private String productId;
	private String productName;
	
	public Product(String pid, String pName) {
		this.productId=pid;
		this.productName=pName;
	}
	
	
	public String getProductId() {
		return this.productId;
	}
	public void setProductId(String pid) {
		this.productId = pid;
	}
	
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String pName) {
		this.productName = pName;
	}
	
	@Override
	public String toString() {
		return "ProductID="+productId +": Product Name="+productName;
	}
}