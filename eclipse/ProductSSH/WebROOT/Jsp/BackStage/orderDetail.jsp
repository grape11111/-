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
	Order order=(Order)session.getAttribute("order");
	%>
	 <table align='center' width='60%' > 
			 <tr> 
			 <th colspan='3'>订单信息</th> 
			 </tr> 
			 <tr> 
			 <td colspan='3'><b>会员编号：</b><%= order.getuID()%></td>
			 </tr>
			 <tr><td colspan='3'>----------------------------------------------------------------------------------------------</td></tr> 
			 <%
			 if(order!=null){
					 String orderID=order.getOrderID();
					 String datetime=order.getDatetime();
					 float totalprice=0f;
			 %>
			 <tr> 
			 <td text-align='left'><b>订单编号：</b><%= orderID%></td> 
			 <td><b>时间：</b><%= datetime%></td>
			 <%
			 if(order.getStatus()==0){
			 %>
				 <td><b>订单状态：</b>[未支付]</td>
			 <%
			 }else if(order.getResult()==0){
			 %>
				 <td><b>订单状态：</b>[已支付]<a href='${pageContext.request.contextPath}/Pay_check?orderID=<%=orderID%>'><button>执行</button></a></td>
			 <%	 
			 }else if(order.getResult()==1){
			 %>
				<td><b>订单状态：</b>已被处理</td>
			 <%
			 }
			 %> 
			 </tr> 
			 <tr><td colspan='3'>----------------------------------------------------------------------------------------------</td></tr> 
				 <tr> 
				 <td><b>商品名称</b></td> 
				 <td><b>价格</b></td> 
				 <td><b>数量</b></td> 
			     </tr> 	
<%
Set<Orderproduct> productlist=order.getList();
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
		
	</table>
</body>
</html>