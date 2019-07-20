package edu.gdut.imis.product.dao.dai;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;

public interface CartDAI {

	//添加到购物车的记录
	Cartproduct add(String uID,String code);
	List<Cartproduct> findAll(String uID);
	//删除一条购物车记录
	boolean delete(String uID,String code);
	//清空购物车
	boolean deleteAll(String uID);
	
	//生成订单
	boolean createOrder(String uID, String orderID,String datetime,Map<String,Integer>map);	
	//查询该用户所有订单
	List<Order> findAllOrder(String uID);
	//支付订单
	boolean pay(String orderID);
	//删除订单
	boolean deleteOrder(String orderID);
	
	//管理员执行订单
	boolean checkOrder(String orderID);
	//查询整个平台的订单
	List<Order> findAllOrder();
	//通过订单编号查询订单详细信息
	Order  findByOrderID(String orderID,String uID);
}
