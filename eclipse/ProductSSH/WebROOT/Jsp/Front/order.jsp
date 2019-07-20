<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap,java.util.Iterator,java.util.Map,java.util.Map.Entry"%>
<%@ page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单页面</title>
</head>
<body>
	<% 
	Users user=(Users)session.getAttribute("user");
	List<Order> list=(List<Order>)session.getAttribute("orderlist");
	%>
	 <table align='center' width='60%' > 
			 <tr> 
			 <th colspan='3'>我的订单</th> 
			 </tr> 
			 <tr> 
			 <td text-align='left'><b>用户名：</b><%= ((Users)session.getAttribute("user")).getuNickname()%></td>
			 <td text-align='left'><b>联系方式：</b><%= ((Users)session.getAttribute("user")).getuPhone()%></td> 
			 <td text-align='left'><b>地址：</b><%= ((Users)session.getAttribute("user")).getuAddress()%></td>  
			 </tr>
			 <tr><td colspan='3'>----------------------------------------------------------------------------------------------</td></tr> 
			 <%
			 if(list.size()!=0){
				 for(Order or:list){
					 String orderID=or.getOrderID();
					 String datetime=or.getDatetime();
					 float totalprice=0f;
			 %>
			 <tr> 
			 <td text-align='left'><b>订单编号：</b><%= orderID%></td> 
			 <td><b>时间：</b><%= datetime%></td>
			 <%
			 if(or.getStatus()==0){
			 %>
				 <td><b>订单状态：</b><a href='${pageContext.request.contextPath}/Pay_paid?orderID=<%= orderID%>'><button>支付</button></a>&nbsp;&nbsp;<a href='/Product/pay?submitFlag=delete&orderID=<%= orderID%>'><button>删除</button></a></td>
			 <%
			 }else if(or.getResult()==0){
			 %>
				 <td><b>订单状态：</b>[已支付|未执行]</td>
			 <%	 
			 }else if(or.getResult()==1){
			 %>
				<td><b>订单状态：</b>[已支付|已执行]</td>
			 <%
			 }
			 %> 
			 </tr> 
				 <tr> 
				 <td><b>商品名称</b></td> 
				 <td><b>价格</b></td> 
				 <td><b>数量</b></td> 
			     </tr> 	
<%
					Set<Orderproduct> productlist=or.getList();
					//for(Orderproduct op:productlist){
					Iterator it1 = productlist.iterator();
                    while(it1.hasNext()){  
                        Orderproduct op=(Orderproduct)it1.next();
						String productName=op.getPm().getName();
						Float price=op.getPm().getPrice();
						int count=op.getCount();
 %>
                <tr>
					<td><%= productName%></td>
					<td><%= price%></td>
					<td><%= count%></td>
				</tr>	
<%					
					totalprice+=price*count;
					}
%>
		<tr><td colspan='3' text-align='right'><b>商品总价为：</b><%= totalprice %></td></tr>
		<tr><td colspan='3'>----------------------------------------------------------------------------------------------</td></tr>
		<%      } %>
		
		<% } %>
	</table>
</body>
</html>