<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap,java.util.Iterator,java.util.Map,java.util.Map.Entry" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车页面</title>
</head>
<body>
	<% 
	Users user=(Users)session.getAttribute("user");
	List<Cartproduct> list=(List<Cartproduct>)session.getAttribute("cartMap");
	%>
	 <form action='${pageContext.request.contextPath}/Pay_createOrder' method='post'> 
	 <table align='center' width='40%' border='1'> 
	 <tr> 
	 <th colspan='4'><%= user.getuNickname() %>的购物车</th> 
	 </tr> 
		 <tr> 
		 <td>商品名称</td> 			
		 <td>数量</td>
		 <td>价格</td>
		 <td>操作</td> 
		 </tr>
		 <%if(list.size()!=0){
			 for(Cartproduct cp:list){ %> 	
	    	<tr>
				<td><input type='checkbox' name='productcode' value='<%=cp.getCode()%>'><%=cp.getPm().getName()%></td>		
				<td><%=cp.getCount()%></td>
				<td><%=cp.getPm().getPrice()%></td>
				<td><a href='${pageContext.request.contextPath}/cart_delete?code=<%=cp.getCode()%>'>删除</a></td>
			</tr>
			<%} %>
			<tr><td colspan='3'><input type='submit' value='结算'></td>
			<td><a href='${pageContext.request.contextPath}/cart_deleteAll' text-align='right'>清空购物车</a></td>
			</tr>
			<%
			}else{ %>
			<tr><td colspan='4'>购物车没有东西！</td></tr>
			<%} %>   
	</table>
	</form> 	
 </body>
</html>