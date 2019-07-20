package edu.gdut.imis.product.controller;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	import java.util.Map.Entry;
    import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;
	public class PayServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//通过标签判断是进行“生成订单”还是“支付”操作
			String submitFlag=req.getParameter("submitFlag");
			HttpSession session=req.getSession();
			Users user=(Users) session.getAttribute("user");
			//支付
			if(("paid").equals(submitFlag)) {
				//获取订单编号
				//修改订单状态为已支付，返回订单信息
				String orderID=req.getParameter("orderID");
				EBOFactory.getCartEBO().pay(orderID);
				RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/Front/order.jsp");
			    dispatcher.forward(req, resp);	     
			}else if(("delete").equals(submitFlag)) {
				String orderID=req.getParameter("orderID");
				EBOFactory.getCartEBO().deleteOrder(orderID);
				RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/Front/order.jsp");
			    dispatcher.forward(req, resp);
			}else if(("check").equals(submitFlag)) {
				String orderID=req.getParameter("orderID");
				EBOFactory.getCartEBO().checkOrder(orderID);
				RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/order.jsp");
			    dispatcher.forward(req, resp);
			}else if(("detail").equals(submitFlag)) {
				String orderID=req.getParameter("orderID");
				String uID=req.getParameter("uID");
				EBOFactory.getCartEBO().findByOrderID(orderID, uID);
				RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/orderDetail.jsp");
			    dispatcher.forward(req, resp);
			}else {
			//生成订单
			//订单编号：用户ID+日期6位+时间戳后4位
			String OrderNumber=user.getuID()+this.createOrderNumber();
			Date date=new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String datetime=format.format(date);
			//存放订单中商品编号及对应数量
			Map<String,Integer>map=new HashMap<String,Integer>();
			String[]codes=req.getParameterValues("productcode");
			List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
			session.setAttribute("cartMap", list);
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
			EBOFactory.getCartEBO().createOrder(user.getuID(),OrderNumber,datetime,map);

			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/Front/pay.jsp?OrderNumber="+OrderNumber+"&datetime="+datetime+"");
			dispatcher.forward(req, resp);
		 }
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

