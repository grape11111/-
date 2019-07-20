<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.common.myTaglib.PageTag,edu.gdut.imis.product.business.factory.EBOFactory" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ taglib uri="/gdut.edu.cn/myTaglib" prefix="gdut" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品一览</title>
</head>
<body>
<jsp:useBean id="pb" class="edu.gdut.imis.product.common.PageBean" scope="session"/>
<jsp:setProperty property="currPage" name="pb"/>
	<% 
	List<ProductModel>list=(List<ProductModel>)session.getAttribute("result");
	
	 if(list!=null) { 
	%>
			 <table align='center' width='60%' border='1px'> 
			 <tr><td colspan=5 align='center'><b>商品信息</b></td></tr> 
			 <tr>
			 <td>商品条码</td>
			 <td>商品名称</td>
			 <td>商品类别</br>
			 <td>商品价格</td>
			 <td>操作</td>
			 </tr>
<gdut:page var="bm" list="${result}" pb="${pb}">

			    <tr>
				<td>${bm.code}</td>
				<td>${bm.name}</td>
				<td>${bm.style.value}</td>
				<td>${bm.price}</td>
				<td><a href='${pageContext.request.contextPath}/Product_delete?pm.code=${bm.code}'><button>删除</button></a>
				
				&nbsp;<a href='${pageContext.request.contextPath}/Product_toUpdate?pm.code=${bm.code}'><button>修改</button></a></td>
				</tr>
</gdut:page>
<%         
	 }else{%>
		 <h3>天天淘购物网站后台</h3>
	<% }
%>	
			 </table> 
			
	
</body>
</html>