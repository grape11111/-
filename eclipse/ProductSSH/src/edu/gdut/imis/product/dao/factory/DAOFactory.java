package edu.gdut.imis.product.dao.factory;

import edu.gdut.imis.product.dao.impl.AdminDAO;
import edu.gdut.imis.product.dao.impl.CartDAO;
import edu.gdut.imis.product.dao.impl.ProductDAO;
import edu.gdut.imis.product.dao.impl.UsersDAO;
public class DAOFactory {
	public static ProductDAO getProductDAO() {
		return new ProductDAO();
	}
	
	public static UsersDAO getUsersDAO() {
		return new UsersDAO();
	}
	
	public static AdminDAO getAdminDAO() {
		return new AdminDAO();
	}
	public static CartDAO getCartDAO() {
		return new CartDAO();
	}
	
}
