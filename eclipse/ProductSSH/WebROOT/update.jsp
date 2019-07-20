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
	ProductModel pm=EBOFactory.getProductEBO().findByCode(code);
	if(pm!=null) {
	%>
			 <form action='/ProductSSH/Product' method='post'> 
			 <input type='hidden' name='submitFlag' value='Update'> 
			 <table align='center' width=20% height=260px> 
			 <tr><td>商品条码:</td> <td><input type='text' name='code' value=<%=pm.getCode()%>></td></tr> 
			 <tr><td>商品名称:</td> <td><input type='text' name='name' value=<%=pm.getName()%>></td></tr> 
			 <!-- <tr><td>商品类别:</td> <td><select name='style'><option value='Clothes'>服装</option><option value='Food'>食物</option><option value='Book'>图书</option></select></td></tr>-->
			 <%if(("Clothes").equals(pm.getStyle().name())){ %>
				 <tr><td>商品类别:</td> <td><select name='style'><option value='Clothes' selected='true'>服装</option><option value='Food'>食物</option><option value='Book'>图书</option></select></td></tr> 
			 <%}else if(("Food").equals(pm.getStyle().name())){ 
			 %> 
			 <tr><td>商品类别:</td> <td><select name='style'><option value='Clothes'>服装</option><option value='Food' selected='true'>食物</option><option value='Book'>图书</option></select></td></tr>
			 <%}else if(("Book").equals(pm.getStyle().name())){ 
			 %> 
			 <tr><td>商品类别:</td> <td><select name='style'><option value='Clothes'>服装</option><option value='Food'>食物</option><option value='Book' selected='true'>图书</option></select></td></tr>
			 <%} 
			 %> 
			 <tr><td>商品价格:</td> <td><input type='text' name='price' value=<%=pm.getPrice()%>></td></tr> 
			 <tr><td colspan=2 align='center'><input type='submit' value='保存'></td></tr> 		
			 </table> 
			 </form> 
<%         } 
%>	
			
	
</body>
</html>