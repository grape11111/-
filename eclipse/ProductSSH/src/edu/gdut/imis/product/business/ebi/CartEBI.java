package edu.gdut.imis.product.business.ebi;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;

public interface CartEBI {
	Cartproduct add(String uID,String code);
	List<Cartproduct> findAll(String uID);
	boolean delete(String uID,String code);
	//清空购物车
	boolean deleteAll(String uID);
	
	boolean createOrder(String uID, String orderID,String datetime,Map<String,Integer>map);
	List<Order> findAllOrder(String uID);
	
	boolean pay(String orderID);
	boolean deleteOrder(String orderID);
	
	boolean checkOrder(String orderID);
	List<Order> findAllOrder();
	//通过订单编号查询订单详细信息
	Order  findByOrderID(String orderID,String uID);
}
