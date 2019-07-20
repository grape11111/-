<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html>  
<html>  
<head>  
    <meta charset="UTF-8">  
    <title>天天淘购物网</title>  
    <link rel="stylesheet" type="text/css" href="Login.css"/>
    <style>
    a{color:black;
    text-decoration:none;
    }
    </style>  
</head>  
<body>  
    <div id="login">  
        <h1><a href='first.jsp'>天天淘购物网</a></h1>  
        <form action="login"  method="post">  
            <input class="input" type="text" required="required" placeholder="昵称/手机号码" name="name"></input>  
            <input class="input" type="password" required="required" placeholder="密码" name="password"></input>  
            <input type="radio" name="role" value="users" >用户 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="role" value="admin">管理员
            <button class="but" type="submit">登录</button>
            <a href='register.jsp'>没有账号，前去注册</a>
        </form>  
    </div>  
</body>  
</html>  
