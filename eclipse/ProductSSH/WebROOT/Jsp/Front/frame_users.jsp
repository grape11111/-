<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="edu.gdut.imis.product.entity.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天淘购物网站</title>
</head>
<%   Users user=(Users)session.getAttribute("user");
if(user==null){ %>
	<script>alert('账号不存在或者密码输入错误！');window.location.href='/ProductSSH/Login.jsp'</script>"
<%
}else{
	if(user.getStatus()==0){%>
		<script>alert('该账号被冻结了！');window.location.href='/ProductSSH/Login.jsp'</script>"
<%  }else{
%>
<frameset rows="15%,*" frameborder="0" framespacing="10">
		<frame src="Jsp/Front/Top.jsp?user=<%= user.getuNickname() %>" noresize="noresize" scrolling="yes" />
		<frameset cols="15%,*">
			<frame src="Jsp/Front/Left_users.html" noresize="noresize" />
			<frame src="${pageContext.request.contextPath}/Product_displayAll" name="contain" />
		</frameset>
	</frameset>
<%} 
}%>
</html>
