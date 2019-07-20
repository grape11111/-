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
	String code=request.getParameter("code");
	ProductModel productmodel=(ProductModel)session.getAttribute("productmodel");
	if(productmodel!=null) {
	%>
			 <form action='${pageContext.request.contextPath}/Product_update' method='post'> 
			 <table align='center' width=40% height=260px> 
			 <tr><td>商品条码:</td> <td><input type='text' name="pm.code" value=<%=productmodel.getCode()%>></td></tr> 
			 <tr><td>商品名称:</td> <td><input type='text' name="pm.name" value=<%=productmodel.getName()%>></td></tr> 
			 <!-- <tr><td>商品类别:</td> <td><select name='style'><option value='Clothes'>服装</option><option value='Food'>食物</option><option value='Book'>图书</option></select></td></tr>-->
			 <%if(("Clothes").equals(productmodel.getStyle().name())){ %>
				 <tr><td>商品类别:</td> <td><select name="pm.style"><option value='Clothes' selected='true'>服装</option><option value='Food'>食物</option><option value='Book'>图书</option></select></td></tr> 
			 <%}else if(("Food").equals(productmodel.getStyle().name())){ 
			 %> 
			 <tr><td>商品类别:</td> <td><select name="pm.style"><option value='Clothes'>服装</option><option value='Food' selected='true'>食物</option><option value='Book'>图书</option></select></td></tr>
			 <%}else if(("Book").equals(productmodel.getStyle().name())){ 
			 %> 
			 <tr><td>商品类别:</td> <td><select name="pm.style"><option value='Clothes'>服装</option><option value='Food'>食物</option><option value='Book' selected='true'>图书</option></select></td></tr>
			 <%} 
			 %> 
			 <tr><td>商品价格:</td> <td><input type='text' name="pm.price" value=<%=productmodel.getPrice()%>></td></tr> 
			 <tr><td colspan=2 align='center'><input type='submit' value='保存'></td></tr> 		
			 </table> 
			 </form> 
<%         } 
%>	
			
	
</body>
</html>