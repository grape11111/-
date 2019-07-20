package edu.gdut.imis.product.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Orderproduct implements Serializable {
	private String orderID;
	private String code;
	private int count;
    private Order order;
    private ProductModel pm;
    public ProductModel getPm() {
		return pm;
	}
	public void setPm(ProductModel pm) {
		this.pm = pm;
	}
    
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
    
    
	
}
