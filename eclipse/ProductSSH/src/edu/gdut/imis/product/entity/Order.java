package edu.gdut.imis.product.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//������¼
public class Order {
	private String orderID;
	private String uID;
	private String datetime;
	private int status;//����״̬��0��δ֧��   1����֧����
	private int result;//����Ա�Զ���ִ��״̬��0��δ���� 1����ִ�С�
	private Set<Orderproduct>list;//��������Ʒ��Ϣ
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
