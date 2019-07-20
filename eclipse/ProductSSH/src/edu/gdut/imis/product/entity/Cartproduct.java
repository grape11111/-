package edu.gdut.imis.product.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//该类为购物车的一条记录实体
public class Cartproduct implements Serializable{
	String uID;
	String code;
	String name;
	
	float price;
	int count;
	
    ProductModel pm;
	public ProductModel getPm() {
		return pm;
	}
	public void setPm(ProductModel pm) {
		this.pm = pm;
	}
	
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
