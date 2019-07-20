<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员信息</title>
</head>
<body>
<% Users user=(Users)session.getAttribute("user"); %>
    <form action="${pageContext.request.contextPath}/register_alter"  method="post"  class="am-form-inline" role="form" >
<center>
    <h3>会员信息:</h3>
<div>
   会员编号：<input type="text"  value="${user.uID}" name="uID"  readonly=”readonly”>
</div>
<br/>
<br/>
<div >
   昵 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" value="${user.uNickname}" name="uNickname">
</div>
<br/>
<br/>
<div class="am-form-group">
    姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" class="am-form-field" value="${user.uName}"  name="uName">
</div>
<br/>
<br/>
<%if(("女").equals(user.getuSex())){ %>
<div class="am-form-group">
    性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<select name='uSex'><option value='女' selected='true'>女</option><option value='男'>男</option></select>
</div>
<%}else if(("男").equals(user.getuSex())){ 
%> 
<div class="am-form-group">
   性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<select name='uSex'><option value='女'>女</option><option value='男' selected='true'>男</option></select>
</div>
<%} 
%> 
<br/>
<br/>
<div class="am-form-group">
密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" class="am-form-field" value="${user.uPassword}"  name="uPassword">
</div>
<br/>
<br/>
<div class="am-form-group">
联系方式：<input type="text" class="am-form-field" value="${user.uPhone}"  name="uPhone">
</div>
<br/>
<br/>
<div class="am-form-group">
   地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="textArea" class="am-form-field" value="${user.uAddress}"  name="uAddress">
</div>
<br/>
<br/>
  <div class="am-form-group">
    <button class="but" type="submit">确定</button> 
  </div>
</center>

</form>

</body>
</html>