<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="edu.gdut.imis.product.entity.*,java.util.*,edu.gdut.imis.product.business.factory.EBOFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册会员信息</title>
<script>
var xmlhttp;
var text="";
function check(){
  var upassword1 = document.getElementById("uPassword1").value;
  var upassword2 = document.getElementById("uPassword2").value;
  if(""==upassword2){
	  document.getElementById('password').innerHTML="<font color='grey'>请确认密码!</font>"; 
  }
  if(""!==upassword2&&upassword1!=upassword2){
	  document.getElementById('password').innerHTML="<font color='red'>两次密码不一致！</font>";
  }
  if(upassword1==upassword2){
	  document.getElementById('password').innerHTML="<font color='grey'>ok!</font>";
  }
}
</script>

</head>
<body>
    <form action="${pageContext.request.contextPath}/register_register"  method="post"  class="am-form-inline" role="form" >
<center>
    <h3>注册会员信息:</h3>
<div >
   昵 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="user.uNickname">
</div>
<br/>
<br/>
<div class="am-form-group">
    姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" class="am-form-field" name="user.uName">
</div>
<br/>
<br/>
<div class="am-form-group">
    性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<select name='user.uSex'><option value='女' selected='true'>女</option><option value='男'>男</option></select>
</div>
<br/>
<br/>
<div class="am-form-group">
密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="user.password" class="am-form-field" name="uPassword" id="uPassword1">
</div>
<br/>
<br/>
<div class="am-form-group">
确认密码： <input type="password" class="am-form-field" onblur="check()" name="user.uPassword" id="uPassword2">
</div><span id="password"></span>
<br/>
<br/>
<div class="am-form-group">
联系方式： <input type="text" class="am-form-field" name="user.uPhone">
</div>
<br/>
<br/>
<div class="am-form-group">
   地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="textArea" class="am-form-field"  name="user.uAddress">
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