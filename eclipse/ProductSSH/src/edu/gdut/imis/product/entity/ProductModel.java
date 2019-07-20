package edu.gdut.imis.product.entity;

import java.util.HashSet;
import java.util.Set;

public class ProductModel {
	private String code;
	private String name;
	private  Style style;
	private float price;
	
	private Set<Cartproduct> cp= new HashSet<Cartproduct>();
	public Set<Cartproduct> getCp() {
		return cp;
	}

	public void setCp(Set<Cartproduct> cp) {
		this.cp = cp;
	}
	
	private Set<Orderproduct> op= new HashSet<Orderproduct>();
	public Set<Orderproduct> getOp() {
		return op;
	}

	public void setOp(Set<Orderproduct> op) {
		this.op = op;
	}

	public Style getStyle() {
	return style;
}

	public void setStyle(Style style) {
		this.style = style;
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
}
