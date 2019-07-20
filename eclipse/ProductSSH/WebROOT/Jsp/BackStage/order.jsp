<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单管理</title>
</head>
<body>
	<%
	List<Order>list=(List<Order>)session.getAttribute("orderlist");
	 if(list.size()!=0) { 
	%> 
	<table align='center' width='60%' border='1px'> 
		<tr><td colspan=5 align='center'><b>平台订单信息</b></td></tr> 
		<tr>
			<td>订单编号</td>
			<td>会员编号</td>
			<td>下单时间</br>
			<td>支付状态</td>
			<td>操作</td>
			 </tr>
<%			for(int i=0;i<list.size();i++) {
%>
			    <tr>
				<td><a href='${pageContext.request.contextPath}/Pay_detail?orderID=<%=list.get(i).getOrderID()%>&uID=<%= list.get(i).getuID()%>'><%=list.get(i).getOrderID()%></a></td>
				<td><%=list.get(i).getuID()%></td>
				<td><%=list.get(i).getDatetime()%></td>
				<%
				if(list.get(i).getStatus()==0){
				%>
					<td>未支付</td>
					<td> </td>
				<%
				}else if(list.get(i).getResult()==0){
				%>
					<td>已支付</td>
					<td><a href='${pageContext.request.contextPath}/Pay_check?orderID=<%=list.get(i).getOrderID()%>'><button>执行</button></a></td>
				<%
				}else{
				%>
					<td>已支付</td>
					<td>已执行</td>
				<%
				}
				%>
				</tr>
<%         } 
	 }
%>	
			 </table> 
			
	
</body>
</html>