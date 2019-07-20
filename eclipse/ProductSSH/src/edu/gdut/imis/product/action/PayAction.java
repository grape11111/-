package edu.gdut.imis.product.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.CartEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;
import edu.gdut.imis.product.entity.Users;

public class PayAction {
	private String orderID;
	private String uID;
	private CartEBI payEbi;
	
	
	
	public CartEBI getPayEbi() {
		return payEbi;
	}
	public void setPayEbi(CartEBI payEbi) {
		this.payEbi = payEbi;
	}
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
	
//	ActionContext context=ActionContext.getContext();
//	Users user=(Users) context.getSession().get("user");	
	
	public String findAllorder() {
		//List<Order>list=EBOFactory.getCartEBO().findAllOrder();
		List<Order> list=payEbi.findAllOrder();
		ActionContext context=ActionContext.getContext();
		context.getSession().put("orderlist", list);
		return "success";
	}
	public String detail() {
		//Order order=EBOFactory.getCartEBO().findByOrderID(orderID, uID);
		Order order=payEbi.findByOrderID(orderID, uID);
		ActionContext context=ActionContext.getContext();
		context.getSession().put("order", order);
		return "detail";
	}
	public String check() {
		//EBOFactory.getCartEBO().checkOrder(orderID);
		//List<Order>list=EBOFactory.getCartEBO().findAllOrder();
		payEbi.checkOrder(orderID);
		List<Order>list=payEbi.findAllOrder();
		ActionContext context=ActionContext.getContext();
		context.getSession().put("orderlist", list);
		return "success";
	}
	
	//用户订单处理
	public String createOrder() {
		ActionContext context=ActionContext.getContext();
		Users user=(Users) context.getSession().get("user");	
		String OrderNumber=user.getuID()+this.createOrderNumber();
		Date date=new Date();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datetime=format.format(date);
		//存放订单中商品编号及对应数量
		
		Map<String,Integer>map=new HashMap<String,Integer>();
		HttpServletRequest req = ServletActionContext.getRequest();
		String[]codes=req.getParameterValues("productcode");
		List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
		context.getSession().put("cartMap", list);
		context.getSession().put("OrderNumber", OrderNumber);
		context.getSession().put("datetime", datetime);
		
		
		for(int i=0;i<codes.length;i++) {
			for(Cartproduct cp:list){
				if(codes[i].equals(cp.getCode())) {
					int count=cp.getCount();
					map.put(codes[i], count);
					break;
				}
			}
		}
		//插入记录到 订单-商品信息表（订单编号、商品id、数量）
		//删除购物车相应的记录
		//插入订单记录到订单信息表  createOrder(String uID, String OrderNumber,String datetime,Map<String,Integer>map);
		//EBOFactory.getCartEBO().createOrder(user.getuID(),OrderNumber,datetime,map);
		payEbi.createOrder(user.getuID(),OrderNumber,datetime,map);
		return "order";
	}
	public String paid() {
//		EBOFactory.getCartEBO().pay(orderID);
//		List<Order> list=EBOFactory.getCartEBO().findAllOrder(user.getuID());
		ActionContext context=ActionContext.getContext();
		Users user=(Users) context.getSession().get("user");	
		payEbi.pay(orderID);
		List<Order>list=payEbi.findAllOrder(user.getuID());
		context.getSession().put("orderlist", list);
		return "paid";
	}
	
	public String findAllorders() {
		//List<Order> list=EBOFactory.getCartEBO().findAllOrder(user.getuID());
		ActionContext context=ActionContext.getContext();
		Users user=(Users) context.getSession().get("user");	
		List<Order>list=payEbi.findAllOrder(user.getuID());
		context.getSession().put("orderlist", list);
		return "paid";
	}
	//创建订单编号
		public static String createOrderNumber(){
			//格式化日期为"yymmdd"
			DateFormat format = new SimpleDateFormat("yyMMdd");
			Date date = new Date();
			StringBuffer buffer = new StringBuffer();
			buffer.append(format.format(date));
			buffer.append((date.getTime() + "").substring(9));
			return buffer.toString();
		}
}
