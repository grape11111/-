<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="edu.gdut.imis.product.entity.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天淘购物网站</title>
</head>
<%   Admin admin=(Admin)session.getAttribute("admin");%>
<%
if(admin==null){ %>
	<script>alert('账号不存在或者密码输入错误！');window.location.href='/ProductSSH/Login.jsp'</script>"
<%	
}else{
%>
<frameset rows="15%,*" frameborder="0" framespacing="10">
		<frame src="Jsp/BackStage/Top.jsp?user=<%= admin.getaNickname() %>" noresize="noresize" scrolling="yes" />
		<frameset cols="15%,*">
			<frame src="Jsp/BackStage/Left.html" noresize="noresize" />
			<frame src="${pageContext.request.contextPath}/Product_display" name="contain" />
		</frameset>
	</frameset>
<%} %>
</html>
