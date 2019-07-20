<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script type="text/javascript">
			function del() {
				if(!confirm("确认要删除？")) {
					window.event.returnValue = false;
				}
			}
		</script>
		<title>图书管理系统</title>
		<style>
* {
    box-sizing: border-box;
}
body {
    margin: 0;
}
.header {
    background-color: white;
    color: black;
    text-align: center;
    padding: 15px;
}

.topmenu {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #777;
}
.topmenu li {
    float: center;
    display: inline-block;
}
.topmenu li h2 {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 16px;
    text-decoration: none;
}

.column {
    float: left;
    padding: 15px;
}
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
.sidemenu {
    width: 25%;
}
.content {
    width: 75%;
}
.sidemenu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.sidemenu li a {
    margin-bottom: 4px;
    display: block;
    padding: 8px;
    background-color: #eee;
    text-decoration: none;
    color: #666;
}
.sidemenu li a:hover {
    background-color: #555;
    color: white;
}
.sidemenu li a.active {
    background-color: #008CBA;
    color: white;
}
</style>
	</head>

	<body>
<div class="column content">
    <div class="header">
      <h1>天天淘购物网站使用须知</h1>
    </div>
    <h1>Chania</h1>
    <p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>
    <p>You will learn more about responsive web pages in a later chapter.</p>
   
  </div>
</div>
	</body>

</html>