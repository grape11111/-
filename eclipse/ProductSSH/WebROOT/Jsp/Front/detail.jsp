<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品一览</title>
</head>
<body>
	<% 
		ProductModel pm=(ProductModel)session.getAttribute("productmodel");
	%>
		 <table align='left' width='90%' style="line-height:50px;"> 
		 <tr> 
		 <td>商品条码</td> 
		 <td>商品名称</td> 
		 <td>商品类别</br> 
		 <td>商品价格</td> 
		 </tr> 
			 <tr> 
			 <td><%= pm.getCode() %></td> 
			 <td><%= pm.getName() %></td> 
			 <td><%= pm.getStyle().getValue() %></td> 
  		    <td><%= pm.getPrice() %></td> 
  		  <td><a href='${pageContext.request.contextPath}/cart_add?code=<%=pm.getCode()%>'>加入购物车</a></td> 
			 </tr> 					
		 </table> 
</body> 
</html> 