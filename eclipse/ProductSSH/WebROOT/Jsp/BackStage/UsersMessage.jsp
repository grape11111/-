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
	List<Users>list=(List<Users>)session.getAttribute("userlist");
	 if(list.size()!=0) { 
	%>
			 <table align='center' width='95%' border='1px'> 
			 <tr><td colspan=9 align='center'><b>会员信息</b></td></tr> 
			 <tr>
			 <td>会员编号</td>
			 <td>会员昵称</td>
			 <td>会员姓名</td>
			 <td>性别</td>
			 <td>密码</td>
			 <td>联系方式</td>
			 <td>地址</td>
			 <td>状态</td>
			 <td>操作</td>
			 </tr>
<%			for(Users user:list) {
%>
			    <tr>
				<td><%=user.getuID()%></td>
				<td><%=user.getuNickname()%></td>
				<td><%=user.getuName()%></td>
				<td><%=user.getuSex()%></td>
				<td><%=user.getuPassword()%></td>
				<td><%=user.getuPhone()%></td>
				<td><%=user.getuAddress()%></td>
				<td><%=user.getStatus()%></td>
				<td><a href='${pageContext.request.contextPath}/users_freeze?status=0&uID=<%=user.getuID()%>'><button>冻结账号</button></a>
				
				&nbsp;<a href='${pageContext.request.contextPath}/users_freeze?status=1&uID=<%=user.getuID()%>'><button>解冻账号</button></a></td>
				</tr>
<%         } 
	 }
%>	
			 </table> 
			
	
</body>
</html>