<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系方式</title>
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
            <li class="dropdown" style="margin-left: 15%;position: absolute">
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
            <li style="margin-left: 25%;position: absolute">
                <a href="accbyday.jsp">振动舒适度评价</a>
            </li>
            <li style="margin-left: 35%;position: absolute">
                <a href="tembyday.jsp">温度舒适度评价</a>
            </li>
            <li style="margin-left: 45%;position: absolute">
                <a href="humbyday.jsp">湿度舒适度评价</a>
            </li>
            <li style="margin-left: 55%;position: absolute">
                <a href="totalbyday.jsp">舒适度总评价</a>
            </li>
            <li class="dropdown active" style="margin-left: 65%;position: absolute">
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
<div class="container-fluid">
    <div class="container-fluid">
        <div class="col-md-9"  id="notifyBody">
            <div style="margin-top: 25%;width: 40%;margin-left: 60%;transform: translate(-50%,-50%)">
                <h1>
                    联系方式
                </h1>
                <br><br><br><br>
                <h3>电话：XXXXXXXXXXXXXXXXXX</h3>
                <br>
                <h3>邮箱：XXXXXXXXXXXXXXXX.com</h3>
                <br>
                <h3>QQ：XXXXXXXXXXXXXXXXXX</h3>
                <br>
                <h3>地址：XXXXXXXXXXXXXXXXXX</h3>
            </div>
        </div>
        <div class="col-md-3">
            <br><br><br>
            <div>
                <h3>联系我们</h3>
                <ul>
                    <br>
                    <li style="font-size: 80%">
                        <a href="contact.jsp" style="font-size: 150%;">联系方式</a>
                    </li>
                    <br>
                    <li style="font-size: 80%">
                        <a href="comment.jsp" style="font-size: 150%;">在线联系</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

</body>
</html>
