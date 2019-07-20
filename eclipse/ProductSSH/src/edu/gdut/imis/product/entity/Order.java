package edu.gdut.imis.product.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//订单记录
public class Order {
	private String orderID;
	private String uID;
	private String datetime;
	private int status;//订单状态【0：未支付   1：已支付】
	private int result;//管理员对订单执行状态【0：未处理 1：已执行】
	private Set<Orderproduct>list;//订单中商品信息
	//private float price;

	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Set<Orderproduct> getList() {
		return list;
	}
	public void setList(Set<Orderproduct> list) {
		this.list = list;
	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
	
	
}
