<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>

<link rel="stylesheet" href="css/webStyle.css" media="screen" type="text/css" />
<body>
<h1 class="brand">公交车舒适度评价系统</h1>

<form class="box"  method="post" action="/login">
    <h1>登录管理员后台</h1>
    <%
        //如果request域中有error属性说明刚刚的提交有错误，需要将错误显示出来
        String error = (String) request.getAttribute("error");
        if (error!=null && !"".equals(error)){
    %>
    <p style="text-align: center"><%=error%></p>
    <%
            //错误打印后应该移除，避免重复打印
            request.removeAttribute("error");
        }
    %>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password" >
    <input id="submit" type="submit" value="登录"  name="" onmousemove="over()" onmouseleave="leave()">
    <div style="text-align: center;vertical-align: center">
        <p style="float: left">没有账号？</p>
        <a style="float: right;margin-top: 15px" href="signup.jsp">立即注册</a>
    </div>
</form>

</body>
</html>
