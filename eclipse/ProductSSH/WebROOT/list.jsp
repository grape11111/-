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
<%  List<ProductModel>list=(List<ProductModel>)session.getAttribute("result");
	Cookie[] allcookies=request.getCookies();
	 if(session.getAttribute("user")!=null) { 
%>
			<p>你浏览过的商品有：&nbsp;		
<%				
				String id=((Users) session.getAttribute("user")).getuID();
				for(int i=0;i<allcookies.length;i++) {
					if(allcookies[i].getName().indexOf(id+"product")!=0) 
						continue;
%>					
				<%= allcookies[i].getValue()%>
<%				}
	 }else{%>
		 <p>你浏览过的商品有：&nbsp;		
<%				
				for(int i=0;i<allcookies.length;i++) {
					if(allcookies[i].getName().indexOf("product")!=0) 
						continue;
%>					
				<%= allcookies[i].getValue()%>
<%	 			}
		 }
%>
			</p>
<!-- 布局：一张表格里面放置两张表格，左边显示所有商品，右边为查询框 -->			
	<table width='95%'>
	   <tr><td width='60%'>
			
			<table align='left' width='95%' border='1px' style="line-height:50px;"> 

			 <tr><td colspan=5 align='center'><b>商品名称</b></td></tr> 
			 <tr > 
<%			for(int i=0;i<list.size();i++) {
%>
				<td><a href='/ProductSSH/detail?code=<%= list.get(i).getCode()%>' target='contain'><%= list.get(i).getName()%></a></td>					
<%			   if((i+1)%5==0) { %>
				  </tr><tr>
<%			   }
			}
 %>
    		</tr>
			</table> 
			 
	   </td><td width='40%'>
			 
			<form action="/Product/Product" method="post">
				<input type="hidden" name="submitFlag" value="query">
			<table width=70%  align="center" style="line-height:30px;">
			<th colspan='2' text-align:center>商品查询</th>
			<tr>
				<td>商品名称:</td> 
				<td> <input type="text" name="name" value="" autocomplete="off"></td>
			</tr>
			<tr>
				<td>商品类别:</td> 
				<td><select name="style">
						<option value="Clothes">服装</option>
						<option value="Food">食物</option>
						<option value="Book">图书</option>
						<option value=" ">全部</option>
				</select></td>
			</tr>	
			<tr>
				<td>商品价格:</td>
				<td><input type="text" name="pricegt" size="6px" align='left'>
				 ~ 
				<input type="text" name="pricelt" size="6px" align='right'>
				</td>		
			</tr>
			<tr>
				<td></td> 
				<td></td>
			</tr>
			<tr>
				<td></td> 
				<td align:center><input type="submit" value="确定">&nbsp;<input type="reset" value="重置"></td>
			</tr>
			</table>
			</form>			 
	</tr>
	</table>

</body>
</html>