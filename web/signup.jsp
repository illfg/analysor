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
    <title>管理员账号注册</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/webStyle.css" media="screen" type="text/css" />
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="home.jsp">查询系统</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li class="dropdown active" style="margin-left: 15%;position: absolute">
                <a href="home.jsp" class="dropdown-toggle" data-toggle="dropdown">系统信息<strong class="caret"></strong></a>
                <ul class="dropdown-menu">

                    <li>
                        <a href="login.jsp">登录</a>
                    </li>
                    <%--  <li class="divider">
                      </li>--%>
                    <li>
                        <a href="signup.jsp">注册</a>
                    </li>
                </ul>
            </li>
            <li  style="margin-left: 25%;position: absolute">
                <a href="accbyday.jsp">振动舒适度评价</a>
            </li>
            <li  style="margin-left: 35%;position: absolute">
                <a href="tembyday.jsp">温度舒适度评价</a>
            </li>
            <li  style="margin-left: 45%;position: absolute">
                <a href="humbyday.jsp">湿度舒适度评价</a>
            </li>
            <li  style="margin-left: 55%;position: absolute">
                <a href="totalbyday.jsp">舒适度总评价</a>
            </li>
            <li class="dropdown" style="margin-left: 65%;position: absolute">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">联系我们<strong class="caret"></strong></a>
                <ul class="dropdown-menu">

                    <li >
                        <a href="contact.jsp">联系方式</a>
                    </li>
                    <%--  <li class="divider">
                      </li>--%>
                    <li>
                        <a href="comment.jsp">在线留言</a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>

</nav>

<h1 style="text-align: center;margin-top: 10%">管理员账号注册</h1>

<div class="container" style="margin-top: 10%;text-align: center;width: 30%;margin-left: 50%;transform: translate(-50%,-50%);">
   <form action="/signup" method="post">
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
       <input style="margin-top: 20px" class="form-control" type="text"  id="username" name="username" placeholder="请输入用户名">
       <input style="margin-top: 20px" type="password" class="form-control" id="password1" name="password1" placeholder="请输入密码">
       <input style="margin-top: 20px" type="password" class="form-control" id="password2" name="password2" placeholder="请再次输入密码">
       <p style="margin-top: 20px">性别</p>
       <div>
           <label class="radio-inline">
               <input type="radio" name="sex" id="optionsRadios3" value="男" checked> 男
           </label>
           <label class="radio-inline">
               <input type="radio" name="sex" id="optionsRadios4"  value="女"> 女
           </label>
       </div>
       <input style="margin-top: 20px" type="submit" class="submitBottom" value="提交">
   </form>
</div>

</body>
</html>
