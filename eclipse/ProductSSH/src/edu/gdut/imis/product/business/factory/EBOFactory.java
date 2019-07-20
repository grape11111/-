package edu.gdut.imis.product.business.factory;

import edu.gdut.imis.product.business.ebo.AdminEBO;
import edu.gdut.imis.product.business.ebo.CartEBO;
import edu.gdut.imis.product.business.ebo.ProductEBO;
import edu.gdut.imis.product.business.ebo.UsersEBO;

public class EBOFactory {
	public static ProductEBO getProductEBO() {
		return new ProductEBO();
	}
	
	public static UsersEBO getUsersEBO() {
		return new UsersEBO();
	}
	
	public static AdminEBO getAdminEBO() {
		return new AdminEBO();
	}
	public static CartEBO getCartEBO() {
		return new CartEBO();
	}
}
