package edu.gdut.imis.product.business.ebo;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.business.ebi.CartEBI;
import edu.gdut.imis.product.dao.dai.CartDAI;
import edu.gdut.imis.product.dao.dai.IBaseDAO;
import edu.gdut.imis.product.dao.factory.DAOFactory;
import edu.gdut.imis.product.dao.impl.CartDAO;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;

public class CartEBO implements CartEBI{
	private CartDAI bdao;
	public CartDAI getBdao() {
		return bdao;
	}

	public void setBdao(CartDAI bdao) {
		this.bdao = bdao;
	}
	
	@Override
	public Cartproduct add(String uID, String code) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.add(uID, code);
	}

	@Override
	public List<Cartproduct> findAll(String uID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.findAll(uID);
	}

	@Override
	public boolean delete(String uID, String code) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.delete(uID, code);
	}

	@Override
	public boolean deleteAll(String uID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.deleteAll(uID);
	}

	@Override
	public boolean createOrder(String uID, String orderID, String datetime, Map<String, Integer> map) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.createOrder(uID, orderID, datetime, map);
	}

	@Override
	public List<Order> findAllOrder(String uID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.findAllOrder(uID);
	}

	@Override
	public boolean pay(String orderID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.pay(orderID);
	}

	@Override
	public boolean deleteOrder(String orderID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.deleteOrder(orderID);
	}

	@Override
	public boolean checkOrder(String orderID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.checkOrder(orderID);
	}

	@Override
	public List<Order> findAllOrder() {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.findAllOrder();
	}

	@Override
	public Order findByOrderID(String orderID, String uID) {
		//CartDAO bdao=DAOFactory.getCartDAO();
		return bdao.findByOrderID(orderID, uID);
	}

}
