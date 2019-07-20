<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天淘购物网站</title>
</head>

<frameset rows="15%,*" frameborder="0" framespacing="10">
		<frame src="Top.jsp" noresize="noresize" scrolling="yes" />
		<frameset cols="15%,*">
			<frame src="Left.html" noresize="noresize" />
			<frame src="list.jsp?pages=1" name="contain" />
		</frameset>
	</frameset>
</html>
