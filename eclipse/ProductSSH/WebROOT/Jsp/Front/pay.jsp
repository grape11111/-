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
<title>结算页面</title>
</head>
<body>
	<% 
	Users user=(Users)session.getAttribute("user");
	List<Cartproduct> list=(List<Cartproduct>)session.getAttribute("cartMap");
	String OrderNumber=(String)session.getAttribute("OrderNumber");
	String datetime=(String)session.getAttribute("datetime");
	%>
	 <table align='center' width='60%' border='1'> 
			 <tr> 
			 <th colspan='3'>结算订单</th> 
			 </tr> 
			 <tr> 
			 <td text-align='left'><b>用户名：</b>${user.uNickname}</td>
			 <td text-align='left'><b>联系方式：</b>${user.uPhone}</td> 
			 <td text-align='left'><b>地址：</b>${user.uAddress}</td>  
			 </tr> 
			 <tr> 
			 <td text-align='left'><b>订单编号：</b><%= OrderNumber%></td> 
			 <td colspan='2' text-align='left'><b>时间：</b><%=datetime %></td> 
			 </tr> 
				 <tr> 
				 <td><b>商品名称</b></td> 
				 <td><b>价格</b></td> 
				 <td><b>数量</b></td> 
				 </tr> 	
<%
        String[]codes=request.getParameterValues("productcode");
		Float totalprice=0f;
		for(int i=0;i<codes.length;i++) {
			for(Cartproduct cp:list){
				if(codes[i].equals(cp.getCode())) {
					String productName=cp.getPm().getName();
					Float price=cp.getPm().getPrice();
					int count=cp.getCount();
 %>
                <tr>
					<td><%=productName%></td>
					<td><%=price%></td>
					<td><%=count%></td>
				</tr>	
<%						totalprice+=price*count;
						break;
				}
			}
		}
%>
		<tr><td colspan='3' text-align='right'><b>商品总价为：</b><%= totalprice %></td></tr>
		<tr><td colspan='3'><a href='${pageContext.request.contextPath}/Pay_paid?orderID=<%=OrderNumber%>'><button>支付</button></a></td></tr>
	</table>
</body>
</html>