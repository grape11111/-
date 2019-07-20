<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.gdut.imis.product.entity.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.block{
		width: 1300px;
		height: 50px;
		background-color: #eee;
		border-radius: 10px;
		margin: 0 auto;
	}
	h3{
		text-align: center;
		padding-top: 12px;
		font-family: "微软雅黑";
	}
</style>
</head>
<body>
<%   Users user=(Users)session.getAttribute("user");%>
	<div class="block">
		<h3><%= user.getuNickname() %>,欢迎登录天天淘购物网站</h3>
	</div>
</body>
</html>