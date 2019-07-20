<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
</head>
<body>
<%
	//用户退出登录时移除会话
	session.removeAttribute("user");
    session.removeAttribute("admin");
	//session.removeAttribute("id");
	out.print("<script type='text/javascript'>alert('用户退出成功!');window.location.href='Login.jsp';</script>");
%>
</body>
</html>
