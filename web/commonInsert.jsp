<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/15/2020
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日数据输入</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<div style="width: 70%;margin-left: 15%">
    <h1 style="margin-top: 10%;text-align: center">管理员后台</h1>
    <ul style="margin-top: 25px" class="nav nav-tabs">
        <li >
            <a href="/mes">评论</a>
        </li>
        <li>
            <a href="temInsert.jsp">温度数据输入</a>
        </li>
        <li>
            <a href="humInsert.jsp">湿度数据输入</a>
        </li>
        <li >
            <a href="/accInput.jsp">加速度数据输入</a>
        </li>
        <li class="active">
            <a href="/commonInsert.jsp">日数据输入</a>
        </li>
        <li class="dropdown pull-right">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">退出<strong class="caret"></strong></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="home.jsp">退出到主页</a>
                </li>
            </ul>
        </li>
    </ul>

    <div class="alert alert-success" style="margin-top: 30px">注意 请按格式填写</div>


    <p style="margin-top: 30px">日数据输入</p>
    <%
        //如果request域中有hum属性说明刚刚的有提交，需要将结果信息显示出来
        String info2 = (String) request.getAttribute("info");
        if (info2 !=null && !"".equals(info2)){
    %>
    <p style="text-align: center"><%=info2%></p>
    <%
            //信息打印后应该移除，避免重复打印
            request.removeAttribute("info");
        }
    %>
    <form action="/commonInsert" method="post" style="width: 60%">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="车牌号" name="number">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="湿度 浮点数" name="hum">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="温度 浮点数" name="tem">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="加速度 浮点数" name="acc">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="年份：yyyy " name="year">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="月份：MM" name="month">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="周数：W" name="week">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="天数：dd(30天制)" name="day">
        <input class="btn btn-primary btn-lg" style="margin-top: 20px" type="submit" value="提交">
    </form>

</div>

</body>
</html>
