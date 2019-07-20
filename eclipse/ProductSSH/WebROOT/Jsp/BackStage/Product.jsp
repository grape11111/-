<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body{
text-align:center;
} 

.column {
    margin-left: 300px;
    padding: 15px;
    width:25%;
}			
.menu ul {
    list-style-type: none;
}
.menu li a {
    margin-bottom: 12px;
    display: block;
    padding: 15px;
    background-color: #eee;
    text-decoration: none;
    color: #666;
}
.menu li a:hover {
    background-color: #555;
    color: white;
}
.menu li a.active {
    background-color: #008CBA;
    color: white;
}
</style>
</head>
<body>
    <div class="column menu">
    <h3>商品增删查改系统</h3>
	<ul class="nav nav-pills nav-stacked">
	<li><a href="Query.html" class="active">查询</a></li>
	<li><a href="AddProduct.html">添加</a></li>
	<li><a href="${pageContext.request.contextPath}/Product_display" class="active">删除</a></li>
	<li><a href="${pageContext.request.contextPath}/Product_display" >修改</a></li>
	</ul>
</div>
</body>
</html>
