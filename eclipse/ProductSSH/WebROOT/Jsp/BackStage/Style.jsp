<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类别管理页面</title>
</head>
<body>
	   <table align='center' width='40%' > 
			 <tr> 
			 <th colspan='2'>类别信息</th> 
			 </tr> 
			 <tr><td colspan='2'>----------------------------------------------------------------</td></tr> 
				 <tr> 
					 <td><b>类别名称</b></td> 
					 <td><b>操作</b></td> 
			     </tr>
	<% 
	for(Style style:Style.values()){
	%> 	
                 <tr>
					<td><%= style.getValue()%> (<%= style%>)</td>
					<td><a href=''><button>删除</button></a>&nbsp;<a href=''><button>修改</button></a></td>
				 </tr>
	 <%} %>	
		    <tr><td colspan='2'>----------------------------------------------------------------</td></tr>
		    <tr><td colspan='2'><a href=''><button>添加类别</button></a></td></tr>
	</table>
</body>
</html>